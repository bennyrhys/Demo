<%@page import="com.zparkep.bean.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加老师</title>
<style type="text/css">
	table{
	margin: 200PX auto ;
	}
	tr,td{
		text-align: center;
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/servlet/teacher" method="post"  enctype="multipart/form-data">
		<table  cellpadding="10PX" cellspacing="20PX" background="" bgcolor="#ccc" >
		<input type="hidden" name="op" value="add">
		<th colspan="2">人员管理：教师类</th>
		<tr><td>姓名:</td><td><input type = "text" name = "name" ></td></tr>
		<tr><td>头像:</td><td><input type="file" name="img"></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="添加老师"></td></tr>
		</table>
	</form>
</body>
</html>