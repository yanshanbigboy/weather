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
	<jsp:include page="/pattern/Header.jsp"></jsp:include>
	<!-- end of content -->

	<h3><%=message%></h3>

	<!-- start of  footer  -->
	<jsp:include page="/pattern/Footer.jsp"></jsp:include>
	<!-- end of  footer  -->
	
	 <script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>


