<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>琴友作品修改</title>
        <link rel="icon" type="image/icon" href="../../img/tabicon.ico">

        <link rel="stylesheet" type="text/css" href="">
        <link href="../../css/selfcenter_bootstrap.min.css" rel="stylesheet">
        <link href="../../css/selfcenter_bootstrap-theme.min.css" rel="stylesheet">
        <link href="../../css/selfcenter_font-awesome.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,700,700i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,700,700i|Josefin+Sans:700" rel="stylesheet">
        <link href="../../css/selfcenter_main.css" rel="stylesheet">
        <link rel="icon" href="../../img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <style type="text/css">
	table,tr,th,td{
		text-align: center;
	}
</style>
    </head>
<!--
	作者：bennrhys@163.com
	时间：2018-08-29
	描述：用户修改
-->
    <body>
        <div id="index">                                           <!-- Index starts here -->
            <div class="container main">
                <div class="row home">
                    <div id = "index_left" class="col-md-6 left">
                        <img class="img-responsive img-rabbit" src="../../img/home.jpg">
                    </div>
                    <div id = "index_right" class="col-md-6 text-center right">
                        <div class="logo">
                            <img src="../../img/logo.png">
                            <h4>Hi！"小E"机器人 为您服务</h4>
                        </div>
                        <p class="home-description">
                           	 请客官，在此处自由修改作品信息.
                        </p>
                        <div class="btn-group-vertical custom_btn animated slideinright">
								<form action="${pageContext.request.contextPath}/servlet/opus" method="post" enctype="multipart/form-data">
									<input type="hidden" name="op" value="update">
									<input type="hidden" name="id" value="${opus.id }">
									<input type="hidden" name="qupustate" value="${opus.qupustate}">
									<input type="hidden" name="lastImg" value="${opus.img }"> 
									<input type="hidden" name="lastVideo" value="${opus.video }">
								<table border="0" cellspacing="0" cellpadding="0" width="400px">
											<th></th>
											<tr> <td>歌名：</td><td><input type="text" name="name" value="${opus.name }"></td></tr>
											<tr> <td>发布者：</td><td><input type="text" name="username" value="${opus.username }"></td></tr>
											<tr> <td>海报：</td><td><input type="file" name="img"></td></tr>
											<tr> <td>教学视频：</td><td><input type="text" name="video"></td></tr>
											<img alt="opus" width="100" height="100" 
												src="${pageContext.request.contextPath}/${opus.video}"><br>
											<tr> <td>歌手：</td><td><input type="text" name="singer" value="${opus.singer }"></td></tr>
											<tr> <td>歌曲风格</td><td><input type="text" name="state" value="${opus.state }"></td></tr>
											<tr> <td colspan="2"><input type="submit" value="确认修改"></td></tr>
								</table>
								</form>
								
                        </div>      
                        <div class="social">
                            <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i>联系小编：bennyrhys@163.com</a>
                        </div>
                    </div>
                </div>

                
            </div>
        </div>                                                      <!-- index ends here -->

                                                <!-- Contact ends here -->
        
        <script src="../../js/selfcenter_jquery-3.1.0.min.js"></script>
        <script src="../../js/selfcenter_bootstrap.min.js"></script>
        <script src="../../js/selfcenter_script.js"></script>
    </body>
</html>
