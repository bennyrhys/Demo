<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏界面</title>
<style type="text/css">
	.neirong{
	background-color：#CCC；
	}
	table,tr,td{
		border: 1px solid #ccc;
		text-align: center;
	}
	
</style>
</head>
<body>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>吉他易学网统一教学模块</title>
		<link rel="stylesheet" href="../css/section_teach.css" />
	</head>
	<body>
		<div class="section">
			<div class="head">
				<div class="into">
				<a href="houlogin.html"><img width="30px" height="30px" src="../img/tixing.png" /></a>
				<span class="word">欢迎来到干货最多的吉他教学网站，没有之一！！！</span>
				</div>
			</div>
			<div class="tupian">
					<a href=""><img class="tu1" src="../img/chatu1.png"/></a>
					<a href=""><img class="tu2" src="../img/chatu2.png"/></a>
			</div>
			<div class="teach">
				<!--  ==========  -->
				<!--  = 内容 =  -->
				<!--  ==========  -->
				<div class="neirong">
			<table width="100%">
			<tr>
				<th>作品名</th>
				<th>所属用户</th>
				<th>图片</th>
				<th>原唱歌手</th>
				<th>风格</th>
				<th>操作</th>
			</tr>
	<c:forEach items="${sessionScope.likeList }" var="like">
			<tr>
				<td>${like.value.name}</td>
				<td>${like.value.username}</td>
				<td>
				<img alt="opus" width="150" height="100" src="${pageContext.request.contextPath}/${like.value.img}">
				</td>
				<td>${like.value.singer}</td>
				<td>${like.value.state}</td>
				<td>
					<form action="${pageContext.request.contextPath}/servlet/like">
						<input type="hidden" name="op" value="delete">
						<input type="hidden" name="id" value="${like.key}">
						<input type="submit" value="取消收藏"> 
					</form>
				</td>
			</tr>
	</c:forEach>
		</table>
				</div>
				<!--
			    	作者：bennyrhys@163.com
			    	时间：2018-07-30
			    	描述：广告
			    -->
				<!-- <div class="guanggao">
					<img src="" alt="广告摊位"/>
				</div> -->
			</div>
		</div>
	</body>
</html>

