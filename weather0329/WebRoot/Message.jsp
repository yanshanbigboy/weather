<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String message = (String) request.getAttribute("message");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全局消息显示页面</title>
</head>
<body>
	<!-- start of content -->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- end of content -->

	<h3><%=message%></h3>

		<!--  footer  -->
		<footer>
		<div class="container clearfix">
			<ul class="list-social pull-right">
				<li><a class="icon-1" href="#"></a>
				</li>
				<li><a class="icon-2" href="#"></a>
				</li>
				<li><a class="icon-3" href="#"></a>
				</li>
				<li><a class="icon-4" href="#"></a>
				</li>
			</ul>
			<div class="privacy pull-left">
				&copy; 2017 | <a href="http://www.google.com">Title : Online
					Weather Forecast</a> | <a href="http://twitter.github.com/bootstrap/"
					target="_blank">Bootstrap</a> | Demo Illustrations by <a
					href="http://www.sdufe.edu.cn" target="_blank">Liuzhen Xingyao</a>
			</div>
		</div>
		</footer>
		<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>


