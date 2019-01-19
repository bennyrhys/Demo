<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品列表</title>
<style type="text/css">
		table, tr, th, td {
			border: 1px solid red;
			border-collapse: collapse;
		}
		li {
			list-style-type: none;
		}
		
		a {
			text-decoration: none;
		}
		ul{
			float: left;
		}
</style>
</head>
<body>
	<a href="${pageContext.request.contextPath}/servlet/main">首页</a>
	&nbsp;>&nbsp;琴友作品<br><br>
	<form action="${pageContext.request.contextPath}/servlet/opus" method="post">
		<input type="hidden" name="op" value="select">
		<input type="hidden" name="aim" value="/opus/opus/userlist.jsp">
		名称:<input type="text" name="name">
		用户:<input type="text" name="username"> 
		原唱歌手：<input type="text" name="singer"> 
		风格：<input type="text" name="state"> 
		<input type="submit" value="搜索">
	</form>
	<c:forEach items="${sessionScope.opusList}" var="opus">
		<ul>
			<li><a href="${pageContext.request.contextPath}/servlet/opus?op=show&id=${opus.id}">
					<div class="">
						<img width="250" height="150" src="${pageContext.request.contextPath}/${opus.img}" />
				</div></a>
					<div class="">
						<span class="word">
						${opus.name}<br>
						${opus.username}<br>
						${opus.state}
						</span>
					</div>
			</li>
		</ul>
	</c:forEach>
<!-- 	<hr> -->
<!-- 		<table> -->
<!-- 			<tr> -->
<!-- 				<th>id</th>		 -->
<!-- 				<th>名称</th>		 -->
<!-- 				<th>所属用户</th>		 -->
<!-- 				<th>图片</th>		 -->
<!-- 				<th>视频</th>		 -->
<!-- 				<th>原唱歌手</th>		 -->
<!-- 				<th>分类/风格</th>		 -->
<!-- 			</tr> -->
<%-- 		<c:forEach items="${sessionScope.opusList}" var="opus"> --%>
<!-- 			<tr> -->
<!-- 				<td> -->
<%-- 				<a href="${pageContext.request.contextPath}/servlet/opus?op=show&id=${opus.id}">${opus.id}</a>  --%>
<!-- 				</td> -->
<%-- 				<td>${opus.name}</td> --%>
<%-- 				<td>${opus.username}</td> --%>
<!-- 				<td> -->
<!-- 					<img alt="opus" width="100" height="100"  -->
<%-- 					src="${pageContext.request.contextPath}/${opus.img}">  --%>
<!-- 				</td> -->
<!-- 				<td> -->
<!-- 					<img alt="opus" width="100" height="100"  -->
<%-- 					src="${pageContext.request.contextPath}/${opus.video}">  --%>
<!-- 				</td> -->
<%-- 				<td>${opus.singer}</td> --%>
<%-- 				<td>${opus.state}</td> --%>
<!-- 			</tr> -->
<%-- 	</c:forEach> --%>
<!-- 		</table> -->
	
</body>
</html>