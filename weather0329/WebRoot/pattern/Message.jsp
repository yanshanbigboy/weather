<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String message = (String) request.getAttribute("message");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- start of header -->
<jsp:include page="/pattern/Header.jsp"></jsp:include>
<!-- end of header -->

<div class="bg-content">
	<!-- content -->
	<div id="content">
		<div class="ic"></div>
		<div class="container">
			<div class="row">
				<article class="span8">

				<div style="padding:80px 0; margin:30px;">
					<h3 ><%=message%></h3>
				</div>

				<div class="inner-1"></div>

				</article>

				<article class="span4">

				<div class="map">
					<a href="http://dribbble.com/shots/624850-Presentaion-image-1"
						target="_blank"><img src="img/map.jpg" alt="Location on Map" />
					</a>
				</div>
				<address class="address-1">
					<strong>China,<br> ShanDong Province,<br>
						ShanDong University of Finance and Economy</strong>
					<div class="overflow">
						<span>Mobile:</span>17862927407<br> <span>Telephone:</span>17862927361<br>
						<span>QQ:</span>416034116 <br> <span>E-mail:</span> <a
							href="#" class="mail-1">4160@qq.com</a><br> <span>Wechat:</span>
						<a href="#" class="mail-1">liuzhen0704</a>
					</div>
				</address>
				</article>
			</div>
		</div>

		<!-- start of  footer  -->
		<jsp:include page="/pattern/Footer.jsp"></jsp:include>
		<!-- end of  footer  -->

		<script type="text/javascript" src="js/bootstrap.js"></script>
		</body>
		</html>