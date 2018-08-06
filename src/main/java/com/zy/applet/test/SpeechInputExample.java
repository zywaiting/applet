package com.zy.applet.test;

import ai.olami.cloudService.*;
import ai.olami.nli.NLIResult;
import ai.olami.util.GsonFactory;
import com.google.gson.Gson;
import com.zy.applet.utils.ByteToInputStreamUtils;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SpeechInputExample {

    // * Replace your APP KEY
    private static String appKey = "65ac1c2b770a4cc08c21a9ef1fca50b5";
    // * Replace your APP SECRET
    private static String appSecret = "eec4076b2f2a4d2dbeb0bec46eef8aa2";

//	private static String inputFilePath = "D:\\test.pcm";

    // pcm AUDIO_TYPE_PCM_RAW   wav AUDIO_TYPE_PCM_WAVE
//    private static int audioType = SpeechRecognizer.AUDIO_TYPE_PCM_WAVE;
	private static int audioType = SpeechRecognizer.AUDIO_TYPE_PCM_RAW;

    // * Replace FALSE with this variable if your test file is not final audio.
    private static boolean isTheLastAudio = true;

    // * Replace the localize option you want with this variable.
    // * - Use LOCALIZE_OPTION_SIMPLIFIED_CHINESE for China
    // * - Use LOCALIZE_OPTION_TRADITIONAL_CHINESE for Taiwan
    private static int localizeOption = APIConfiguration.LOCALIZE_OPTION_SIMPLIFIED_CHINESE;
//	private static int localizeOption = APIConfiguration.LOCALIZE_OPTION_TRADITIONAL_CHINESE;

    public static void main(String[] args) throws Exception {

        InputStream inputStream = new URL("http://wq-zy.oss-cn-hangzhou.aliyuncs.com/picture/test.pcm").openStream();
        byte[] audioBuffer = ByteToInputStreamUtils.input2byte(inputStream);

//        if (args.length == 5) {
//            initByInputArgs(args);
//        } else if (args.length > 0) {
//            printUsageAndExit();
//        }

        Gson jsonDump = GsonFactory.getDebugGson(false);

//        if (Files.notExists(Paths.get(inputFilePath))) {
//            System.out.println("\nError: File not found! " + inputFilePath);
//            System.exit(0);
//        }

        // * Step 1: Configure your key and localize option.
        APIConfiguration config = new APIConfiguration(appKey, appSecret, localizeOption);

        // * Step 2: Create the text recognizer.
        SpeechRecognizer recoginzer = new SpeechRecognizer(config);

        // * Optional steps: Setup some other configurations.
        recoginzer.setEndUserIdentifier("Someone");
        recoginzer.setTimeout(10000);

        // EXAMPLE: Request speech recognition for single audio file.
//        System.out.println("\n[Send Audio] ================================");
//        System.out.print("\nRequest speech recognition for : " + inputFilePath);

        // * Prepare to send audio by a new task identifier.
        CookieSet cookie = new CookieSet();
//        System.out.println(" by CookieSet[" + cookie.getUniqueID() + "]");

        // * Start sending audio.
//        APIResponse response = recoginzer.uploadAudio(cookie, inputFilePath, audioType, isTheLastAudio);
        //
        // You can also send audio data from a buffer (in bytes).
        //
        // For Example :
        // ===================================================================
        // byte[] audioBuffer = Files.readAllBytes(Paths.get(inputFilePath));
         APIResponse response = recoginzer.uploadAudio(cookie, audioBuffer, audioType, isTheLastAudio);
        // ===================================================================
        //
//        System.out.println("\nOriginal Response : " + response.toString());
//        System.out.println("\n---------- dump ----------\n");
//        System.out.println(jsonDump.toJson(response));
//        System.out.println("\n--------------------------\n");

        // Check request status.
        int n = 0;
        if (response.ok()) {
            // Now we can try to get recognition result.
//            System.out.println("\n[Get Speech Result] =====================");
            while (true) {
                Thread.sleep(500);
                System.out.println(n++);
                // * Get result by the task identifier you used for audio upload.
//                System.out.println("\nRequest CookieSet[" + cookie.getUniqueID() + "] speech result...");
                response = recoginzer.requestRecognitionWithAll(cookie);
                //
                // You can also send text with NLIConfig to append "nli_config" JSON object.
                //
                // For Example,
                // try to replace 'requestRecognitionWithAll(cookie)' with the following sample code:
                // ===================================================================
                // NLIConfig nliConfig = new NLIConfig();
                // nliConfig.setSlotName("myslot");
                // response = recoginzer.requestRecognitionWithAll(cookie, nliConfig);
                // ===================================================================
                //
                System.out.println("\nOriginal Response : " + response.toString());
//                System.out.println("\n---------- dump ----------\n");
//                System.out.println(jsonDump.toJson(response));
//                System.out.println("\n--------------------------\n");
                // Check request status.
                if (response.ok() && response.hasData()) {
                    // * Check to see if the recognition has been completed.
                    SpeechResult sttResult = response.getData().getSpeechResult();
                    if (sttResult.complete()) {
                        // * Get speech-to-text result
                        System.out.println("* STT Result : " + sttResult.getResult());
                        // Because we used requestRecognitionWithAll()
                        // So we should be able to get more results.
                        // --- Like the Word Segmentation.
                        if (response.getData().hasWordSegmentation()) {
                            String[] ws = response.getData().getWordSegmentation();
                            for (int i = 0; i < ws.length; i++) {
                                System.out.println("* Word[" + i + "] " + ws[i]);
                            }
                        }
                        // --- Or the NLI results.
                        if (response.getData().hasNLIResults()) {
                            NLIResult[] nliResults = response.getData().getNLIResults();
                            //
                            // You can parse NLI results here and do something.
                            //
                            // ================================================
                            // In this example, we will dump NLI results.
                            //
//                            DumpNLIResultsExample.dumpNLIResults(nliResults);
                            //
                            // See also: /examples/dump-nli-results-example/
                            // ================================================
                        }
                        // * Done.
                        break;
                    } else {
                        // The recognition is still in progress.
                        // But we can still get immediate recognition results.
                        System.out.print("* STT Result [Not yet completed] ");
                        System.out.println(" --> " + sttResult.getResult());
                    }
                }
            }
        } else {
            // Error
            System.out.println("* Error! Code : " + response.getErrorCode());
            System.out.println(response.getErrorMessage());
        }

        System.out.println("\n===========================================\n");
    }

    private static void printUsageAndExit() {
        System.out.println("\n Usage:");
        System.out.println("\t args[0]: your_app_key");
        System.out.println("\t args[1]: your_app_secret");
        System.out.println("\t args[2]: localize_option=[0|1]");
        System.out.println("\t args[3]: the_path_of_audio_file_you_want_to_test");
        System.out.println("\t args[4]: is_the_last_audio=[0|1]");
        System.out.println("\n");
        System.exit(0);
    }

//    private static void initByInputArgs(String[] args) {
//        appKey = args[0];
//        appSecret = args[1];
//        localizeOption = Integer.parseInt(args[2]);
//        inputFilePath = args[3];
//        isTheLastAudio = args[4].equals("1");
//    }

}

