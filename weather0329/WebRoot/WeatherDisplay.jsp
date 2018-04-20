
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- start of header -->
<jsp:include page="/pattern/Header.jsp"></jsp:include>
<!-- end of header -->

<div class="bg-content">
	<div class="container">
		<div class="row">
			<div class="span12">

				<!--start of slider-->
				<jsp:include page="/pattern/Slider.jsp"></jsp:include>
				<!--end of slider-->

				<span id="responsiveFlag"></span>

			</div>
		</div>
	</div>

	<!-- content -->

	<div id="content" class="content-extra">
		<div class="ic"></div>
		<div class="row-1">
			<div class="container">
				<div class="row">
					<article class="span12">
					<h4>数据展示</h4>
					<c:if test="${sessionScope.admin==null&&sessionScope.user!=null }">
						<h6>
							普通用户只能查看前六个月信息，您可以选择购买数据，来获得完整数据 <input type="button"
								onclick="location.href='ShoppingView.jsp'" value="现在购买"></input>
						</h6>
					</c:if> </article>
					<div class="clear"></div>
					<ul class="portfolio clearfix">
						<table width="90%" border="1" cellpadding="0" cellspacing="0"
							bordercolor="#FFFFFF" bordercolordark="#F6B83B"
							bordercolorlight="#FFFFFF">
							<tr align="center" bgcolor="#e3F4F7">
								<td width="12%" bgcolor="#e7e8e8">省份</td>
								<td width="10%" bgcolor="#e7e8e8">月序</td>
								<td width="12%" bgcolor="#e7e8e8">累年月平均气压（百帕）</td>
								<td width="12%" bgcolor="#e7e8e8">累年月平均气温（摄氏度）</td>
								<td width="12%" bgcolor="#e7e8e8">累年月平均相对湿度（%）</td>
								<td width="12%" bgcolor="#e7e8e8">累年月平均降水量（毫米）</td>
								<td width="12%" bgcolor="#e7e8e8">累年月平均风速（米/秒）</td>

							</tr>
							<c:forEach var="weather" items="${weatherList }">
							<tr align="center">
								<td style="padding:5px;">${weather.province }</td>
								<td style="padding:5px;">${weather.month }</td>
								<td style="padding:5px;">${weather.avgPressure }</td>
								<td style="padding:5px;">${weather.avgTemperature }</td>
								<td style="padding:5px;">${weather.avgHumidity }</td>
								<td style="padding:5px;">${weather.avgPrecipitation }</td>
								<td style="padding:5px;">${weather.avgWindSpeed }</td>
							</tr>
							</c:forEach>
							</ul>
							</div>
							</div>
							</div>


							<script type="text/javascript" src="js/bootstrap.js"></script>
							</body>
							</html>