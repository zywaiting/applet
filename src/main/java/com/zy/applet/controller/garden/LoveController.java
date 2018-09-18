package com.zy.applet.controller.garden;

import com.zy.applet.pojo.LoveIndexStyle;
import com.zy.applet.pojo.LovePage;
import com.zy.applet.pojo.LovePageContext;
import com.zy.applet.service.LoveService;
import com.zy.applet.utils.CreateCodeUtils;
import com.zy.applet.utils.OssUploadFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.*;

@Controller
public class LoveController {

    private final static Logger logger = LoggerFactory.getLogger(LoveController.class);
    @Autowired
    private LoveService loveService;

    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request){
        Map map = new HashMap();
        List<LoveIndexStyle> loveIndexStyleList = loveService.selectLoveIndexStyle("index");
        for (LoveIndexStyle loveIndexStyle : loveIndexStyleList) {
            map.put(loveIndexStyle.getPage(),loveIndexStyle.getStyle());
        }
        request.setAttribute("loveIndexStyle",map);
        return "index";
    }

    @RequestMapping("/index/{express}")
    public String toIndexPage(HttpServletRequest request, @PathVariable String express){

        LovePage lovePage = loveService.selectLovePageByExpress(express);
        if (lovePage != null) {
            request.setAttribute("title",lovePage.getTitle());
            request.setAttribute("body",lovePage.getBody());
            request.setAttribute("script",lovePage.getScript());
            return "page";
        }else{
            return "error";
        }
    }


    @RequestMapping("/add")
    public String toIndexPage(HttpServletRequest request, HttpServletResponse response,String page){

        String mark = request.getParameter("mark");
        String con1 = request.getParameter("con1");
        String con2 = request.getParameter("con2");
        String con3 = request.getParameter("con3");
        String con4 = request.getParameter("con4");
        String con5 = request.getParameter("con5");
        String con6 = request.getParameter("con6");
        String con7 = request.getParameter("con7");
        String con8 = request.getParameter("con8");
        String con9 = request.getParameter("con9");
        String con10 = request.getParameter("con10");
        String con11 = request.getParameter("con11");
        String con12 = request.getParameter("con12");
        String con13 = request.getParameter("con13");
        String con14 = request.getParameter("con14");
        String con15 = request.getParameter("con15");
        String con16 = request.getParameter("con16");
        String con17 = request.getParameter("con17");
        String con18 = request.getParameter("con18");
        String con19 = request.getParameter("con19");
        String con20 = request.getParameter("con20");
        String url = "https://zhuyao.xin/" + page + "/" + mark;
        LovePageContext lovePageContext1 = loveService.selectLovePageContextByMark(mark);
        if (lovePageContext1 == null) {
            LovePageContext lovePageContext = new LovePageContext();
            lovePageContext.setPage(page);
            lovePageContext.setExpress(url);
            lovePageContext.setCon1(con1);
            lovePageContext.setCon2(con2);
            lovePageContext.setCon3(con3);
            lovePageContext.setCon4(con4);
            lovePageContext.setCon5(con5);
            lovePageContext.setCon6(con6);
            lovePageContext.setCon7(con7);
            lovePageContext.setCon8(con8);
            lovePageContext.setCon9(con9);
            lovePageContext.setCon10(con10);
            lovePageContext.setCon11(con11);
            lovePageContext.setCon12(con12);
            lovePageContext.setCon13(con13);
            lovePageContext.setCon14(con14);
            lovePageContext.setCon15(con15);
            lovePageContext.setCon16(con16);
            lovePageContext.setCon17(con17);
            lovePageContext.setCon18(con18);
            lovePageContext.setCon19(con19);
            lovePageContext.setCon20(con20);
            lovePageContext.setMark(mark);
            lovePageContext.setCrediteDate(new Date());
            Integer integer = loveService.insterLovePageContext(lovePageContext);
            if (integer > 0) {
                String imageUrl = "";
                ByteArrayInputStream byteArrayInputStream = CreateCodeUtils.drawLogoQRCode("https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKBcD51SvG3DSiaR0nxFibibkLkrShdXo6Vz1pdsADuMMLC49vn4xvZlczZmoNVQyS3ORp1EUSBO6gLQ/132", url);
                try {
                    imageUrl = OssUploadFileUtils.OssUploadFileInputStreamtest("wq-zy", "love/love_picture/" + UUID.randomUUID() + ".png", byteArrayInputStream);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return "error";
                }
                request.setAttribute("url",url);
                request.setAttribute("picture",imageUrl);
                return "return";
            }else {
                return "error";
            }
        }
        return "error";
    }


    @RequestMapping("/mohuanlizi/{mark}")
    public String toMohuanliziPage(HttpServletRequest request, @PathVariable String mark) {
        LovePageContext lovePageContext = loveService.selectLovePageContextByMark(mark);
        request.setAttribute("title",lovePageContext.getCon1());
        request.setAttribute("context",lovePageContext.getCon2());
        return "mohuanlizi";
    }




    @RequestMapping("/aixinshu/{mark}")
    public String toAixinshuPage(HttpServletRequest request, @PathVariable String mark) {
        LovePageContext lovePageContext = loveService.selectLovePageContextByMark(mark);
        request.setAttribute("title",lovePageContext.getCon1());
        request.setAttribute("con2",lovePageContext.getCon2());
        request.setAttribute("con3",lovePageContext.getCon3());
        request.setAttribute("con4",lovePageContext.getCon4());
        String[] split = lovePageContext.getCon5().split("-");
        request.setAttribute("year",split[0]);
        request.setAttribute("month",split[1]);
        request.setAttribute("day",split[2]);
        return "aixinshu";
    }

    @RequestMapping("/test")
    public String toMohuanliziPageTest(HttpServletRequest request) {
        request.setAttribute("title","朱瑶爱王倩");
        request.setAttribute("context","亲爱的王倩|老婆大人|你即将成为|全世界|最幸福|的妻子。：");
        return "mohuanlizi";
    }
}
