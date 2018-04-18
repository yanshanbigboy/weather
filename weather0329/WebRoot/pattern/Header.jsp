<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="icon" href="http://dzyngiri.com/favicon.png"
	type="image/x-icon">
<link rel="shortcut icon" href="http://dzyngiri.com/favicon.png"
	type="image/x-icon" />
<meta name="description"
	content="Codester is a free responsive Bootstrap template by Dzyngiri">
<meta name="keywords" content="free, template, bootstrap, responsive">
<meta name="author" content="Inbetwin Networks">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/responsive.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/touchTouch.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/kwicks-slider.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/my.css" type="text/css" media="screen">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/superfish.js"></script>
<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="js/jquery.kwicks-1.5.1.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/touchTouch.jquery.js"></script>
<script type="text/javascript">
	if ($(window).width() > 1024) {
		document.write("<"+"script src='js/jquery.preloader.js'></"+"script>");
	}
</script>

<script>
	jQuery(window).load(function() {
		$x = $(window).width();
		if ($x > 1024) {
			jQuery("#content .row").preloader();
		}

		jQuery('.magnifier').touchTouch();
		jQuery('.spinner').animate({
			'opacity' : 0
		}, 1000, 'easeOutCubic', function() {
			jQuery(this).css('display', 'none')
		});
	});
</script>

<!--[if lt IE 8]>
    <div style='text-align:center'><a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://www.theie6countdown.com/img/upgrade.jpg"border="0"alt=""/></a></div>
    <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<!--<![endif]-->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link rel="stylesheet" href="css/docs.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400' rel='stylesheet' type='text/css'>
    <![endif]-->

<!--Google analytics code-->
<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-29231762-1' ]);
	_gaq.push([ '_setDomainName', 'dzyngiri.com' ]);
	_gaq.push([ '_trackPageview' ]);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>
</head>

<body>
	<div class="spinner"></div>
	<!-- header start -->
	<header>
	<div class="container clearfix">
		<div class="row">
			<div class="span12">
				<div class="navbar navbar_">
					<div class="container">
						<h1 class="brand brand_">
							<a href="AdminIndex.jsp"> <!--<span class="header1">Weather Forecast </span>-->
								<img alt="" src="img/mine/icon.jpg"> </a>
						</h1>
						<a class="btn btn-navbar btn-navbar_" data-toggle="collapse"
							data-target=".nav-collapse_">Menu <span class="icon-bar"></span>
						</a>
						<div class="nav-collapse nav-collapse_  collapse">
							<ul class="nav sf-menu">
								<li><a href="home.jsp">首页</a>
								</li>
								<li><a href="display.user">用户管理</a>
								</li>
								<li><a href="WeatherModify.jsp">历史数据</a>
								</li>
								<li><a href="Hadoop.jsp">数据分析</a>
								</li>
								<li class="sub-menu"><a>文献资料</a>
									<ul>
										<li><a href="Upload.jsp">文档上传</a>
										</li>
										<li><a href="ListFileServlet">文档下载</a>
										</li>
										<li><a href="ShoppingView.jsp">气象数据购买</a>
										</li>
									</ul></li>
								<li><a href="Messageboard.jsp">意见反馈</a>
								</li>

								<li><c:if test="${user!=null}">
										<p3 style="color:white;">&nbsp&nbsp欢迎你，${user.userName} </p3>
										<button onclick="javascript:location.href='logout.listener'">注销</button>
									</c:if> <c:if test="${admin!=null}">
										<p3 style="color:white;">&nbsp&nbsp欢迎你，${admin.adminName}
										<button onclick="javascript:location.href='logout.listener'">注销</button>

										</p3>
									</c:if>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>