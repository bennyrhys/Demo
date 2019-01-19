<%@page import="com.zparkep.bean.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改老师信息</title>
<style type="text/css">
	table{
	margin: 150PX auto ;
	}
	tr,td{
		text-align: center;
	}
</style>
</head>
<body>
	<table cellpadding="10PX" cellspacing="20PX" background="" bgcolor="#ccc">
	<form action="${pageContext.request.contextPath}/servlet/teacher?op=update" method="post"  enctype="multipart/form-data">
		<input type="hidden" name="op" value="update">
		<input type="hidden" name="id" value="${teacher.id }">
		<input type="hidden" name="yuanLaiImg" value="${teacher.img }">
		
		<th colspan="2">人员修改：教师类</th>
		<tr><td colspan="2" align="center"><img alt="头像" width="80" height="80" src="${pageContext.request.contextPath}/${teacher.img }"></td></tr>
		<tr><td>姓名:</td><td><input type = "text" name = "username" value = "${teacher.name }" ></td></tr>
		<tr><td>头像:</td><td><input type="file" name="img" /></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="确认修改"></td></tr>
	</form>
	</table>
</body>
</html>