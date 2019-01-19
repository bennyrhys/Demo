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
		border: 1px solid ;
		text-align: center;
		border-collapse:collapse;
	}
</style>
</head>
<body>

<!DOCTYPE html>
<html>

				
				<a href="${pageContext.request.contextPath}/opus/to/add.jsp">添加教程</a><br>
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
	
	<hr>
		<table width="100%">
			<tr>
				<th>id</th>		
				<th>名称</th>		
				<th>所属老师</th>		
				<th>图片</th>		
				<th  width="100px">视频</th>		
				<th>原唱歌手</th>		
				<th>分类/风格</th>		
				<th colspan="2">操作</th>	
				
			</tr>
		<c:forEach items="${sessionScope.toList}" var="to">
			<tr>
				<td >
					<a href="${pageContext.request.contextPath}/servlet/to?op=show&id=${to.id}">${to.id}</a>
				</td>
				<td>${to.name}</td>
				<td>${to.username}</td>
				<td>
					<img alt="opus" width="150" height="100" 
					src="${pageContext.request.contextPath}/${to.img}"> 
				</td>
				<td >
					<%-- ${pageContext.request.contextPath}/ --%>
					
					<object  width="150" height="100"  data="${to.video}" ></object>
				</td>
				<td>${to.singer}</td>
				<td>${to.state}</td>
				<td>
					<a href="${pageContext.request.contextPath}/servlet/to?op=find&id=${to.id}">修改</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/servlet/to?op=delete&id=${to.id}">删除</a>
				</td>
				
			</tr>
			<tr>
			<td width="60px">
					<form action="${pageContext.request.contextPath}/servlet/qupu" method="post" enctype="multipart/form-data">
					<input type="hidden" name="op" value="add">
					<input type="hidden" name="to_id" value="${to.id}">
					<input type="file" name="img">
					<input type="submit" value="添加曲谱">
					</form>
				</td>
			
				<c:forEach items="${sessionScope.qupuList}" var="qp">
				<td>
					
						<img alt="qupu" width="150px" height="100px" src="${pageContext.request.contextPath}/${qp.img }">
					
					
					<a href="${pageContext.request.contextPath}/servlet/qupu?op=delete&id=${qp.id}&to_id=${to_id}">删除</a>
					</td>
				</c:forEach>
			
			</tr>
	</c:forEach>
		</table>

	</body>
</html>
