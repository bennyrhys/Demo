<%@page import="com.zparkep.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	  <meta charset="utf-8"/>
	  <meta name="Generator" content="EditPlus®">
	  <meta name="Author" content="Bennyrhys——郭瑞新">
	  <meta name="Keywords" content="吉他易学网/EasyGuitar，好学又不贵的免费吉他网">
	  <meta name="Description" content="带上女朋友一起来弹吉他">
	  <title>吉他易学网/EasyGuitar</title>
	  <link href="css/index.css" rel="stylesheet" type="text/css">
	</head>
	<body>
			
		<!--
        	作者：bennyrhys@163.com
        	时间：2018-07-27
        	描述：导航
       -->
		<div class="nav">
			<!--logo-->
			<img src="img/吉他.png" width="180px" height="200px" />
			<!--导航-->
			<ul>
				<li><a target="iframe" href="${pageContext.request.contextPath}/servlet/main"><h1>EasyGuitar</h1><img src="img/wangzanshouye.png" width="25px" height="25px" />易学吉他官方首页</a></li>
				<li><a target="iframe" href="${pageContext.request.contextPath}/servlet/to?op=userlist"><img src="img/guanfangshangcheng.png" width="25px" height="25px" />教师作品及展示</a></li>
				<li><a target="iframe" href="${pageContext.request.contextPath}/servlet/opus?op=userlist"><img src="img/kecheng.png" width="25px" height="25px" />琴友作品</a></li>
				<li><a target="iframe" href="${pageContext.request.contextPath}/auth/user.jsp"><img src="img/gangqinjiaoxue.png" width="25px" height="25px" />个人主页 </a></li>
				<li><a target="iframe" href="${pageContext.request.contextPath}/auth/user/useredit.jsp"><img src="img/jitajiaoxue.png" width="25px" height="25px" />修改信息</a></li>
				<li><a target="iframe" href="${pageContext.request.contextPath}/opus/opus/add.jsp"><img src="img/jitatupu.png" width="25px" height="25px" />上传作品</a></li>
				<li><a target="iframe" href="${pageContext.request.contextPath}/opus/like.jsp"><img src="img/jitaquku.png" width="25px" height="25px" />我的收藏 </a></li>
			
			</ul>
		</div>
		<!--  ==========  -->
		<!--  = 右边 =  -->
		<!--  ==========  -->
		<div class="pangbian">
			<div class="head">
				<div class="vip">
					<ul>
						   <c:if test="${sessionScope.user == null }">
		                   <li><a target="iframe" href="login.jsp"><img src="img/denglu.png" width="80px" height="23px"/></a></li>
		                   <li><a target="iframe" href="regist.jsp"><img src="img/zhuce.png" width="80px" height="23px"/></a></li>
		               
	                    </c:if>
	                    <c:if test="${sessionScope.user != null }">
		                   <li>欢迎您：${sessionScope.user.nickname }</li>
		                   <li><a href = "${pageContext.request.contextPath }/servlet/user?op=logout"><img width="30px" height="30px" src="img/tuichu.png"/></a></li>
		                   <li></li>
	                    </c:if>
					
					</ul>
					<span><a target="iframe" href="soushou_dandu.html"><img width="30px" height="30px" src="img/soushuo.png"/></a></span>
				</div>
				<div class="seach"></div>
			</div>
			<div class="main">
				<iframe  src="${pageContext.request.contextPath}/servlet/main"  scrolling="yes" frameborder="0" height="93%" width="85%"  name="iframe" ></iframe>
			</div>
		</div>
		
		
	</body>
</html>
