<%@page import="com.zparkep.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>吉他易学网 注册页面</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link href="css/regist.css" rel="stylesheet" type="text/css" />
</head>
<body> 
	
	<div class="wrapper">
	<div class="container">
		<h1>玩命注册…</h1>
		<form class="form" action="${pageContext.request.contextPath }/servlet/user?op=regist" method = "post" enctype="multipart/form-data">
			<div class="left">
				<input type="text" placeholder="*昵称" name = "nickname">
				<input type="text" placeholder="*用户名=_=" name = "username">
				<input type="password" placeholder="*密码,难点呗" name = "password1">
				<input type="password" placeholder="*重复一遍" name = "password2">
				<input type="text" placeholder="今年几岁了？" name = "age">
				<input type="text" placeholder="性别"  name = "gender">
			</div>
			<div class="right">
				
				<input type="text" placeholder="邮箱" name = "mail">
				<input type="file" placeholder="头像" name="img" value = "头像">
				<input type="text" placeholder="自我描述" name = "intro">
				<input type="text" placeholder="住哪？" name = "addr">
				<input type="text" placeholder="小哥哥/姐姐，微博留下" name = "weibo">
				<button class="button" type="submit" id="login-button">注册</button>
			</div>
			
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
</div>

<script type="text/javascript" src="js/logoin.js"></script>
<!-- <script type="text/javascript">
$('#login-button').click(function(event){
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});
</script>  -->
</body>
</html>