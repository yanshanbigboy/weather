<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.Province"%>
<%@ page import="dao.ProvinceDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="dao.FileDao"%>
<%@ page import="bean.file" import="java.io.File"
	import="java.io.IOException" import="java.util.HashMap"
	import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- start of header -->
<jsp:include page="/pattern/Header.jsp"></jsp:include>
<!-- end of header -->

<div class="bg-content">

	<!-- content -->

	<div id="content" class="content-extra">
		<div class="ic"></div>
		<div class="row-1">
			<div class="container">
				<div class="row">
					<article class="span12">
					<h4>文件下载</h4>
					<br>
					</article>
					<div class="clear"></div>
					<div>
						<%
							if (request.getAttribute("fileList") == null) {
						%>
						<p4>对不起，系统没有文件</p4>
						<%
							} else
						%>
						<%
							if (request.getAttribute("fileList") != null) {
						%>
						<table width="50%" border="1" cellpadding="0" cellspacing="0"
							bordercolor="#FFFFFF" bordercolordark="#F6B83B"
							bordercolorlight="#FFFFFF">
							<tr align="center" bgcolor="#e3F4F7">
								<td width="10%" bgcolor="#e7e8e8">文件</td>
								<td width="10%" bgcolor="#e7e8e8">描述</td>
								<td width="10%" bgcolor="#e7e8e8">大小（单位：MB）</td>
							</tr>

							<!-- 遍历Map集合 -->
							<c:forEach var="me" items="${fileList}">
								<!-- me当前条目变量名称  item循环的信息-->
								<tr align="center" bgcolor="#F5F5DC">
									<td style="padding:5px;"><c:url value="/DownLoadServlet"
											var="downurl">
											<c:param name="filename" value="${me.fileName} "></c:param>
										</c:url> ${me.realFileName} <a href="${downurl}">下载</a> <%-- <c:url value="/DownLoadServlet" var="downurl"> <!-- value.url var.url名 -->
								        <c:param name="filename" value="${me.key}"></c:param>
							        </c:url>                            <!-- key：带有乱码的名字（唯一的） -->             
                                    ${me.value}    <a href="${downurl}">下载</a> --%>
										<!-- value不带乱码的名字（可能不唯一） --></td>
									<td style="padding:5px;">${me.fileMess}</td>
									<td style="padding:5px;">
									<fmt:formatNumber type="number" value="${me.fileSize}" pattern="0.00" maxFractionDigits="2"/>
									</td>
									<%-- <td style="padding:5px;">${me.fileSize}</td> --%>
								</tr>

							</c:forEach>
						</table>
						<%
							}
						%>
					</div>
					<!--正文结束-->
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<article class="span6">
				<h3>Shortly about us</h3>
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
				<h3>Some quick links</h3>
				<div class="wrapper">
					<ul class="list list-pad">
						<li><a href="#">Campaigns</a></li>
						<li><a href="#">Portraits</a></li>
						<li><a href="#">Fashion</a></li>
						<li><a href="#">Fine Art</a></li>
					</ul>
					<ul class="list list-pad">
						<li><a href="#">Campaigns</a></li>
						<li><a href="#">Portraits</a></li>
						<li><a href="#">Fashion</a></li>
						<li><a href="#">Fine Art</a></li>
					</ul>
					<ul class="list list-pad">
						<li><a href="#">Campaigns</a></li>
						<li><a href="#">Portraits</a></li>
						<li><a href="#">Fashion</a></li>
						<li><a href="#">Fine Art</a></li>
					</ul>
					<ul class="list">
						<li><a href="#">Advertising</a></li>
						<li><a href="#">Lifestyle</a></li>
						<li><a href="#">Love story</a></li>
						<li><a href="#">Landscapes</a></li>
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