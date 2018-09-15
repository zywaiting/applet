package com.zy.applet.controller.love;

import com.zy.applet.pojo.LovePage;
import com.zy.applet.pojo.LovePageContext;
import com.zy.applet.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class LoveController {

    @Autowired
    private LoveService loveService;

    @RequestMapping("/index")
    public String toIndex(){
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
            return "index";
        }
    }


    @RequestMapping("/mohuanlizi")
    public String toIndexPage(HttpServletRequest request, HttpServletResponse response){

        String con3 = request.getParameter("con3");
        String con1 = request.getParameter("con1");
        String con2 = request.getParameter("con2");
        LovePageContext lovePageContext1 = loveService.selectLovePageContextByCon3(con3);
        if (lovePageContext1 == null) {
            LovePageContext lovePageContext = new LovePageContext();
            lovePageContext.setPage("mohuanlizi");
            lovePageContext.setExpress("https://zhuyao.xin/mohuanlizi/" + con3);
            lovePageContext.setCon1(con1);
            lovePageContext.setCon2(con2);
            lovePageContext.setCon3(con3);
            lovePageContext.setCrediteDate(new Date());
            Integer integer = loveService.insterLovePageContext(lovePageContext);
            if (integer > 0) {
                request.setAttribute("url","https://zhuyao.xin/mohuanlizi/" + con3);
                return "return";
            }else {
                return "index";
            }
        }
        return "index";
    }


    @RequestMapping("/mohuanlizi/{con3}")
    public String toMohuanliziPage(HttpServletRequest request, @PathVariable String con3) {
        LovePageContext lovePageContext = loveService.selectLovePageContextByCon3(con3);
        request.setAttribute("title",lovePageContext.getCon1());
        request.setAttribute("context",lovePageContext.getCon2());
        System.out.println(lovePageContext.getCon2());
        return "mohuanlizi";
    }

    @RequestMapping("/test")
    public String toMohuanliziPageTest(HttpServletRequest request) {
        request.setAttribute("title","朱瑶爱王倩");
        request.setAttribute("context","亲爱的王倩|老婆大人|你即将成为|全世界|最幸福|的妻子。：");
        return "mohuanlizi";
    }
}
