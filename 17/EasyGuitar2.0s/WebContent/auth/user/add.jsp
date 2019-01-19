<%@page import="com.zparkep.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户</title>
<style type="text/css">
	table{
	margin: 30PX auto ;
	}
	table,tr, td{
		text-align: center;
	}
</style>
</head>
<body>
		<table  cellpadding="10PX" cellspacing="10PX" background="" bgcolor="#ccc" >
	
	<form action="${pageContext.request.contextPath}/servlet/user" method="post"  enctype="multipart/form-data">
		<input type="hidden" name="op" value="add">
		<th colspan="2">人员管理：琴友类</th>
		<tr><td>username:</td><td><input type = "text" name = "username"  ></td></tr>
		<tr><td>nickname:</td><td><input type = "text" name = "nickname" ></td></tr>
		<tr><td>password:</td><td><input type = "password" name = "password" ></td></tr>
		<tr><td>age:</td><td><input type = "text" name = "age" ></td></tr>
		<tr><td>gender:</td><td><input type = "text" name = "gender" ></td></tr>
		<tr><td>mail:</td><td><input type = "text" name = "mail" ></td></tr>
		<tr><td>img:</td><td><input type="file" name="img"></td></tr>
		<tr><td>intro:</td><td><input type = "text" name = "intro"></td></tr>
		<tr><td>addr:</td><td><input type = "text" name = "addr"></td></tr>
		<tr><td>weibo:</td><td><input type = "text" name = "weibo"></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="添加琴友"></td></tr>
		
	</form>
	</table>
</body>
</html>