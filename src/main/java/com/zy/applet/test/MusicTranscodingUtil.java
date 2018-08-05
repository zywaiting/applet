package com.zy.applet.test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import org.nutz.lang.Encoding;
import org.nutz.lang.Lang;

import org.apache.commons.codec.binary.Base64;
public class MusicTranscodingUtil {

    /**
     * 8000K采样频率
     */
    public static final int HZ_8K = 8000;
    /**
     * 16000K采样频率
     */
    public static final int HZ_16K = 16000;
    /**
     * 音频后缀
     */
    public static final String AUDIO_SUFFIX_WEBM = "webm";
    public static final String AUDIO_SUFFIX_WAV = "wav";
    public static final String AUDIO_SUFFIX_PCM = "pcm";


    /**
     * 通过filePath内容判断是否是webm/base64格式，如果是，先decode base64后，再直接ffmpeg转wav，
     * 如果不是，返回3  丢给 getPcm方法 当作silk v3去解
     * @param filePath  解码前的路径
     * @param afterFilePath  解码后的路径
     * @return  0:真  1:不存在;  2:读取文件出错;  3：不是base64加密文件;  4：base64解码出错;  5 ： 解码后写入新的文件出错;  6：读取目标文件出错;
     */
    public static int webmBase64Decode2Wav (String filePath,String afterFilePath) {

        int HttpResult; // 服务器返回的状态
        int isWebm = 0;
        try {
            StringBuilder lineTxt = new StringBuilder();
            String line = null;
            try {
                URL url =new URL(filePath); // 创建URL
                URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
                urlconn.connect();
                HttpURLConnection httpconn =(HttpURLConnection)urlconn;
                HttpResult = httpconn.getResponseCode();
                if(HttpResult != HttpURLConnection.HTTP_OK) {
                    System.out.print("无法连接到");
                } else {
                    int filesize = urlconn.getContentLength(); // 取数据长度
                    InputStreamReader read = new InputStreamReader(urlconn.getInputStream(),"UTF-8");
                    BufferedReader bufferedReader = new BufferedReader(read);
                    while ((line = bufferedReader.readLine()) != null) {
                        lineTxt.append(line);
                    }
                    read.close();
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("读取文件出错:"+e);
                return 2;
            }

            String oldData = lineTxt.toString();
            if (oldData.startsWith("data:audio/webm;base64,") == false) {
                System.out.println("不是base64加密文件 :" );
                return 3;
            }
            isWebm = 0;
            oldData = oldData.replace("data:audio/webm;base64,", "");
            try {
                File webmFile = new File(afterFilePath);
                byte[] bt = Base64.decodeBase64(oldData);
                FileOutputStream in = new FileOutputStream(webmFile);
                try {
                    in.write(bt, 0, bt.length);
                    in.close();
                } catch (IOException e) {
                    System.out.println("解码后写入新的文件出错："+e);
                    return 5;
                }
            } catch (FileNotFoundException e) {
                System.out.println("base64解码出错 :"+ e);
                return 4;
            }
        } catch (Exception e) {
            System.out.println("读取目标文件出错："+e);
            return 6;
        }
        return isWebm;
    }

    /**
     * 将  xxxxx.silk 文件名转 xxxx.wav
     * @param recName
     * @param otherSubFix
     * @return
     */
    public static String DotMp3OrDotSilk2DotOther(String recName, String otherSubFix) {
        int removeByte = 4;
        if (recName.endsWith("silk")) {
            removeByte = 4;
        } else if (recName.endsWith("slk") || recName.endsWith("mp3")) {
            removeByte = 3;
        }
        return recName.substring(0, recName.length()-removeByte) + otherSubFix;
    }


    /**
     * webm 转码为 wav
     * @param webmPath	webm的路径
     * @param wavPath   生成wav的路径
     * @param samplingRate  采样率 8k:8000  16k:16000  采用16k
     * @throws IOException
     */
    public static void silkToWav(String webmPath,String wavPath,int samplingRate) throws IOException{
        String command = null;
        if(getOperatingSystem().contains("Windows")){
            // ffmpeg -y -f s16le -ar 24000 -ac 1 -i "$1.pcm" -f wav -ar 16000 -b:a 16 -ac 1 "${1%.*}.$2"
            command = "cmd.exe /c C:\\ffmpeg.exe -y -i "+webmPath+" -ar "+samplingRate+" -vcodec libx264 -ac 1 "+wavPath;
        }else{
            command = "/usr/local/ffmpeg/bin/ffmpeg -y -i "+webmPath+" -ar "+samplingRate+" -vcodec libx264 -ac 1 "+wavPath;
        }
        System.out.println("格式转换："+command);
        Process videoProcess = Runtime.getRuntime().exec(command);
    }
    /**
     * pcm 转码为 wav
     * @param pcmPath	webm的路径
     * @param wavPath   生成wav的路径
     *  samplingRate  采样率 8k:8000  16k:16000  采用16k
     * @throws IOException
     */
    public static boolean pcmToWav(String pcmPath,String wavPath) throws IOException{
        boolean flag = true;
        System.out.println("转码到wav...");
        try {
            //-acodec pcm_s16le -ar 16000|8000 根据百度语音返回的语音清晰度来调整 我的是8000的时候出现前面半秒左右的时间没有识别 16000可以
            StringBuilder sb = Lang.execOutput("cmd /c C:\\ffmpeg.exe -y -f s16le -ar 24000 -ac 1 -i "+pcmPath+" -acodec pcm_s16le -ar 16000 -ac 1 "+wavPath+"", Encoding.CHARSET_GBK);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
    /**
     * 解码为wav格式
     * @param silk 源silk文件,需要绝对路径!! 例:F:\zhuanma\vg2ub41omgipvrmur1fnssd3tq.silk
     * 		  该方法生成后的文件路径和解析前的路径一样 后缀改为.wav格式  采样率为16K
     * @return
     */
    public static boolean getWav(String silk){
        boolean flag = true;
        String cmd= "";
        cmd="sh /data/silk-v3-decoder-master/converter.sh "+silk+" wav";
        System.out.println("转码到wav...");
        try
        {
            StringBuilder msg = Lang.execOutput(cmd, Encoding.CHARSET_UTF8);
            System.out.println(msg);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("silk_v3_decoder转码出错："+e.getMessage());
            flag = false;
        }
        return flag;
    }
    /**
     * 解码为pcm格式
     * @param silk 源silk文件,需要绝对路径!! 例:F:\zhuanma\vg2ub41omgipvrmur1fnssd3tq.silk
     * @param pcm 目标pcm文件,需要绝对路径!! 例:F:\zhuanma\vg2ub41omgipvrmur1fnssd3tq.pcm
     * @return/usr/local/ffmpeg/bin/silk_v3
     */
    public static boolean getPcm(String silk,String pcm){
        boolean flag = true;
        String cmd= "";
        cmd="cmd.exe /c C:\\silk_v3_decoder.exe "+silk+" "+pcm+" -quiet";
        System.out.println("转码到pcm...");
        try
        {
            StringBuilder msg = Lang.execOutput(cmd, Encoding.CHARSET_UTF8);
            System.out.println(msg);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("silk_v3_decoder转码出错："+e.getMessage());
            flag = false;
        }
        return flag;
    }
    /**
     * 获取当前操作系统
     * @return
     */
    public static String getOperatingSystem() {
        Properties props=System.getProperties(); //获得系统属性集
        String osName = props.getProperty("os.name"); //操作系统名称
        return osName;
    }

    public static void main(String[] args) throws IOException {
        String path = "D:\\360Downloads\\1512111790869.silk";
        String webmPath = DotMp3OrDotSilk2DotOther(path,MusicTranscodingUtil.AUDIO_SUFFIX_WEBM);
        String wavPath = DotMp3OrDotSilk2DotOther(path,MusicTranscodingUtil.AUDIO_SUFFIX_WAV);
        String pcmPath = DotMp3OrDotSilk2DotOther(path,MusicTranscodingUtil.AUDIO_SUFFIX_PCM);

        int fanhui = webmBase64Decode2Wav(path,pcmPath);
        if(fanhui==0) {
            silkToWav(webmPath,wavPath,MusicTranscodingUtil.HZ_16K);
        }else if(fanhui==3) {
            if(getOperatingSystem().contains("Windows")){
                boolean is = getPcm(path,pcmPath);
                if(is) {
                    System.out.println("转码成功");
                }
            }else {
                boolean is = getWav(path);
                if(is) {
                    System.out.println("转码成功");
                }
            }

        }
        pcmToWav(pcmPath,wavPath);
    }


}
