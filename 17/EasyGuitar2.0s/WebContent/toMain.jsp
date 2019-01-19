<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
	table,tr,th,td{
		border: 1px solid red;
		border-collapse:collapse;
	}
</style>
</head>
<body>
		<a href="${pageContext.request.contextPath}/servlet/user?op=login">亲，请登录</a>
		<a href="${pageContext.request.contextPath}/servlet/user?op=regist">免费注册</a>
		欢迎您:${${sessionScope.user.nickname } }
		<a href = "${pageContext.request.contextPath}/servlet/user?op=logout">注销</a>
	<form action="${pageContext.request.contextPath}/servlet/to" method="post">
		<input type="hidden" name="op" value="select">
		<input type="hidden" name="aim" value="/opus/to/list.jsp">
		名称:<input type="text" name="name" size="3">
		老师:<input type="text" name="username" size="3"> 
		原唱歌手：<input type="text" name="singer" size="3"> 
		风格：<input type="text" name="state" size="3">
		收藏量：<input type="text" name="lowl" size="2">~<input type="text" name="highl" size="2">
		<input type="submit" value="搜索">
	</form>
	<a href="${pageContext.request.contextPath}/opus/like.jsp">收藏界面</a>
	<hr>
		<table width="85%">
			<tr>
				<th>id</th>		
				<th>名称</th>		
				<th>所属老师</th>		
				<th>图片</th>		
				<th>视频</th>		
				<th>原唱歌手</th>		
				<th>分类/风格</th>		
				<th>操作</th>		
			</tr>
		<c:forEach items="${requestScope.toList}" var="to">
			<tr>
				<td>${to.id}</td>
				<td>${to.name}</td>
				<td>${to.username}</td>
				<td>
					<img alt="opus" width="100" height="100" 
					src="${pageContext.request.contextPath}/${to.img}"> 
				</td>
				<td>
					<img alt="opus" width="100" height="100" 
					src="${pageContext.request.contextPath}/${to.video}"> 
				</td>
				<td>${to.singer}</td>
				<td>${to.state}</td>
				<td>
					<form action="${pageContext.request.contextPath}/servlet/like" method="get">
						<input type="hidden" name="op" value="add">
						<input type="hidden" name="id" value="${to.id}">
						<input type="submit" value="收藏">
					</form>
				</td>
			</tr>
	</c:forEach>
		</table>
</body>
</html>
