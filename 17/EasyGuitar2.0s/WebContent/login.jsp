<%@page import="com.zparkep.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>吉他易学网 登录页面</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link href="css/login2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function reloadCode()
{
   var time=new Date().getTime();
    document.getElementById("imagecode").src="${pageContext.request.contextPath }/servlet/checkcode?d="+time;
}
</script>
<!--  ==========  -->
<!--  = yanzhengma =  -->
<!--  ==========  -->
<link rel="stylesheet" href="css/login_yanzhengma.css" />
<script type="text/javascript" src="js/login_yanzhengma.min.js"></script>
<script type="text/javascript" src="js/login_yanzhengma1.js"></script>
<style>
	body {
		
		font-family: "微软雅黑";
		color: #fff;
	}
	button {
		display: inline-block;
		padding: 6px 12px;
		line-height: 1.4;
		text-align: center;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #fff;
		background-color: #5bc0de;
		border-color: #46b8da;
		cursor: pointer;
		font-size: 15px;
	}
	.container {
		width: 1080px;
		height: 600px;
		position: absolute;
		top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		margin: auto;
	}
	/*.demo1 {
		width: 48%;
		height: 100%;
		float: left;
		padding: 20px;
		border: 1px dashed #fff;
		border-radius: 4px;
		box-sizing: border-box;
		position: relative;
	}*/
	.demo2 {
		width: 18.5%;
		height: 65%;
		float: right;
		padding: 20px;
		/*border: 1px dashed #fff;*/
		border-radius: 4px;
		box-sizing: border-box;
		position: absolute;
		left: 0;
		right: 0;
		top: 300px;
		bottom: 0;
		margin: auto;
		z-index: 2;
	}
	.btns,
	.slider,
	.result {
		margin-bottom: 40px;
	}
	pre {
		font-size: 13px;
	}
</style>
</head>
<body>
		
<!--	<div class="demo2">
		<!--<div class="btns">
			<button id="reset2">还原</button>
		</div> --
		<div id="slider2" class="slider"></div>
		<div class="result">验证结果：<span id="result2"></span></div>
	</div>  -->

<!-- <script>
	$("#slider1").slider({
		callback: function(result) {
			$("#result1").text(result);
		}
	});
	$("#slider2").slider({
		width: 251.5, // width
		height: 42, // height
		sliderBg: "rgb(134, 134, 131)", // 滑块背景颜色
		color: "#fff", // 文字颜色
		fontSize: 14, // 文字大小
		bgColor: "#ccc", // 背景颜色
		textMsg: "按住滑块，拖拽验证", // 提示文字
		successMsg: "验证通过了哦", // 验证成功提示文字
		successColor: "white", // 滑块验证成功提示文字颜色
		time: 400, // 返回时间
		callback: function(result) { // 回调函数，true(成功),false(失败)
			$("#result2").text(result);
		}
	});
	// 还原
	$("#reset1").click(function() {
		$("#slider1").slider("restore");
	});
	$("#reset2").click(function() {
		$("#slider2").slider("restore");
	});
</script> -->
<!--  ==========  -->
<!--  = yanzhengma_jieshu =  -->
<!--  ==========  -->

<div class="wrapper">
	<div class="container">
		<h1>欢迎“主人”回家~瞄</h1>
		<form class="form" action="${pageContext.request.contextPath }/servlet/user?op=login" method = "post">
			<input type="text" placeholder="用户名" name = "uname" 
				value="${sessionScope.currentUser.username }">
			<input type="password" placeholder="密码" name = "pwd" 
				value="${sessionScope.currentUser.password }">
			<input type="text" placeholder="验证码" name="checkCode"/>
		    <img alt="验证码" id="imagecode" 
    	    src="${pageContext.request.contextPath }/servlet/checkcode"
    	    onclick="javascript:reloadCode();"/>
    	    <a href="javascript:reloadCode();">看不清楚</a><br> 
    	   
			<button type="submit" id="login-button">登录</button>
			<button type="submit" id="login-button"><a target="_self" href="regist.jsp">还未注册</a></button>
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

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<!--  <script type="text/javascript">
$('#login-button').click(function(event){
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});
</script>  -->

	
</body>
</html>