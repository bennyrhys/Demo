<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传教程</title>
<style type="text/css">
	table,tr,th,td{
		border: 1px solid #ccc;
		margin: 100px auto;
		text-align: center;
	}
</style>
</head>
<body>
	<table  cellpadding="10PX" cellspacing="20PX" background="" bgcolor="#ccc" >
	<form action="${pageContext.request.contextPath}/servlet/to" method="post" enctype="multipart/form-data">
		<input type="hidden" name="op" value="add">
		<th>作品添加：教师类</th>
		<tr><td>name:</td><td><input type="text" name="name"></td></tr>
		<tr><td>username:</td><td><input type="text" name="username"></td></tr>
		<tr><td>img:</td><td><input type="file" name="img"></td></tr>
		<tr><td>video:</td><td><input type="text" name="video"></td></tr>
		<tr><td>singer:</td><td><input type="text" name="singer"></td></tr>
		<tr><td>state:</td><td><input type="text" name="state"></td></tr>
		<tr><td colspan="2"><input type="submit" value="上传"></td></tr>
	</form>
	</table>
	<form action="${pageContext.request.contextPath}/servlet/qupu" method="post" enctype="multipart/form-data">
		<input type="hidden" name="op" value="add">
		
	
	
	
	</form>
</body>
</html>