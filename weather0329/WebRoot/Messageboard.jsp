<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<%@ page import="bean.Message"%>
<%@ page import="dao.MessageDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>

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
					<h3>Contact us</h3>
					<div class="inner-1">
						<form action="MessageAdd" method="post">
							<!--   姓名：<input type="text" name="name"></br> -->
							手机号：<input type="text" name="telephone"> </br> E-mail:<input
								type="text" name="email"> </br> 内容：<input type="text"
								name="content"> </br> <input class="cheng" type="submit">Send</input>
						</form>
					</div>
				</article>
				<article class="span4">
					<h3>Contact info</h3>
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
		<div class="row-1">
			<div class="container">
				<div class="row">
					<article class="span12">
						<h4>Our Work</h4>
					</article>
					<div class="clear"></div>
					<ul class="portfolio clearfix">
						<table width="50%" border="1" cellpadding="0" cellspacing="0"
							bordercolor="#FFFFFF" bordercolordark="#F6B83B"
							bordercolorlight="#FFFFFF">
							<tr align="center" bgcolor="#e3F4F7">
								<td width="10%" bgcolor="#e7e8e8">姓名</td>

								<td width="12%" bgcolor="#e7e8e8">留言信息</td>

							</tr>

							<%
								List<Message> messageList = MessageDao.printMessage();
							%>
							<%
								for (Message msg : messageList) {
							%>
							<tr align="center">
								<td style="padding:5px"><%=msg.getName()%></td>
								<td style="padding:5px"><%=msg.getContent()%></td>
								<%
									}
								%>
							</tr>
						</table>
					</ul>
				</div>
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