<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	  <meta charset="utf-8"/>
	  <meta name="Generator" content="EditPlus®">
	  <meta name="Author" content="Bennyrhys——郭瑞新">
	  <meta name="Keywords" content="吉他易学网/EasyGuitar，好学又不贵的免费吉他网">
	  <meta name="Description" content="带上女朋友一起来弹吉他">
	  <title>吉他易学网/EasyGuitar：主页面</title>
	  <link href="css/main.css" rel="stylesheet" type="text/css">
	  <script src="js/main.js" type="text/javascript" charset="utf-8"></script>
	  <script type="text/javascript" src="js/mian.js" ></script>
	<body>
		<div class="main">
			<!--用户提醒-->
			<div class="text">
				<a href="houlogin.jsp"><img width="30px" height="30px" src="img/tixing.png" /></a>
				<span class="word">欢迎来到干货最多的吉他教学网站，没有之一！！！</span>
			</div>
			<!--居中-->
			<div class="juzhong">
				<!--插图-->
				<div class="chatu">
					<a href=""><img class="tu1" src="img/chatu1.png"/></a>
					<a href=""><img class="tu2" src="img/chatu2.png"/></a>
				</div>
				<!--
                	作者：bennyrhys@163.com
                	时间：2018-07-28
                	描述：滚图
                -->
				<div class="guntu">
									    <div id="wrapper">
					
						<img src="img/movingboxes.png" alt="moving boxes" />
				    
				        <div id="slider">    
				
				            <img class="scrollButtons left" src="img/leftarrow.png">
				
							<div style="overflow: hidden;" class="scroll">
					
								<div class="scrollContainer">
					
					                <div class="panel" id="panel_1">
										<div class="inside">
											<img src="img/1.jpg" alt="picture" />
											<h2>News Heading</h2>
											<p>A very shot exerpt goes here... <a href="http://v.yinyuetai.com/video/2064861" >more link</a></p>
										</div>
									</div>
				
					                <div class="panel" id="panel_2">
										<div class="inside">
											<img src="img/2.jpg" alt="picture" />
											<h2>News Heading</h2>
											<p>A very shot exerpt goes here... <a href="http://v.yinyuetai.com/video/2064861" target="_self">more link</a></p>
										</div>
									</div>
								
					                <div class="panel" id="panel_3">
										<div class="inside">
											<img src="img/3.png" alt="picture" />
											<h2>News Heading</h2>
											<p>A very shot exerpt goes here... <a href="http://flickr.com/photos/ruudvanleeuwen/468309897/">more link</a></p>
										</div>
									</div>
									
									<div class="panel" id="panel_4">
										<div class="inside">
											<img src="img/4.jpg" alt="picture" />
											<h2>News Heading</h2>
											<p>A very shot exerpt goes here... <a href="http://flickr.com/photos/emikohime/294092478/">more link</a></p>
										</div>
									</div>
									
									<div class="panel" id="panel_5">
										<div class="inside">
											<img src="img/5.jpg" alt="picture" />
											<h2>News Heading</h2>
											<p>A very shot exerpt goes here... <a href="http://flickr.com/photos/fensterbme/499006584/">more link</a></p>
										</div>
									</div>
								
				                </div>
				
								<div id="left-shadow"></div>
								<div id="right-shadow"></div>
				            </div>
							<img class="scrollButtons right" src="img/rightarrow.png">
				        </div>
				    	</div>
						<div style="width:550px;margin:20px auto;">
					</div>
<!--  ==========  -->
<!--  = 滚图结束 =  -->
<!--  ==========  -->
<!--展板导航-->
<!--竖线怎么处理-->
					<div class="zhanban">
						<ul>
							<li><a href="">
								<div class="ban1"><img src="img/jiaoxuezhiyuan.png"/></div>
								<div class=""><span class="word"><h2>新手入门</h2></span></div>
							</a></li>
							<li><a href="${pageContext.request.contextPath}/servlet/to?op=userlist">
								<div class="ban1"><img src="img/jiaoxuezhiyuan.png"/></div>
								<div class=""><span class="word"><h2>教学资源</h2></span></div>
							</a></li>
							<li><a href="">
								<div class="ban1"><img src="img/VIP.png"/></div>
								<div class=""><span class="word"><h2>VIP入口</h2></span></div>
							</a></li>
							<li><a href="${pageContext.request.contextPath}/servlet/opus?op=userlist">
								<div class="ban1"><img src="img/qingyouzuopin.png"/></div>
								<div class=""><span class="word"><h2>琴友侃大山</h2></span></div>
							</a></li>
							<li><a href="">
								<div class="ban1"><img src="img/zahuopu.png"/></div>
								<div class=""><span class="word"><h2>杂货铺</h2></span></div>
							</a></li>
						</ul>
					</div>
					
				  <!--  ==========  -->
				  <!--  = 分区展示 =  -->
				  <!--  ==========  -->
				  <!-- <div class="zuixin">
				  	最新内容
				  </div>
				  <div class="zhuanji">
				  	专辑
				  </div>
				  <div class="remen">
				  	热门
				  </div>
				  <div class="leibie">
				  	类别 /友情链接
				  </div> -->
				 
		
					<!--  ==========  -->
					<!--  = 类别结束 =  -->
					<!--  ==========  -->
				</div>
				<!--页尾-->
				<div class="footer">
					<foot>
						<div class="foot2"><div class="footin">
								<p style="color: black;font-size: 60px;text-align: center;">说明SHU</p>
								<p>&nbsp;</p>
								<p style="color: #A8A8A8;font-size: 25px;text-align: center; ">author:bennyrhys@163.com</p>	
								<p style="color: #A8A8A8;font-size: 25px;text-align: center;">data_time:2018年9月1日 19:32:37</p>	
								<p style="color: #A8A8A8;font-size: 25px;text-align: center;">section：EasyGuitar</p>	
								<p>&nbsp;</p><p>&nbsp;</p>
								<p style="color:#12B1E1;font-size: 25px;text-align: center;">当往事已成云烟，浮华慢慢退去，蓦然回首，君犹在，念我如初，我终生所求……</p>	
							</div></div>
							<div class="foot3"><div class="footin">
								<div class="foot_xuanchuan1">
									<p style="color: #A8A8A8;font-size: 20px;width: 225px;height: 30px;margin: 0 auto;"><a href="">站内链接</a>&nbsp;|&nbsp;<a href="">友情链接</a></p>
									<ul style="width: 200px; height: 50px;margin:-60px auto"> 
									   <li><a href=""><img src="img/ft_vd.png"/></a></li>
									   <li><a href=""><img src="img/ft_vr.png"/></a></li>
									   <li><a href=""><img src="img/ft_wb.png"/></a></li>
									   <li><a href=""><img src="img/ft_wx.png"/></a></li>
									</ul>
									
								</div>
								<div class="foot_xuanchuan2"></div>
								<div class="foot_xuanchuan3">
									<table style="margin: -20px auto;">
										<tr><td><img src="img/ft-ar.png"/><a href="">最新资讯</a></td><td><img src="img/ft-ar.png"/><a href="">联系作者</a></td><td><img src="img/ft-ar.png"/><a href="">最新评论</a></td><td><img src="img/ft-ar.png"/><a href="">强力推荐</a></td></tr>
										
									</table>
								</div>
							</div></div>
							<div class="foot4">
								<p style="color: white;font-size: 16px;text-align: center; text-align: center;">版权所有@EasyGuitar</p>
							</div>
						</foot>
				</div>
				<!--页尾结束-->
				
			</div>
			
		</div>
	</body>
</html>
