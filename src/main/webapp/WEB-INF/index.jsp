<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/14
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths" style="">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>小朱果园</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="表白网-在线全自动网页制作表白神器是一款全自动在线网页制作工具，国内顶尖自动化网页制作系统，只需选择模板一键生成即可。可制作一系列个人网页、表白网页、HTML5网页等等，人人都能做网页。">
    <meta name="keywords" content="在线网页制作,个人网页制作,表白网页制作,祝福网页制作,免费网页制作,网页一键生成">

    <link rel="stylesheet" href="/love_files/animate.css">

    <link rel="stylesheet" href="/love_files/flexslider.css">

    <link rel="stylesheet" href="/love_files/icomoon.css">

    <link rel="stylesheet" href="/love_files/magnific-popup.css">

    <link rel="stylesheet" href="/love_files/bootstrap.css">
    <link rel="stylesheet" href="/love_files/style.css">

    <link rel="stylesheet" id="theme-switch" href="/love_files/style.css">


    <script src="/love_files/modernizr-2.6.2.min.js"></script>
</head>
<body><a href="https://zhuyao.xin/index" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>

<div class="fh5co-loader" style="display: none;"></div>

<%--<div class="dnone"><img width="121" src="/images/zz.jpg" alt="logo"></div>--%>

<div id="fh5co-page">
    <section id="fh5co-header">
        <div class="container">
            <nav role="navigation">


                <h1 id="fh5co-logo"><a href="https://zhuyao.xin/index">浪漫分享网<span>.</span></a></h1>


                <ul class="zhong dnone">
                    <li><a href="https://zhuyao.xin/index">关于我们</a></li>
                </ul>

                <ul class="zhong dnone">
                    <li><a href="https://zhuyao.xin/index">联系我们</a></li>
                </ul>

                <ul class="zhong dnone">
                    <li><a href="https://zhuyao.xin/index">查看我们</a></li>
                </ul>

                <ul class="zhong dnone">
                    <li><a href="https://zhuyao.xin/index">返回首页</a></li>
                </ul>


            </nav>
        </div>
    </section>

    <%--<section id="fh5co-hero" class="no-js-fullheight" style="background-image: url(images/zz.jpg);" data-next="yes">--%>
    <section id="fh5co-hero" class="no-js-fullheight" style="background: #888888;" data-next="yes">
        <div class="fh5co-overlay"></div>
        <div class="container">
            <div class="fh5co-intro no-js-fullheight">
                <div class="fh5co-intro-text">
                    <div class="fh5co-center-position">
                        <h2 class="animate-box fadeInUp animated">表白网页制作</h2>
                        <h3 class="animate-box fadeInUp animated">Love web page making</h3>
                    </div>
                </div>
            </div>
        </div>
        <div class="fh5co-learn-more animate-box fadeInUp animated" style="margin-left: -48px;">
            <a href="https://zhuyao.xin/index" class="scroll-btn">
                <span class="text">选择网页模板</span>
                <span class="arrow">
                    <i class="icon-chevron-down"></i>
                </span>
            </a>
        </div>
    </section>

    <section id="fh5co-projects">
        <div class="container">
            <div class="row">

                <div class="col-md-4 col-sm-6 col-xs-6 animate-box fadeInUp animated" style="display: ${loveIndexStyle['jugong']}">
                    <a href="https://zhuyao.xin/index/jugong/" class="fh5co-project-item" target="_blank">
                        <img src="/images/jugong.jpg" data-original="/images/jugong.jpg" alt="鞠躬表白" class="img-responsive lazy" style="display: block;">
                    <div class="fh5co-text">
                        <h2>鞠躬表白</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box fadeInUp animated"  style="display: ${loveIndexStyle['wanmei']}">
                    <a href="https://zhuyao.xin/index/wanmei/" class="fh5co-project-item" target="_blank">
                        <img src="/images/wanmei.png" data-original="/images/wanmei.png" alt="完美表白" class="img-responsive lazy" style="display: block;">
                    <div class="fh5co-text">
                        <h2>完美表白</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['biaoqing']}">
                    <a href="https://zhuyao.xin/index/biaoqing/" class="fh5co-project-item" target="_blank">
                        <img src="/images/biaoqing.png" data-original="/images/biaoqing.png" alt="表白表情包" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>表白表情包</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <%--<div class="col-md-4 col-sm-6 col-xs-6 animate-box"><a href="http://h5.hunlipic.com/biaobai_huaxin/" class="fh5co-project-item" target="_blank"> <img src="/images/xin.png" data-original="/images/xin.png" alt="表白信" class="img-responsive lazy">--%>
                <%--<div class="fh5co-text">--%>
                <%--<h2>表白信</h2>--%>
                <%--<p>表白网页制作</p>--%>
                <%--</div>--%>
                <%--</a> </div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-6 animate-box"><a href="http://h5.hunlipic.com/biaobai_jiandan/" class="fh5co-project-item" target="_blank"> <img src="/images/jiandan.png" data-original="/images/jiandan.png" alt="简单表白" class="img-responsive lazy">--%>
                <%--<div class="fh5co-text">--%>
                <%--<h2>简单表白</h2>--%>
                <%--<p>表白网页制作</p>--%>
                <%--</div>--%>
                <%--</a> </div>--%>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box"  style="display: ${loveIndexStyle['aixin']}">
                    <a href="https://zhuyao.xin/index/aixin/" class="fh5co-project-item" target="_blank">
                        <img src="/images/aixin.png" data-original="/images/aixin.png" alt="爱心表白" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>爱心表白</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>

                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['qixi']}">
                    <a href="https://zhuyao.xin/index/qixi/" class="fh5co-project-item" target="_blank">
                        <img src="/images/qixi.png" data-original="/images/qixi.png" alt="情人节表白" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>情人节表白</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['wenzi']}">
                    <a href="https://zhuyao.xin/index/wenzi/" class="fh5co-project-item" target="_blank">
                        <img src="/images/wenzi.png" data-original="/images/wenzi.png" alt="漂浮的文字表白" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>漂浮的文字表白</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['qixi']}">
                    <a href="https://zhuyao.xin/index/xiangcePPT/" class="fh5co-project-item" target="_blank">
                        <img src="/images/xiangcePPT.png" data-original="/images/xiangcePPT.png" alt="回忆相册PPT" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>回忆相册PPT</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['aixinjishi']}">
                    <a href="https://zhuyao.xin/index/aixinjishi/" class="fh5co-project-item" target="_blank">
                        <img src="/images/aixinjishi.png" data-original="/images/aixinjishi.png" alt="爱心计时表白网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>爱心计时表白网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['aixinshu']}">
                    <a href="https://zhuyao.xin/index/aixinshu/" class="fh5co-project-item" target="_blank">
                        <img src="/images/aixinshu.png" data-original="/images/aixinshu.png" alt="爱心树表白网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>爱心树表白网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['3DlangmanPPT']}">
                    <a href="https://zhuyao.xin/index/3DlangmanPPT/" class="fh5co-project-item" target="_blank">
                        <img src="/images/3DlangmanPPT.png" data-original="/images/3DlangmanPPT.png" alt="3D浪漫表白PPT" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>3D浪漫表白PPT</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['jianyuexingkong']}">
                    <a href="https://zhuyao.xin/index/jianyuexingkong/" class="fh5co-project-item" target="_blank">
                        <img src="/images/jianyuexingkong.png" data-original="/images/jianyuexingkong.png" alt="简约星空表白网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>简约星空表白网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['mohuanlizi']}">
                    <a href="https://zhuyao.xin/index/mohuanlizi/" class="fh5co-project-item" target="_blank">
                        <img src="/images/mohuanlizi.png" data-original="/images/mohuanlizi.png" alt="魔幻粒子表白网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>魔幻粒子表白网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['mvbiaobai']}">
                    <a href="https://zhuyao.xin/index/mvbiaobai/" class="fh5co-project-item" target="_blank">
                        <img src="/images/mvbiaobai.png" data-original="/images/mvbiaobai.png" alt="MV表白网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>MV表白网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['donhuabiaobai']}">
                    <a href="https://zhuyao.xin/index/donhuabiaobai/" class="fh5co-project-item" target="_blank">
                        <img src="/images/donhuabiaobai.png" data-original="/images/donhuabiaobai.png" alt="动画表白网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>动画表白网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['jianyuechengse']}">
                    <a href="https://zhuyao.xin/index/jianyuechengse/" class="fh5co-project-item" target="_blank">
                        <img src="/images/jianyuechengse.png" data-original="/images/jianyuechengse.png" alt="简约橙色表白网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>简约橙色表白网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['shengrizhufu']}">
                    <a href="https://zhuyao.xin/index/shengrizhufu/" class="fh5co-project-item" target="_blank">
                        <img src="/images/shengrizhufu.png" data-original="/images/shengrizhufu.png" alt="生日祝福网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>生日祝福网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['shengdashu']}">
                    <a href="https://zhuyao.xin/index/shengdanshu/" class="fh5co-project-item" target="_blank">
                        <img src="/images/shengdashu.png" data-original="/images/shengdashu.png" alt="圣诞树祝福网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>圣诞树祝福网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
                <div class="col-md-4 col-sm-6 col-xs-6 animate-box" style="display: ${loveIndexStyle['shengdan']}">
                    <a href="https://zhuyao.xin/index/shengdan/" class="fh5co-project-item" target="_blank">
                        <img src="/images/shengdan.png" data-original="/images/shengdan.png" alt="圣诞祝福网页" class="img-responsive lazy">
                    <div class="fh5co-text">
                        <h2>圣诞祝福网页</h2>
                        <p>表白网页制作</p>
                    </div>
                </a> </div>
            </div>
        </div>
    </section>


</div>



<script src="/love_files/vip.js"></script>

<script src="/love_files/jquery.min.js"></script>

<script src="/love_files/jquery.easing.1.3.js"></script>

<script src="/love_files/jquery.lazyload.js"></script>
<script type="text/javascript">
    $(function () {
        $("img.lazy").lazyload();
    });
</script>

<script src="/love_files/bootstrap.min.js"></script>

<script src="/love_files/jquery.waypoints.min.js"></script>

<script src="/love_files/jquery.flexslider-min.js"></script>

<script src="/love_files/jquery.magnific-popup.min.js"></script>
<script src="/love_files/magnific-popup-options.js"></script>

<script src="/love_files/jquery.style.switcher.js"></script>

<script src="/love_files/main.js"></script>
<script src="/love_files/jquery.cookie.js"></script>
<script>
    $(function(){

        if ( $.cookie('layoutCookie') != '' ) {
            $('body').addClass($.cookie('layoutCookie'));
        }

        $('a[data-layout="boxed"]').click(function(event){
            event.preventDefault();
            $.cookie('layoutCookie', 'boxed', { expires: 7, path: '/'});
            $('body').addClass($.cookie('layoutCookie')); // the value is boxed.
        });

        $('a[data-layout="wide"]').click(function(event){
            event.preventDefault();
            $('body').removeClass($.cookie('layoutCookie')); // the value is boxed.
            $.removeCookie('layoutCookie', { path: '/' }); // remove the value of our cookie 'layoutCookie'
        });
    });
</script>

</body></html>
