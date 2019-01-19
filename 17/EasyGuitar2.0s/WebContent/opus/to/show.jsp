<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品页面</title>
<style type="text/css">
	table,tr,th,td{
		border: 1px solid red;
		border-collapse:collapse;
	}
</style>
<link rel="stylesheet" type="text/css" href="../../css/section_show.css"/>
<!-- 相册放大 -->
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <style>
		
        img{cursor: pointer;}
        #pic{position: absolute; display: none;}
        #pic1{ width: 100%; height: 100%; border-radius: 5px; -webkit-box-shadow: 5px 5px 5px 5px hsla(0,0%,5%,1.00); box-shadow: 5px 5px 5px 0px hsla(0,0%,5%,0.3); } 
        .z{
        	text-align: center;
        	margin: 200px auto;
        }
    </style>
</head>
<body>
	<!--
    	作者：bennrhys@163.com
    	时间：2018-08-19
    	描述：标题
    -->
    	<div class="section">
	
			<div class="head">
				<div class="into">
				<a href="houlogin.html"><img width="30px" height="30px" src="../../img/tixing.png" /></a>
				<span class="word">欢迎来到干货最多的吉他教学网站，没有之一！！！</span>
				</div>
			</div>
			<div class="tupian">
					<a href=""><img class="tu1" src="../../img/chatu1.png"/></a>
					<a href=""><img class="tu2" src="../../img/chatu2.png"/></a>
			</div>
			<div class="teach">
				 <!--
    	作者：bennrhys@163.com
    	时间：2018-08-19
    	描述：内容
    -->
	<div class="neirong">
			<div class="neirong_into">
				<ul>
					<li><a target="_self" href="${pageContext.request.contextPath}/servlet/main"><img src=""/>首页</a></li>&nbsp;
					<li><a target="_self" href="${pageContext.request.contextPath}/servlet/to?op=userlist"><img src=""/>视频教程</a></li>&nbsp;
					<li><a target="_self" href="${pageContext.request.contextPath}/servlet/like?op=add&id=${to.id}&to_id=${to.id}"><img src=""/>收藏</a></li>
					<li><a target="_self" href="">歌曲信息：${to.name }&nbsp;&nbsp;来自：${to.username}老师&nbsp;&nbsp;风格：${to.state }</a></li>
				</ul>
			
			<div class="view">
				<div class="view_into">
					<img alt="海报区"  src="${pageContext.request.contextPath}/${to.img}">
				</div>
			</div>
			<div class="shipin">
				<div class="shipin_into">
				
				     <embed src="${to.video}" width="100%" height="100%" align="middle" ></embed>
				</div>
			</div>
			<c:forEach items="${sessionScope.qupuList}" var="qp">
			<div class="shipin">
				<div class="shipin_into">
					
					<td >
					<dir  class="container" >
						<%-- <img alt="曲谱区"  src="${pageContext.request.contextPath}/${qp.img }"> --%>
						<a href="${pageContext.request.contextPath}/${qp.img }"><img alt="曲谱区"  src="${pageContext.request.contextPath}/${qp.img }" ></a>
					</dir>	
					</td>
				
				</div>
			</div>
			</c:forEach>
			<div class="pinglun">
				
				<form action="${pageContext.request.contextPath}/servlet/comment">
				<div class="shuru">
					
					<div class="text">
						<input type="hidden" name="op" value="add">
						<input type="hidden" name="to_id" value="${to.id}">
						<input type="text" name="comment2" size="95" maxlength="150" >
					</div>
					<div class="button">
						<input type="submit" value="评论">
					</div>
				</div>
				</form>
				<div class="tishi">
					<span class="word">
						请用户老爷先登录，在进行收藏评论!!! 【温馨提醒：150字内哦！！！】
					</span>
				</div>
				<div class="qu">
				<c:forEach items="${sessionScope.cList2}" var="comment">
					<%-- <table width="85%">
						<tr>
							<th>评论者</th>
							<th colspan="6">评论内容</th>
							<th>评论时间</th>
							<th>操作</th>
						</tr>
						<tr>
							<td rowspan="2">${comment.username }</td>
							<td rowspan="2" colspan="6">${comment.comment	 }</td>
							<td rowspan="2">${comment.date }</td>
							<td><a href="${pageContext.request.contextPath}/servlet/comment?op=delete&id=${comment.id}&to_id=${to.id}">删除</a></td>
						</tr>
					</table> --%>
					<div class="name">
						${comment.username }:&nbsp;${comment.comment }
					</div>
					<div class="time">
						<span style="float: left;">${comment.date }</span>
						<span style="float: right;"><a href="${pageContext.request.contextPath}/servlet/comment?op=delete&id=${comment.id}&idd=${opus.id}">删除</a></span>
					</div>
					<p><hr /></p>
				</c:forEach>
				</form>
				</div>
								
			</div>
		</div>
	</div>
		<!--
	    	作者：bennyrhys@163.com
	    	时间：2018-07-30
	    	描述：广告
	    -->
		<div class="guanggao">
			<div class="into1">
				<a href=""><img src="../../img/timg.jpg"/></a>
			</div>
			<!-- <div class="into2">
				<a href=""><img src="../../img/guang.pngg"/></a>
			</div>
			<div class="into3">
				<a href=""><img src="../../img/guang7.png"/></a>
			</div> -->
		</div>
			</div>
		</div>
	<!--  ==========  -->
	<!--  = 上方html =  -->
	<!--  ==========  -->
		<!--<a href="${pageContext.request.contextPath}/servlet/main">首页</a>
		&nbsp;>&nbsp;
		<a href="${pageContext.request.contextPath}/servlet/to?op=userlist">视频教程</a>
		&nbsp;>&nbsp;正文
		<br><br>
		<a style="float:right;" href="${pageContext.request.contextPath}/servlet/like?op=add&id=${opus.id}&idd=${opus.id}">收藏</a><br>
		<hr>
		<h3>${to.name }</h3>
		${to.username}&nbsp;&nbsp;${to.state }
		<br>
		<img alt="opus" width="80" height="80" src="${pageContext.request.contextPath}/${to.img}"><br>	
		<img alt="opus" width="80" height="80" src="${pageContext.request.contextPath}/${to.video}">
			<table>
			<tr>
				<c:forEach items="${sessionScope.qupuList}" var="qp">
					<td>
						<img alt="qupu" width="50" height="50" 
						src="${pageContext.request.contextPath}/${qp.img }">
					</td>
				</c:forEach>
			</tr>
			</table>
		<c:forEach items="${sessionScope.cList2}" var="comment">
			<table width="85%">
				<tr>
					<th>评论者</th>
					<th colspan="6">评论内容</th>
					<th>评论时间</th>
					<th>操作</th>
				</tr>
				<tr>
					<td rowspan="2">${comment.username }</td>
					<td rowspan="2" colspan="6">${comment.comment	 }</td>
					<td rowspan="2">${comment.date }</td>
					<td><a href="${pageContext.request.contextPath}/servlet/comment?op=delete&id=${comment.id}&to_id=${to.id}">删除</a></td>
				</tr>
			</table>
		</c:forEach>
			<table width="85%">
				<tr>
				<td>
				评论：
				</td>
				<td colspan="6">
					<form action="${pageContext.request.contextPath}/servlet/comment">
						<input type="hidden" name="op" value="add">
						<input type="hidden" name="to_id" value="${to.id}">
						<input type="text" name="comment2" size="150">
						<input type="submit" value="评论">
					</form>
				</td>
			</tr>
			</table>
			-->
</body>
<script>
<!--  ==========  -->
<!--  = 相册放大js =  -->
<!--  ==========  -->
    $(function(){
        $(".container a").hover(function(){
            $(this).append("<p id='pic'><img src='"+this.href+"' id='pic1'></p>");
            $(".container a").mousemove(function(e){
                $("#pic").css({
                    "top":(e.pageY-300)+"px",
                    "left":(e.pageX-400)+"px"
                }).fadeIn("fast");
                // $("#pic").fadeIn("fast");
            });
        },function(){
            $("#pic").remove();
        });
    });
</script>
</html>