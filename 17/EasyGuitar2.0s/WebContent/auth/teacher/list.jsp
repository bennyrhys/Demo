<%@page import="com.zparkep.bean.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老师列表</title>
<style type="text/css">
	table,tr,th,td{
		border: 1px solid #ccc;
		text-align: center;
	}
</style>
</head>
<body>
	<a href="${pageContext.request.contextPath}/auth/teacher/add.jsp">添加老师</a>
	<hr>
	<form action = "${pageContext.request.contextPath}/servlet/teacher" method = "post">
	    <input type="hidden" name="op" value="search">
		<input type="hidden" name="aim" value="/auth/teacher/list.jsp">
	    编号:<input type = "text" name = "id" size="3">
	    姓名:<input type = "text" name = "name" size="3">
	    <input type = "submit" value = "搜索老师">
	</form>
	
	<table width="100%" height="150px" cellpadding="0" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>姓名</th>
		    <th>头像</th>
			<th colspan="2">操作</th>
		</tr>
		<c:forEach items="${requestScope.teacherList }" var="teacher">
			<tr>
				<td>${teacher.id }</td>
				<td>${teacher.name }</td>
				<td>
					<img alt="user" width="85" height="85" src="${pageContext.request.contextPath }/${teacher.img }">
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/servlet/teacher?op=findById&id=${teacher.id}">修改</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/servlet/teacher?op=delete&id=${teacher.id}">删除</a>
				</td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>