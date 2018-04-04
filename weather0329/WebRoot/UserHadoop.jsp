


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<title>Codester | Work</title>
	<meta charset="utf-8">
	<link rel="icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon">
    <link rel="shortcut icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon" />
    <meta name="description" content="Codester is a free responsive Bootstrap template by Dzyngiri">
    <meta name="keywords" content="free, template, bootstrap, responsive">
    <meta name="author" content="Inbetwin Networks">  
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/touchTouch.css" type="text/css" media="screen">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/superfish.js"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>  
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script type="text/javascript" src="js/touchTouch.jquery.js"></script> 
    
	<script type="text/javascript">if($(window).width()>1024){document.write("<"+"script src='js/jquery.preloader.js'></"+"script>");}	</script>
	<script>		
		 jQuery(window).load(function() {	
		 $x = $(window).width();		
	if($x > 1024)
	{			
	jQuery("#content .row").preloader();    }			 
	 jQuery('.magnifier').touchTouch();
		 jQuery('.spinner').animate({'opacity':0},1000,'easeOutCubic',function (){jQuery(this).css('display','none')});	
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
          _gaq.push(['_setAccount', 'UA-29231762-1']);
          _gaq.push(['_setDomainName', 'dzyngiri.com']);
          _gaq.push(['_trackPageview']);
        
          (function() {
            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
          })();
      </script>
	</head>

	<body>
<div class="spinner"></div>
<header>
    <div class="container clearfix">
        <div class="row">
            <div class="span12">
                <div class="navbar navbar_">
                    <div class="container">
                        <h1 class="brand brand_"><a href="index.html"><!--<span class="header1">Weather Forecast </span>--><img alt="" src="img/mine/icon.jpg"> </a></h1>
                        <a class="btn btn-navbar btn-navbar_" data-toggle="collapse" data-target=".nav-collapse_">Menu <span class="icon-bar"></span> </a>
                        <div class="nav-collapse nav-collapse_  collapse">
                            <ul class="nav sf-menu">
                                <li><a href="" onclick="ale()">用户管理</a></li>
                                <li><a href="UserWeatherModify.jsp">历史数据</a></li>
                                <li class="active"><a href="UserHadoop.jsp">数据分析</a></li>
                                <li class="sub-menu"  ><a>文献资料</a>
                                    <ul>
                                        <li><a href="UserUpLoad.jsp">文件上传</a></li>
                                        <li><a href="servlet/UserListFileServlet">文件下载</a></li>
                                        <li><a href="UserProcess3.jsp">可读文档</a></li>
                                    </ul>
                                </li>
                                <li><a href="UserMessageboard.jsp">意见反馈</a></li>
                                <%String name=(String)session.getAttribute("name"); %>
                                <li><p3>欢迎，<%=name%></p3><button onclick="window.location.href='home.jsp'">退出</button> </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="bg-content">
    <h2>基于Hadoop的大数据处理</h2>
    <!-- content-->
    <br>
    <h5>2016年中国年平均气温估算</h5><br>
    <img src="img/mine/cloudy5.jpg">
    <br><br>
    <a href="http://120.25.121.224:50075/browseBlock.jsp?blockId=-8742965434148569525&blockSize=8&genstamp=1011&filename=%2Fusr%2Fhadoop%2Fout1%2Fpart-r-00000&datanodePort=50010&namenodeInfoPort=50070">查看结果！</a>
</div>

<!--  footer  -->
<footer>
    <div class="container clearfix">
        <ul class="list-social pull-right">
            <li><a class="icon-1" href="#"></a></li>
            <li><a class="icon-2" href="#"></a></li>
            <li><a class="icon-3" href="#"></a></li>
            <li><a class="icon-4" href="#"></a></li>
        </ul>
        <div class="privacy pull-left">&copy; 2017 | <a href="http://www.google.com">Title : Online Weather Forecast</a> | <a href="http://twitter.github.com/bootstrap/" target="_blank">Bootstrap</a> | Demo Illustrations by <a href="http://www.sdufe.edu.cn" target="_blank">Liuzhen Xingyao</a></div>
    </div>
</footer>

<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>