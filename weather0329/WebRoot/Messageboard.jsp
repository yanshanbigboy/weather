<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="bean.Message"%>
<%@ page import="dao.MessageDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<form action="add.message" method="post">
							内容：<input type="text" name="content"> </br> <input
								class="cheng" type="submit">Send</input>
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
								<td width="10%" bgcolor="#e7e8e8">留言序号</td>
								<td width="10%" bgcolor="#e7e8e8">姓名</td>
								<td width="18%" bgcolor="#e7e8e8">留言信息</td>
								<td width="18%" bgcolor="#e7e8e8">回复</td>
								<td width="18%" bgcolor="#e7e8e8">添加回复</td>
							</tr>

							<c:forEach var="message" items="${messageList }">
								<tr align="center">
									<td style="padding:5px">${message.sendId }</td>
									<td style="padding:5px">${message.sendName }</td>
									<td style="padding:5px">${message.sendContent }</td>
									<td style="padding:5px">${message.allReply }</td>
									<td style="padding:5px"><form action="addreply.message">
											<input type="text" name="reply_Content"> <input
												type="hidden" name="send_id" value="${message.sendId }"><input
												type="submit" value="添加">
										</form></td>
								</tr>
							</c:forEach>
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