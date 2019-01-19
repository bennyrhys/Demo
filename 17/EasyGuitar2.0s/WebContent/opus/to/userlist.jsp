<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教程列表</title>
<style type="text/css">
	table,tr,th,td{
		border: 1px solid red;
		border-collapse:collapse;
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
	&nbsp;>&nbsp;视频教程<br><br>
	<form action="${pageContext.request.contextPath}/servlet/to" method="post">
		<input type="hidden" name="op" value="select">
		<input type="hidden" name="aim" value="/opus/to/userlist.jsp">
		名称:<input type="text" name="name" size="3">
		老师:<input type="text" name="username" size="3"> 
		原唱歌手：<input type="text" name="singer" size="3"> 
		风格：<input type="text" name="state" size="3">
<!-- 		收藏量：<input type="text" name="lowl" size="2">~<input type="text" name="highl" size="2"> -->
		 
		<input type="submit" value="搜索">
	</form>
	<c:forEach items="${sessionScope.toList}" var="to">
		<ul>
			<li><a href="${pageContext.request.contextPath}/servlet/to?op=show&id=${to.id}">
					<div class="">
						<img width="250" height="150" src="${pageContext.request.contextPath}/${to.img}" />
				</div></a>
					<div class="">
						<span class="word">
						${to.name}<br>
						${to.username}<br>
						${to.state}
						</span>
					</div>
			</li>
		</ul>
	</c:forEach>
<!-- 	<hr> -->
<!-- 		<table width="85%"> -->
<!-- 			<tr> -->
<!-- 				<th>id</th>		 -->
<!-- 				<th>名称</th>		 -->
<!-- 				<th>所属老师</th>		 -->
<!-- 				<th>图片</th>		 -->
<!-- 				<th>视频</th>		 -->
<!-- 				<th>原唱歌手</th>		 -->
<!-- 				<th>分类/风格</th>		 -->
<!-- 				<th colspan="3">操作</th>		 -->
<!-- 			</tr> -->
<%-- 		<c:forEach items="${sessionScope.toList}" var="to"> --%>
<!-- 			<tr> -->
<!-- 				<td> -->
<%-- 					<a href="${pageContext.request.contextPath}/servlet/to?op=show&id=${to.id}">${to.id}</a> --%>
<!-- 				</td> -->
<%-- 				<td>${to.name}</td> --%>
<%-- 				<td>${to.username}</td> --%>
<!-- 				<td> -->
<!-- 					<img alt="opus" width="100" height="100"  -->
<%-- 					src="${pageContext.request.contextPath}/${to.img}">  --%>
<!-- 				</td> -->
<!-- 				<td> -->
<!-- 					<img alt="opus" width="100" height="100"  -->
<%-- 					src="${pageContext.request.contextPath}/${to.video}">  --%>
<!-- 				</td> -->
<%-- 				<td>${to.singer}</td> --%>
<%-- 				<td>${to.state}</td> --%>
<!-- 				<td> -->
<%-- 					<a href="${pageContext.request.contextPath}/servlet/to?op=find&id=${to.id}">修改</a> --%>
<!-- 				</td> -->
<!-- 				<td> -->
<%-- 					<a href="${pageContext.request.contextPath}/servlet/to?op=delete&id=${to.id}">删除</a> --%>
<!-- 				</td> -->
<!-- 				<td> -->
<%-- 					<form action="${pageContext.request.contextPath}/servlet/qupu" method="post" enctype="multipart/form-data"> --%>
<!-- 					<input type="hidden" name="op" value="add"> -->
<%-- 					<input type="hidden" name="to_id" value="${to.id}"> --%>
<!-- 					<input type="file" name="img"> -->
<!-- 					<input type="submit" value="添加曲谱"> -->
<!-- 					</form> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<%-- 				<c:forEach items="${sessionScope.qupuList}" var="qp"> --%>
<!-- 					<td> -->
<%-- 						<img alt="qupu" width="50" height="50" src="${pageContext.request.contextPath}/${qp.img }"> --%>
<!-- 					</td> -->
<!-- 					<td> -->
<%-- 					<a href="${pageContext.request.contextPath}/servlet/qupu?op=delete&id=${qp.id}&to_id=${to_id}">删除</a> --%>
<!-- 					</td> -->
<%-- 				</c:forEach> --%>
<!-- 			</tr> -->
<%-- 	</c:forEach> --%>
<!-- 		</table> -->
</body>
</html>