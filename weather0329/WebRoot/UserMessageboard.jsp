<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="error.jsp"%>
<%@ page import="bean.Message"%>
<%@ page import="dao.MessageDao"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Codester | Contact</title>
    <meta charset="utf-8">
    <link rel="icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon">
    <link rel="shortcut icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon" />
    <meta name="description" content="Codester is a free responsive Bootstrap template by Dzyngiri">
    <meta name="keywords" content="free, template, bootstrap, responsive">
    <meta name="author" content="Inbetwin Networks">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/my.css" type="text/css" media="screen">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/superfish.js"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script src="js/forms.js"></script>
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
<!-- header -->
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
                                <li><a href="UserHadoop.jsp">数据分析</a></li>
                                <li class="sub-menu"  class="active"><a>文献资料</a>
                                    <ul>
                                        <li><a href="UserUpLoad.jsp">文件上传</a></li>
                                        <li><a href="servlet/ListFileServlet">文件下载</a></li>
                                        <li><a href="UserProcess3.jsp">可读文档</a></li>
                                    </ul>
                                </li>
                                <li><a href="UserMessboard.jsp">意见反馈</a></li>
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
    <!-- content -->
    <div id="content"><div class="ic"></div>
        <div class="container">
            <div class="row">
                <article class="span8">
                    <h3>Contact us</h3>
                    <div class="inner-1">
                        <form  action="MessageAdd" method="post">
                               <!--   姓名：<input type="text" name="name"></br> -->         
                                                                                                               手机号：<input type="text" name="telephone">   </br>                                           
                                E-mail:<input type="text" name="email">    </br>                                                                                                           
                                                                                                               内容：<input type="text" name="content">   </br>                                                                                                
                                <input class="cheng" type="submit">Send</input>
                        </form>
                    </div>
                </article>
                <article class="span4">
                    <h3>Contact info</h3>
                    <div class="map">
                        <a href="http://dribbble.com/shots/624850-Presentaion-image-1" target="_blank"><img src="img/map.jpg" alt="Location on Map" /></a>
                    </div>
                    <address class="address-1">
                        <strong>China,<br>
                            ShanDong Province,<br>
                            ShanDong University of Finance and Economy</strong>
                        <div class="overflow"> <span>Mobile:</span>17862927407<br>
                            <span>Telephone:</span>17862927361<br>
                            <span>QQ:</span>416034116 <br>
                            <span>E-mail:</span> <a href="#" class="mail-1">4160@qq.com</a><br>
                            <span>Wechat:</span> <a href="#" class="mail-1">liuzhen0704</a></div>
                    </address>
                </article>
            </div>
        </div>
        <div class="row-1">
            <div class="container">
                <div class="row">
                    <article class="span12">
                        <h4>Our Work</h4>
                    </article>
                    <div class="clear"></div>
                    <ul class="portfolio clearfix">
                        <table width="50%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
                            <tr align="center" bgcolor="#e3F4F7">
                                <td width="10%" bgcolor="#e7e8e8">姓名</td>

                                <td width="12%" bgcolor="#e7e8e8">留言信息</td>

                            </tr>
                            
                            <%List<Message>  messageList=MessageDao.printMessage();%>
                            <% for(Message msg:messageList){ %>
                            <tr align="center">
                            <td style="padding:5px"><%= msg.getName() %> </td>
                            <td style="padding:5px"><%= msg.getContent()%> </td>
                            <%} %>
                            </tr>
                        </table>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- footer -->
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