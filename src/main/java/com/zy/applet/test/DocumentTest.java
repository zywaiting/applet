package com.zy.applet.test;

import com.zy.applet.utils.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentTest {

    public static void main(String[] args) {

        String s = HttpUtils.get("http://szxing-fwc.icitymobile.com/line/10000284");
        Document document = Jsoup.parse(s);
        Elements elements = document.select("a");
        String text = elements.text();

        System.out.println(text);
    }
}
