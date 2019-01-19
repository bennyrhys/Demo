<%@page import="com.zparkep.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Rabbit : Home</title>
        <link rel="icon" type="image/icon" href="../img/tabicon.ico">

        <link rel="stylesheet" type="text/css" href="">
        <link href="../css/selfcenter_bootstrap.min.css" rel="stylesheet">
        <link href="../css/selfcenter_bootstrap-theme.min.css" rel="stylesheet">
        <link href="../css/selfcenter_font-awesome.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,700,700i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,700,700i|Josefin+Sans:700" rel="stylesheet">
        <link href="../css/selfcenter_main.css" rel="stylesheet">
        <link rel="icon" href="../img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        
    </head>

    <body>
          

        <div id="index">                                           <!-- Index starts here -->
            <div class="container main">
                <div class="row home">
                    <div id = "index_left" class="col-md-6 left">
                        <img class="../img-responsive ../img-rabbit" src="../img/home.jpg">
                    </div>
                    <div id = "index_right" class="col-md-6 text-center right">
                        <div class="logo">
                            <img alt="头像" width="80" height="80" src="${pageContext.request.contextPath}/${user.img }">
                            <h4>Hi！${user.nickname}</h4>
                        </div>
                        <p class="home-description">
                            歡迎客官，我是來自中國EasyGuitar的小E，以下信息來自與您的個人中心，常來玩哦~ I really love what you do.
                        </p>
                        <div class="btn-group-vertical custom_btn animated slideinright">
                            <div id="about" class="btn btn-rabbit">絶對領域</div>
                            <div id="work" class="btn btn-rabbit">說明書</div>
                            <div id="contact" class="btn btn-rabbit">聯繫作者</div>
                        </div>      
                        <div class="social">
                            <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i>${user.weibo}</a>
                           <!-- <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                            <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>-->
                        </div>
                    </div>
                </div>

                
            </div>
        </div>                                                      <!-- index ends here -->

        <div id="about_scroll" class="pages ">                      <!-- about strats here  -->
            <div class="container main">
                <div class="row">
                    <div class="col-md-6 left" id="about_left">
                        <img class="../img-responsive ../img-rabbit" src="../img/about.jpg">
                    </div>

                    <div class="col-md-6 right" id="about_right">
                        <a href="#index" class="btn btn-rabbit back"> <i class="fa fa-angle-left" aria-hidden="true"></i> 返回 </a>
                        <div id="watermark">
                            <h2 class="page-title" text-center>个人资料</h2>
                            <div class="marker">a</div>
                        </div>
                        <p class='subtitle'>喲喲喲！客官您來了？這是您專屬的個人資料
                        </p>
                        <p class="info"></p>  
                        <div>
                        	          用户名：${user.username}<br>
          		昵称：${user.nickname}<br>
         	 密码：${user.password}<br>
         	 性别：${user.gender}<br>
         	 年龄：${user.age}<br>
          	地址：${user.addr}<br>
          		邮箱：${user.mail}<br>
          微博：${user.weibo}<br>
          简介：${user.intro}<br>
                        </div>
                    </div>
                </div>
            </div>            
        </div>                                                                <!-- About ends here -->

        
        <div id="work_scroll" class="pages">                                  <!-- Work starts here -->
            <div class="container main">
                <div class="row">
                    <div class="col-md-6" id="work_left">
                        <div id="owl-demo" class="owl-carousel owl-theme">
                            <div class="item"><img class="../img-responsive ../img-rabbit" src="../img/work.jpg"></div>
                            <div class="item"><img class="../img-responsive ../img-rabbit" src="../img/home.jpg"></div>
                            <div class="item"><img class="../img-responsive ../img-rabbit" src="../img/contact.jpg"></div>
                        </div>
                    </div>

                    <div class="col-md-6" id="work_right">
                        <a href="#index" class="btn btn-rabbit back"> <i class="fa fa-angle-left" aria-hidden="true"></i>返回</a>
                        <div id="watermark">
                            <h2 class="page-title" text-center>說明書</h2>
                            <div class="marker">w</div>
                        </div>
                        <p class='subtitle'>尊敬的用戶大人：<br />在此歡度的時光里，您將接觸到全網更新最快，質量最高的優質服務！
                        </p>
                       
                        <p class="info">這是乾貨最多的吉他網，沒有之一！！！<br />註冊的准會員享有免費開放的服務平臺，登録EasyGuitar后，通過歌名、歌手、歌曲風格、教師教程、琴友作品，踏上吉他大帝的路途指日可待。請砥礪前行，要堅信成不了大帝，至少還能撩個妹兒~</p>
                    </div>
                </div>
            </div>    
        </div>                                                                 <!-- Work ends here  -->


        <div id="contact_scroll" class="pages">                             <!-- Contact starts here -->
            <div class="container main">
                <div class="row">
                    <div class="col-md-6 left" id="contact_left">
                        <img class="../img-responsive ../img-rabbit" src="../img/contact.jpg">
                    </div>

                    <div class="col-md-6 right" id="contact_right">
                        <a href="#index" class="btn btn-rabbit back"> <i class="fa fa-angle-left" aria-hidden="true"></i>返回</a>
                        <div id="watermark">
                            <h2 class="page-title" text-center>聯繫作者</h2>
                            <div class="marker">c</div>
                        </div>
                        <p class='subtitle'>互聯網三賤客<br />郵箱：bennyrhys@163.com<br />歡迎客官大人前來打賞<br />沒有打賞提點寶貴意見小編也是會看見的<br />請客官諒解，沒有24小時的在綫服務，小編此刻可能正在睡覺！zzz
                        </p>
                        
                    </div>
                </div>
            </div>
       
            
        </div>                                                              <!-- Contact ends here -->
        
        <script src="../js/selfcenter_jquery-3.1.0.min.js"></script>
        <script src="../js/selfcenter_bootstrap.min.js"></script>
        <script src="../js/selfcenter_script.js"></script>

<!-- 下方暂时不用的数据输出 -->
<%-- 	<a href="${pageContext.request.contextPath}/servlet/main">首页</a>
	&nbsp;>&nbsp;
	<a href="${pageContext.request.contextPath}/auth/user.jsp">个人中心</a><br>
	<hr>
	<a href="${pageContext.request.contextPath}/auth/user/add.jsp">修改信息</a>
	<a href="${pageContext.request.contextPath}/opus/opus/add.jsp">上传作品</a>
	<a href="${pageContext.request.contextPath}/opus/like.jsp">我的收藏</a> --%>
    </body>
</html>