package com.zy.applet.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/**
 * @author zy
 * 2018-8-17
 * 图片合并
 */
public class PictureMergerUtils {

    private Font font = new Font("微软雅黑", Font.PLAIN, 35);// 添加字体的属性设置

    private Graphics2D g = null;

    private int fontsize = 0;

    private int x = 0;

    private int y = 0;

    /**
     * 导入本地图片到缓冲区
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 导入网络图片到缓冲区
     */
    public BufferedImage loadImageUrl(String imgName) {
        try {
            URL url = new URL(imgName);
            return ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 生成新图片到本地
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 设定文字的字体等
     */
    public void setFont(String fontStyle, int fontSize) {
        this.fontsize = fontSize;
        this.font = new Font(fontStyle, Font.PLAIN, fontSize);
    }

    /**
     * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
     */
    public BufferedImage modifyImage(BufferedImage img, Object content, int x, int y) {

        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.black);
//            g.setFont(new Font("楷体", Font.BOLD, 90));
            if (this.font != null)
                g.setFont(this.font);
            // 验证输出位置的纵坐标和横坐标
            if (x >= h || y >= w) {
                this.x = h - this.fontsize + 2;
                this.y = w;
            } else {
                this.x = x;
                this.y = y;
            }
            if (content != null) {
                g.drawString(content.toString(), this.x, this.y);
            }
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    /**
     * 修改图片,返回修改后的图片缓冲区（输出多个文本段） xory：true表示将内容在一行中输出；false表示将内容多行输出
     */
    public BufferedImage modifyImage(BufferedImage img, Object[] contentArr, int x, int y, boolean xory) {
        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.black);
            g.setFont(new Font("楷体", Font.BOLD, 30));
            if (this.font != null)
                g.setFont(this.font);
            // 验证输出位置的纵坐标和横坐标
            if (x >= h || y >= w) {
                this.x = h - this.fontsize + 2;
                this.y = w;
            } else {
                this.x = x;
                this.y = y;
            }
            if (contentArr != null) {
                int arrlen = contentArr.length;
                if (xory) {
                    for (int i = 0; i < arrlen; i++) {
                        g.drawString(contentArr[i].toString(), this.x, this.y);
                        this.x += contentArr[i].toString().length()
                                * this.fontsize / 2 + 5;// 重新计算文本输出位置
                    }
                } else {
                    for (int i = 0; i < arrlen; i++) {
                        g.drawString(contentArr[i].toString(), this.x, this.y);
                        this.y += this.fontsize + 2;// 重新计算文本输出位置
                    }
                }
            }
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    /**
     * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
     *
     * 时间:2007-10-8
     *
     * @param img
     * @return
     */
    public BufferedImage modifyImageYe(BufferedImage img) {

        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.RED);
            if (this.font != null)
                g.setFont(this.font);
            g.drawString("www.hi.baidu.com?xia_mingjian", w - 85, h - 5);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    /**
     *
     * @param x x轴
     * @param y y轴
     * @param w 嵌入图片的宽度
     * @param h 嵌入图片的高度
     * @param b 嵌入图片
     * @param d 底片
     * @return
     */
    public BufferedImage modifyImagetogeter(Integer x, Integer y,Integer w, Integer h,BufferedImage b, BufferedImage d) {

        try {
//            int w = b.getWidth();
//            int h = b.getHeight();
            g = d.createGraphics();
            g.drawImage(b, x, y, w, h, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return d;
    }

    /**
     * 两个文件流合并
     * @param inputStream1
     * @param inputStream2
     * @return
     */
    public InputStream getPictureMerge(Integer x, Integer y,Integer w, Integer h,InputStream inputStream1,InputStream inputStream2){
        InputStream inputStream = null;
        ByteArrayOutputStream os = null;
        BufferedImage image = null;
        try {
            image = modifyImagetogeter(x,y,w,h,ImageIO.read(inputStream1), ImageIO.read(inputStream2));
            os = new ByteArrayOutputStream();
            ImageIO.write(image, "gif", os);
            inputStream = new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputStream;
    }

    /**
     * 图片中加文字
     * @param inputStream
     * @param context
     * @return
     */
    public InputStream getPictureMerge(Integer x,Integer y,InputStream inputStream,String context){
        BufferedImage image = null;
        try {
            image = modifyImage(ImageIO.read(inputStream), context, x, y);
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeImageLocal("D:\\456.jpg",image);

        return null;
    }

    public static void main(String[] args) {
        PictureMergerUtils pp = new PictureMergerUtils();
        try {
            pp.getPictureMerge(200,200,new FileInputStream("D:\\test.jpg"),"尤磊");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//
//        pictureMergerUtils tt = new pictureMergerUtils();
//
//        BufferedImage d = tt.loadImageLocal("D:\\test.jpg");
//        BufferedImage b = tt.loadImageLocal("D:\\zy.png");
////         tt.writeImageLocal("D:\\123.jpg",tt.modifyImage(d,"xia_mingjian",10,20));
//        //往图片上写文件
//        // );
//
//        tt.writeImageLocal("D:\\cc.jpg", tt.modifyImagetogeter(b, d));
//        //将多张图片合在一起
//        System.out.println("success");
//    }

//    public static void main(String[] args) {
//        PictureMergerUtils pp = new PictureMergerUtils();
//        try {
//            InputStream pictureMerge = pp.getPictureMerge(675,220,205,205,new FileInputStream("D:\\zy.png"), new FileInputStream("D:\\test.jpg"));
//            String s = OssUploadFileUtils.OssUploadFileInputStreamtest("wq-zy", "test/timg4.jpg", pictureMerge);
//            System.out.println(s);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

}