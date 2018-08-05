package com.zy.applet.test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class FileCopy {
    public static void fileCopy() {
        FileInputStream input = null;
        FileOutputStream output = null;

        try {

            input = new FileInputStream(new File("http://wq-zy.oss-cn-hangzhou.aliyuncs.com/picture/%E5%B0%8F%E7%A8%8B%E5%BA%8F%E4%BF%A1%E6%81%AF.txt"));
            output = new FileOutputStream(new File("G:\\"));

            byte[] bt = new byte[1024];
            int realbyte = 0;
            /**      input.read(bt)
             * Reads up to <code>b.length</code> bytes of data from this input
             * stream into an array of bytes. This method blocks until some input
             * is available.
             *
             * @param      b   the buffer into which the data is read.
             * @return     the total number of bytes read into the buffer, or
             *             <code>-1</code> if there is no more data because the end of
             *             the file has been reached.
             * @exception  IOException  if an I/O error occurs.
             */
            while ((realbyte = input.read(bt)) > 0) {

                /**   output.write(bt,0,realbyte)
                 * Writes <code>len</code> bytes from the specified byte array
                 * starting at offset <code>off</code> to this file output stream.
                 *
                 * @param      b     the data.
                 * @param      off   the start offset in the data.
                 * @param      len   the number of bytes to write.
                 * @exception  IOException  if an I/O error occurs.
                 */
                output.write(bt,0,realbyte);
            }

            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static String openFile(String filePath) {
        int HttpResult; // 服务器返回的状态
        String ee = new String();
        try
        {
            URL url =new URL(filePath); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn =(HttpURLConnection)urlconn;
            HttpResult = httpconn.getResponseCode();
            if(HttpResult != HttpURLConnection.HTTP_OK) {
                System.out.print("无法连接到");
            } else {
                int filesize = urlconn.getContentLength(); // 取数据长度
                InputStreamReader isReader = new InputStreamReader(urlconn.getInputStream(),"UTF-8");
                BufferedReader reader = new BufferedReader(isReader);
                StringBuffer buffer = new StringBuffer();
                String line; // 用来保存每行读取的内容
                line = reader.readLine(); // 读取第一行
                while (line != null) { // 如果 line 为空说明读完了
                    buffer.append(line); // 将读到的内容添加到 buffer 中
                    buffer.append(" "); // 添加换行符
                    line = reader.readLine(); // 读取下一行
                }
                System.out.print(buffer.toString());
                ee = buffer.toString();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return  ee;
    }


    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }


        System.out.println("info:"+url+" download success");

    }



    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void main(String[] args) {
        try{
            downLoadFromUrl("http://tmp/wx16266f697f1799d8.o6zAJs2tcdMiP20JXx5c…gweAYinLJVQc917360dbe03a28a6f769ef2b5957ba7e.silk",
                    "zz.silk","d:/");
        }catch (Exception e) {
            // TODO: handle exception
        }
    }


   /* public static void main(String[] args) {
        openFile("http://wq-zy.oss-cn-hangzhou.aliyuncs.com/picture/%E5%B0%8F%E7%A8%8B%E5%BA%8F%E4%BF%A1%E6%81%AF.txt");
    }*/

}
