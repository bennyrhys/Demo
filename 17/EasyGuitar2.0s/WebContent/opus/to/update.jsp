<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改教程</title>
<style type="text/css">
	table,tr,th,td{
		border: 1px solid #ccc;
		text-align: center;
		margin: 20px auto;
	}
</style>
</head>
<body>
    <table  cellpadding="10PX" cellspacing="0PX" background="" bgcolor="#ccc" >
    	
	<form action="${pageContext.request.contextPath}/servlet/to" method="post" enctype="multipart/form-data">
		<input type="hidden" name="op" value="update">
		<input type="hidden" name="id" value="${to.id }">
		<input type="hidden" name="cnumber" value="${to.cnumber}">
		<input type="hidden" name="lnumber" value="${to.lnumber}">
		<input type="hidden" name="lastImg" value="${to.img }"> 
		<input type="hidden" name="lastVideo" value="${to.video }">
		<th>修改教程：教师类</th>
    	<tr><td>name:</td><td><input type="text" name="name" value="${to.name }"></td></tr>
    	<tr><td>username:</td><td><input type="text" name="username" value="${to.username }"></td></tr>
    	<tr><td><img alt="opus" width="150" height="100" src="${pageContext.request.contextPath}/${to.img}"></td><td><input type="file" name="img"></td></tr>
    	<tr><td>video:</td><td><input type="text" name="video" value="${to.video}"></td></tr>
    	<tr><td>singer:</td><td><input type="text" name="singer" value="${to.singer }"></td></tr>
    	<tr><td>state:</td><td><input type="text" name="state" value="${to.state }"></td></tr>
    	<tr><td colspan="2"><input type="submit" value="确认修改"></td></tr>
    	
	</form>
	
	<form action="${pageContext.request.contextPath}/servlet/qupuimg" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="op" value="update">
		<input type="hidden" name="id" value="${qupuimg.id }">
		<input type="hidden" name="img" value="${qupuimg.img }"> 
		<th>曲谱修改：教师类</th>
		<tr><td>opus_id:</td><td><input type="text" name="opus_id" value="${qupuimg.opus.id }"></td></tr>
    	<tr><td><img alt="qupuimg" width="150" height="100" src="${pageContext.request.contextPath}/${qupuimg.img}"></td><td><input type="file" name="img"></td></tr>
    	<tr><td colspan="2"><input type="submit" value="确认修改"></td></tr>
	</form>
	</table>
</body>
</html>