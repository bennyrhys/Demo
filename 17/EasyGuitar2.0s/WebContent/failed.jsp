<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>失败页面</title>
</head>
<body>
	失败页面
	<script type="text/javascript">
		setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
			window.location.href="${pageContext.request.contextPath }/${aim }&id=${id3}";     //
		},1000);
	</script>
</body>
</html>