<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<%@ page import="bean.Province"%>
<%@ page import="dao.ProvinceDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Weather Forecast</title>

</head>

<body>
	<div class="spinner"></div>

	<!-- start of header -->
	<jsp:include page="/pattern/Header.jsp"></jsp:include>
	<!-- end of header -->


	<div class="bg-content">
		<div class="container">
			<div class="row">
				<div class="span12">

					<!--start of slider-->
					<jsp:include page="/pattern/Slider.jsp"></jsp:include>
					<!--end of slider-->

					<span id="responsiveFlag"></span>
					<div class="block-slogan">
						<h2>Join Us!</h2>
						<div>
							<p>在当代，气象变化难以预测，未知的天气给人们的出行带来了很多的麻烦</p>
							<p class="font1">而现在，你与预知未来，只有一个网站的距离</p>
							<c:if test="${user==null&&admin==null }">
								<p style="text-align:center; padding-top:20px;">
									<a href="login.ui" class="btn btn-1">登录 / 注册</a>
								</p>
							</c:if>

						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- content -->

		<div id="content" class="content-extra">
			<div class="ic"></div>
			<div class="row-1">
				<div class="container">
					<div class="row">
						<article class="span12">
						<h4>Our Work</h4>
						</article>
						<div class="clear"></div>
						<ul class="portfolio clearfix">
							<li class="box"><a href="tempmap.html"><img alt=""
									src="img/mine/work1.jpg"> </a></li>
							<li class="box"><a href="pressure.html"><img alt=""
									src="img/mine/work2.jpg"> </a></li>
							<li class="box"><a href="wind.html"><img alt=""
									src="img/mine/work3.jpg"> </a></li>
							<li class="box"><a href="precipitation.html"><img alt=""
									src="img/mine/work4.jpg"> </a></li>
							<li class="box"><a href="humidity.html"><img alt=""
									src="img/mine/graph3.jpg"> </a></li>
							<li class="box"><a href="Regression.jsp"><img alt=""
									src="img/mine/graph4.jpg"> </a></li>
							<li class="box"><a
								href="https://www.juhe.cn/docs/api/id/226"><img alt=""
									src="img/mine/graph1.jpg"> </a></li>
							<li class="box"><a href="http://www.cma.gov.cn/"><img
									alt="" src="img/mine/graph2.jpg"> </a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row-2">
				<div class="container">
					<h3>专业高效的气象服务</h3>
					<h3>使用简单，操作方便，结果易于理解，适用于更广泛的人群!</h3>
					<p>数据来源可靠、准确，提供高准度的个性化服务，为您的地区提供更加完善的报告</p>
					<a href="AdminListener.jsp" class="btn btn-1">监听器</a>
				</div>
			</div>
			<div class="row-1">
				<div class="container">
					<div class="row">
						<article class="span12">
						<h4>网站简介</h4>
						</article>
						<ul class="thumbnails thumbnails-1">
							<li class="span3">
								<div class="thumbnail thumbnail-1">
									<h3>Web Design</h3>
									<img src="img/mine/graph5.jpg" alt="">
									<section> <a href="#"><h3>前端使用bootstrap框架
											http://www.bootcss.com/</h3> </a>
									<div class="meta">
										<time datetime="2018-04-17" class="date-1"> <i
											class="icon-calendar"></i> 17.04.2018</time>
										<div class="name-author">
											<i class="icon-user"></i> <a href="#">Admin</a>
										</div>
										<a href="Messageboard.jsp" class="comments"><i
											class="icon-comment"></i> 7 comments</a>
									</div>

									<div class="clear"></div>
									<p>设计者：刘震，邢尧，张博文</p>
									<a href="http://www.bootcss.com/" class="btn btn-1">Read
										more</a> </section>
								</div>
							</li>
							<li class="span3">
								<div class="thumbnail thumbnail-1">
									<h3>Graphics</h3>
									<img src="img/mine/graph6.jpg" alt="">
									<section> <a href="#"><h3>图片来源于500px网站
											https://500px.com/</h3> </a>
									<div class="meta">
										<time datetime="2018-04-17" class="date-1"> <i
											class="icon-calendar"></i> 17.04.2018</time>
										<div class="name-author">
											<i class="icon-user"></i> <a href="#">Admin</a>
										</div>
										<a href="Messageboard.jsp" class="comments"><i
											class="icon-comment"></i> 4 comments</a>
									</div>
									<div class="clear"></div>
									<p>表格创意来源于echarts插件</p>
									<a href="http://echarts.baidu.com/" class="btn btn-1">Read
										More</a> </section>
								</div>
							</li>
							<li class="span3">
								<div class="thumbnail thumbnail-1">
									<h3>Social Media</h3>
									<img src="img/mine/graph7.jpg" alt="">
									<section> <a href="#"><h3>项目Github：https://github.com/yanshanbigboy/weather</h3>
									</a>
									<div class="meta">
										<time datetime="2018-04-17" class="date-1"> <i
											class="icon-calendar"></i> 17.04.2018</time>
										<div class="name-author">
											<i class="icon-user"></i> <a href="#">Admin</a>
										</div>
										<a href="Messageboard.jsp" class="comments"><i
											class="icon-comment"></i> 9 comments</a>
									</div>
									<div class="clear"></div>
									<p>网站已发布，项目也已开源到Github网站</p>
									<a href="https://github.com/yanshanbigboy/weather"
										class="btn btn-1">Read More</a> </section>
								</div>
							</li>
							<li class="span3">
								<div class="thumbnail thumbnail-1">
									<h3 class="title-1 extra">Research Data</h3>
									<img src="img/mine/graph8.jpg" alt="">
									<section> <a href="#"><h3>数据主要来源于美国国家海洋和大气管理局和中国气象局</h3>
									</a>
									<div class="meta">
										<time datetime="2018-04-17" class="date-1"> <i
											class="icon-calendar"></i> 17.04.2018</time>
										<div class="name-author">
											<i class="icon-user"></i> <a href="#">Admin</a>
										</div>
										<a href="Messageboard.jsp" class="comments"><i
											class="icon-comment"></i> 1 comment</a>
									</div>
									<div class="clear"></div>
									<p>Noaa气象数据下载，详见Read more</p>
									<a href="ftp://ftp.ncdc.noaa.gov/pub/data/noaa"
										class="btn btn-1">Read More</a> </section>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="container">
				<div class="row">
					<article class="span6">
					<h3>简介</h3>
					<div class="wrapper">
						<figure class="img-indent"> <img src="img/mine/us.jpg "
							alt="" /></figure>
						<div class="inner-1 overflow extra">
							<div class="txt-1">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								我们是致力于通过大数据气象统计和数据分析，来给政府部门、社会组织和市民提供精准有效的气象预测和分析。
								并提供精准的数据查询，方便广大学者和研究人员收集数据进行数据挖掘，同时提供最新的气象研究论文，开放讨论区，
								支持广大气象爱好者进行科研交流。</div>
						</div>
					</article>
					<article class="span6">
					<h3>友情链接</h3>
					<div class="wrapper">
						<ul class="list list-pad">
							<li><a href="https://500px.com/">500Px</a></li>
							<li><a href="http://echarts.baidu.com/">Echarts</a></li>
							<li><a href="http://www.bootcss.com/">Bootstrap</a></li>
							<li><a href="http://www.hcharts.cn/">Highcharts</a></li>
						</ul>
						<ul class="list list-pad">
							<li><a href="https://git-scm.com/">Git</a></li>
							<li><a href="http://mvnrepository.com/">Maven</a></li>
							<li><a href="https://github.com/">GitHub</a></li>
							<li><a href="http://www.sdufe.edu.cn/">山东财经大学</a></li>
						</ul>
						<ul class="list list-pad">
							<li><a href="ftp://ftp.ncdc.noaa.gov/pub/data/noaa">Data</a>
							</li>
							<li><a href="http://www.cma.gov.cn/">中国气象局</a></li>
							<li><a
								href="https://github.com/yanshanbigboy/weather/tree/master/weather0329">我们的github项目</a>
							</li>
							<li><a
								href="https://cloud.tencent.com/?fromSource=gwzcw.234975.234975.234975">腾讯云</a>
							</li>
						</ul>
						<ul class="list">
							<li><a href="http://www.cnki.net/">中国知网</a></li>
							<li><a href="https://ww2.mathworks.cn/">MATLAB</a></li>
							<li><a href="http://www.mathtype.cn/">MathType</a></li>
							<li><a
								href="https://baike.baidu.com/item/%E5%9B%9E%E5%BD%92%E5%88%86%E6%9E%90/2625498?fr=aladdin">回归分析</a>
							</li>
						</ul>
					</div>
					</article>
				</div>
			</div>
		</div>
	</div>

	<!--start of footer  -->
	<jsp:include page="/pattern/Footer.jsp"></jsp:include>
	<!--end of footer  -->

	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>