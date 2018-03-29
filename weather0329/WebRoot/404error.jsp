<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"  import="java.io.*" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% String t=session.getAttribute("type").toString();
   int type=Integer.parseInt(t);%>

<script language="javascript">
 function ale()
 {//这个基本没有什么说的，就是弹出一个提醒的对话框
   alert("对不起，您没有相应权限");
 }
 </script>
<head>
<title>Codester | 404 Page not found</title>
    <meta charset="utf-8">
	<link rel="icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon">
    <link rel="shortcut icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon" />
    <meta name="description" content="Codester is a free responsive Bootstrap template by Dzyngiri">
    <meta name="keywords" content="free, template, bootstrap, responsive">
    <meta name="author" content="Inbetwin Networks">  
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/superfish.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>	
	<script>		
   jQuery(window).load(function() {	
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
	 
         
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="spinner"></div>
<!--  header  -->
<header>
      <div class="container clearfix">
    <div class="row">
          <div class="span12">
        <div class="navbar navbar_">
              <div class="container">
                <%if(type==0){ %>
            <h1 class="brand brand_"><a href="AdminIndex.jsp"><img alt="" src="img/mine/icon.jpg"> </a></h1>
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse_">Menu <span class="icon-bar"></span> </a>
            <div class="nav-collapse nav-collapse_  collapse">
                  <ul class="nav sf-menu">
                <li class="active"><a href="UserModify.jsp">用户管理</a></li>
                <li><a href="AdminWeatherModify.jsp">历史数据</a></li>
                <li><a href="Hadoop.jsp">数据分析</a></li>
                <li class="sub-menu"><a >文献资料</a>
                      <ul>
                          <li><a href="AdminProcess1.jsp">文档一</a></li>
                          <li><a href="AdminProcess2.jsp">文档二</a></li>
                          <li><a href="AdminProcess3.jsp">文档三</a></li>
                  </ul>
                    </li>
                <li><a href="contact.html">意见反馈</a></li>
                <%String name=(String)session.getAttribute("name"); %>
                                <li><p3>欢迎，<%=name%></p3><button onclick="window.location.href='home.jsp'">退出</button></li>
              </ul>
                </div>
                <% }%>
                
                <%if(type==1){ %>
                <h1 class="brand brand_"><a href="UserIndex.jsp"><img alt="" src="img/mine/icon.jpg"> </a></h1>
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse_">Menu <span class="icon-bar"></span> </a>
                <div class="nav-collapse nav-collapse_  collapse">
                  <ul class="nav sf-menu">
                <li class="active"><a href="" onlick="ale()" >用户管理</a></li>
                <li><a href="UserWeatherModify.jsp">历史数据</a></li>
                <li><a href="blog.html">数据分析</a></li>
                <li class="sub-menu"><a >文献资料</a>
                      <ul>
                          <li><a href="UserProcess1.jsp">文档一</a></li>
                          <li><a href="UserProcess2.jsp">文档二</a></li>
                          <li><a href="UserProcess3.jsp">文档三</a></li>
                  </ul>
                    </li>
                <li><a href="contact.html">意见反馈</a></li>
                <%String name=(String)session.getAttribute("name"); %>
                                <li><p3>欢迎，<%=name%></p3><button onclick="window.location.href='home.jsp'">退出</button></li>
              </ul>
                </div>
                <%} %>
          </div>
            </div>
      </div>
        </div>
  </div>
    </header>
<div class="bg-content">  

<!--  content  -->

<div id="content"> 
  <div class="container">
    <div class="row ">
    
<div class="span12">
<div class="block-404">  
      <img class="img-404" src="img/404.jpg" alt="">       
    	<div class="box-404">
        	<h2>Oopss!</h2>
<h3>404 page not found</h3>        	
           
            <p>Nam liber tempor cum soluta nobis eleifend option congue nihil doming id quod mazim placerat facer possim assum orem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy euismod.</p>
           
        	<form id="form-search" action="search.php" method="GET" accept-charset="utf-8" >
            	<div class="clearfix">
                    <input type="text" name="s" onBlur="if(this.value=='') this.value=''" onFocus="if(this.value =='' ) this.value=''" >
                    <a href="#" onClick="document.getElementById('form-search').submit()" class="btn btn-1 ">Search</a>
                </div>
            </form>
		</div>
     </div>
   </div>
  </div>
</div>  
</div>
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
</body>
</html>