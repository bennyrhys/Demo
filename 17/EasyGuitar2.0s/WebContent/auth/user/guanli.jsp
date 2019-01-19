<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人主页</title>
<style type="text/css">
	div{
		border:1px solid #000;
		text-align:center;
		border-collapse:collapse;
		border-spacing:0;
		
	}
	li{
		float: left;
		list-style: none;
		padding: 20px;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
   <div>
     <c:if test="${sessionScope.user == null }">
		 <li><a href="${pageContext.request.contextPath }/servlet/user?op=login">登录</a></li>
	 </c:if>
	 <c:if test="${sessionScope.user != null }">
         <li><a href = "${pageContext.request.contextPath }/opus/opus/show.jsp">我的作品</a></li>
         <li><a href = "${pageContext.request.contextPath }/opus/like.jsp">我的收藏</a></li>
         <li><a href = "${pageContext.request.contextPath }/servlet/user?op=update&id=${user.id}">修改個人信息</a></li>     
	     <li></li>
     </c:if>
   </div>


</body>
</html>