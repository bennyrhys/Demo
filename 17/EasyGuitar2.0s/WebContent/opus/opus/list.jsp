<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品列表</title>
<style type="text/css">
	table,tr,th,td{
		border: 1px solid ;
		text-align: center;
		border-collapse:collapse;
	}
</style>
</head>
<body>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>吉他易学网统一教学模块</title>
		<link rel="stylesheet" href="../../css/section_teach.css" />
	</head>
	<body>
 		<!-- <div class="section">
			<div class="head">
				<div class="into">
				<a href="houlogin.html"><img width="30px" height="30px" src="../../img/tixing.png" /></a>
				<span class="word">欢迎来到干货最多的吉他教学网站，没有之一！！！</span>
				</div>
			</div> 
			<div class="tupian">
					<a href=""><img class="tu1" src="../../img/chatu1.png"/></a>
					<a href=""><img class="tu2" src="../../img/chatu2.png"/></a>
			</div> 
			-->
			<div class="teach">
				<!--  ==========  -->
				<!--  = 内容 =  -->
				<!--  ==========  -->
				<div class="neirong">
					
					<a href="${pageContext.request.contextPath}/opus/opus/add.jsp">添加教程</a><br>
	<form action="${pageContext.request.contextPath}/servlet/opus" method="post">
		<input type="hidden" name="op" value="select">
		<input type="hidden" name="aim" value="/opus/opus/list.jsp">
		名称:<input type="text" name="name">
		用户:<input type="text" name="username"> 
		原唱歌手：<input type="text" name="singer"> 
		风格：<input type="text" name="state"> 
		<input type="submit" value="搜索">
	</form>
	
	<hr>
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<th>id</th>		
				<th>名称</th>		
				<th>所属用户</th>		
				<th>图片</th>		
				<th>视频</th>		
				<th>原唱歌手</th>		
				<th>分类/风格</th>		
				<th colspan="2">操作</th>		
			</tr>
		<c:forEach items="${sessionScope.opusList}" var="opus">
			<tr>
				<td>
				<a href="${pageContext.request.contextPath}/servlet/opus?op=show&id=${opus.id}">${opus.id}</a> 
				</td>
				<td>${opus.name}</td>
				<td>${opus.username}</td>
				<td>
					<img alt="opus" width="150" height="100" 
					src="${pageContext.request.contextPath}/${opus.img}"> 
				</td>
				<td>
					<object width="150"  data="${opus.video}" ></object>
				</td>
				<td>${opus.singer}</td>
				<td>${opus.state}</td>
				<td>
					<a href="${pageContext.request.contextPath}/servlet/opus?op=find&id=${opus.id}">修改</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/servlet/opus?op=delete&id=${opus.id}">删除</a>
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
				<div class="guanggao">
					<img src="" alt="广告摊位"/>
				</div>
			</div>
		</div>
	</body>
</html>

