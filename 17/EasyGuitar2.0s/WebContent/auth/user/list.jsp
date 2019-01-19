<%@page import="com.zparkep.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表</title>
<style type="text/css">
	a{
		text-decoration: none;
	}
	table,tr,th,td{
		border: 1px solid #ccc;
		text-align: center;
	}
</style>
</head>
<body>
	<a href="${pageContext.request.contextPath}/auth/user/add.jsp">添加客户</a>
	<hr>
	<form action = "${pageContext.request.contextPath}/servlet/user" method = "post">
	    <input type="hidden" name="op" value="search">
		<input type="hidden" name="aim" value="/auth/user/list.jsp">
	    nickname:<input type = "text" name = "nickname" size="3">
	    username:<input type = "text" name = "username" size="3">
	    gender:<input type = "text" name = "gender" size="3">
	    intro:<input type = "text" name = "intro" size="3">
	    addr:<input type = "text" name = "addr" size="3">
	    age:<input type = "text" name = "lowage" size="3">~
       <input type = "text" name = "highage" size="3">
	    <input type = "submit" value = "搜索用户">
	</form>
	
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>昵称</th>
			<th>密码</th>
			<th>年龄</th>
			<th>性别</th>
			<th>邮箱</th>
			<th>头像</th>
			<th>简介</th>
			<th>地址</th>
			<th>微博</th>
			<th colspan="6">操作</th>
		</tr>
		<c:forEach items="${requestScope.userList }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.nickname }</td>
				<td>${user.password}</td>
				<td>${user.age}</td>
				<td>${user.gender}</td>
				<td>${user.mail}</td>
				<td>
					<img alt="user" width="100" height="100" src="${pageContext.request.contextPath }/${user.img }">
				</td>
				<td>${user.intro}</td>
				<td>${user.addr}</td>
				<td>${user.weibo}</td>
				<td>
					<a href="${pageContext.request.contextPath }/servlet/user?op=findById&id=${user.id}">修改</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/servlet/user?op=delete&id=${user.id}">删除</a>
				</td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>