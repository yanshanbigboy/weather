<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<%@ page import="bean.Province"%>
<%@ page import="dao.ProvinceDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- start of header -->
<jsp:include page="/pattern/Header.jsp"></jsp:include>
<!-- end of header -->
<script language=javascript>
function onlyNum()
{
if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
//考虑小键盘上的数字键
event.returnvalue=false;
}
function isNumber(){
 isNum = /^[0-9]*$/;
 alert(isNum.test(Form1.InputBox.value));
}
</script>
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
					<h4>Our Work</h4>
					</article>
					<div class="clear"></div>
					<ul class="portfolio clearfix">
						<table width="50%" border="1" cellpadding="0" cellspacing="0"
							bordercolor="#FFFFFF" bordercolordark="#F6B83B"
							bordercolorlight="#FFFFFF">
							<tr align="center" bgcolor="#e3F4F7">
								<td width="10%" bgcolor="#e7e8e8">省份</td>

								<td width="12%" bgcolor="#e7e8e8">人口(万人)</td>

							</tr>
							<%
								List<Province> provincesList = ProvinceDao.printProvince();
							%>
							<%
								for (Province province : provincesList) {
							%>
							<tr align="center">
								<td style="padding:5px;"><%=province.getProvinceName()%></td>
								<td style="padding:5px;"><%=province.getPopulation()%></a></td>
							</tr>
							<%
								}
							%>
						</table>
						<c:choose>
						  <c:when test="${sessionScope.admin!=null }">
						     <form action="query.weather" method="post">
							     <h3>数据查询：请输入要查询的省份</h3>
							     <input type="text" name="provinceName"  onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"  value="请输入中文" onfocus="if(this.value == '请输入中文') this.value = ''" onblur="if(this.value =='') this.value = '请输入中文'"></br>
							      <input type="Submit" value="确定">
						     </form>
						  </c:when>
						  <c:otherwise>  
						     <form action="query2.weather" method="post">
							     <h3>数据查询：请输入要查询的省份</h3>
							     <input type="text" name="provinceName" onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"  value="请输入中文" onfocus="if(this.value == '请输入中文') this.value = ''" onblur="if(this.value =='') this.value = '请输入中文'"></br> <input
								type="Submit" value="确定">
						     </form>
						  </c:otherwise>
						</c:choose>
						<c:if test="${sessionScope.admin!=null }">
							<h3>========================</h3>
							<br>
							<form action="add.province" method="post">
								<h3>增加省份：请输入要添加的省份</h3>
								省份：<input type="text" name="provinceName"  onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"  value="请输入中文" onfocus="if(this.value == '请输入中文') this.value = ''" onblur="if(this.value =='') this.value = '请输入中文'"></br> 人口（万人）：<input
									type="text" name="population" onkeyup="value=value.replace(/[^\d\.]/g,'')"
       value="请输入数字" onfocus="if(this.value == '请输入数字') this.value = ''" onblur="if(this.value =='') this.value = '请输入数字'"></br> <input type="Submit"
									value="确定">
							</form>
							<h3>========================</h3>
							<br>
							<form action="del.province" method="post">
								<h3>请输入要删除的省份</h3>
								<input type="text" name="provinceName"  onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"  value="请输入中文" onfocus="if(this.value == '请输入中文') this.value = ''" onblur="if(this.value =='') this.value = '请输入中文'"></br> <input
									type="Submit" value="确定">
							</form>
							<h3>========================</h3>
							<br>
							<form action="add.weather" method="post">
								<h3>添加省份天气数据</h3>
								月份：<input type="text" name="month" onkeyup="value=value.replace(/[^\d\.]/g,'')"
       value="请输入数字" onfocus="if(this.value == '请输入数字') this.value = ''" onblur="if(this.value =='') this.value = '请输入数字'"><br> 省份：<input
									type="text" name="province"  onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"  value="请输入中文" onfocus="if(this.value == '请输入中文') this.value = ''" onblur="if(this.value =='') this.value = '请输入中文'"><br> 平均气压（单位百帕）：<input
									type="text" name="avgPressure" onkeyup="value=value.replace(/[^\d\.]/g,'')"
       value="请输入数字" onfocus="if(this.value == '请输入数字') this.value = ''" onblur="if(this.value =='') this.value = '请输入数字'"><br> 平均气温（单位℃）：<input
									type="text" name="avgTemperature" onkeyup="value=value.replace(/[^\d\.]/g,'')"
       value="请输入数字" onfocus="if(this.value == '请输入数字') this.value = ''" onblur="if(this.value =='') this.value = '请输入数字'"><br> 平均湿度（单位%）：<input
									type="text" name="avgHumidity" onkeyup="value=value.replace(/[^\d\.]/g,'')"
       value="请输入数字" onfocus="if(this.value == '请输入数字') this.value = ''" onblur="if(this.value =='') this.value = '请输入数字'"><br> 平均降水量（单位mm）：<input
									type="text" name="avgPrecipitation" onkeyup="value=value.replace(/[^\d\.]/g,'')"
       value="请输入数字" onfocus="if(this.value == '请输入数字') this.value = ''" onblur="if(this.value =='') this.value = '请输入数字'"><br>
								平均风速（单位m/s）：<input type="text" name="avgWindSpeed" onkeyup="value=value.replace(/[^\d\.]/g,'')"
       value="请输入数字" onfocus="if(this.value == '请输入数字') this.value = ''" onblur="if(this.value =='') this.value = '请输入数字'"><br>
								<input type="Submit" value="确定">
							</form>
							<h3>========================</h3>
							<br>
							<form action="del.weather" method="post">
								<h3>天气数据删除：请输入省份和要删除数据的月份</h3>
								省份：<input type="text" name="provinceName"  onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"  value="请输入中文" onfocus="if(this.value == '请输入中文') this.value = ''" onblur="if(this.value =='') this.value = '请输入中文'"><br> 月份：<input
									type="text" name="month"  onkeyup="value=value.replace(/[^\d\.]/g,'')"
       value="请输入数字" onfocus="if(this.value == '请输入数字') this.value = ''" onblur="if(this.value =='') this.value = '请输入数字'"><br> <input type="Submit"
									value="确定">
							</form>
							</br>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		<div class="row-2">
			<div class="container">
				<h3>专业高效的气象服务</h3>
				<h3>使用简单，操作方便，结果易于理解，适用于更广泛的人群!</h3>
				<p>数据来源可靠、准确，提供高准度的个性化服务，为您的地区提供更加完善的报告</p>
				<a href="#" class="btn btn-1">了解更多</a>
			</div>
		</div>
		<div class="row-1">
				<div class="container">
					<div class="row">
						<article class="span12">
						<h4>网站简介</h4>
						</article>
						<ul class="thumbnails thumbnails-1">
							<li class="span3">
								<div class="thumbnail thumbnail-1">
									<h3>Web Design</h3>
									<img src="img/mine/graph5.jpg" alt="">
									<section> <a href="#"><h3>前端使用bootstrap框架
									http://www.bootcss.com/</h3> </a>
									<div class="meta">
										<time datetime="2018-04-17" class="date-1"> <i
											class="icon-calendar"></i> 17.04.2018</time>
										<div class="name-author">
											<i class="icon-user"></i> <a href="#">Admin</a>
										</div>
										<a href="Messageboard.jsp" class="comments"><i
											class="icon-comment"></i> 7 comments</a>
									</div>
									
									<div class="clear"></div>
									<p>设计者：刘震，邢尧，张博文</p>
									<a href="http://www.bootcss.com/" class="btn btn-1">Read
										more</a> </section>
								</div>
							</li>
							<li class="span3">
								<div class="thumbnail thumbnail-1">
									<h3>Graphics</h3>
									<img src="img/mine/graph6.jpg" alt="">
									<section> <a href="#"><h3>图片来源于500px网站
									https://500px.com/</h3> </a>
									<div class="meta">
										<time datetime="2018-04-17" class="date-1"> <i
											class="icon-calendar"></i> 17.04.2018</time>
										<div class="name-author">
											<i class="icon-user"></i> <a href="#">Admin</a>
										</div>
										<a href="Messageboard.jsp" class="comments"><i
											class="icon-comment"></i> 4 comments</a>
									</div>
									<div class="clear"></div>
									<p>表格创意来源于echarts插件</p>
									<a href="http://echarts.baidu.com/" class="btn btn-1">Read
										More</a> </section>
								</div>
							</li>
							<li class="span3">
								<div class="thumbnail thumbnail-1">
									<h3>Social Media</h3>
									<img src="img/mine/graph7.jpg" alt="">
									<section> <a href="#"><h3>项目Github：https://github.com/yanshanbigboy/weather</h3>
									</a>
									<div class="meta">
										<time datetime="2018-04-17" class="date-1"> <i
											class="icon-calendar"></i> 17.04.2018</time>
										<div class="name-author">
											<i class="icon-user"></i> <a href="#">Admin</a>
										</div>
										<a href="Messageboard.jsp" class="comments"><i
											class="icon-comment"></i> 9 comments</a>
									</div>
									<div class="clear"></div>
									<p>网站已发布，项目也已开源到Github网站</p>
									<a href="https://github.com/yanshanbigboy/weather"
										class="btn btn-1">Read More</a> </section>
								</div>
							</li>
							<li class="span3">
								<div class="thumbnail thumbnail-1">
									<h3 class="title-1 extra">Research Data</h3>
									<img src="img/mine/graph8.jpg" alt="">
									<section> <a href="#"><h3>数据主要来源于美国国家海洋和大气管理局和中国气象局</h3>
									</a>
									<div class="meta">
										<time datetime="2018-04-17" class="date-1"> <i
											class="icon-calendar"></i> 17.04.2018</time>
										<div class="name-author">
											<i class="icon-user"></i> <a href="#">Admin</a>
										</div>
										<a href="Messageboard.jsp" class="comments"><i
											class="icon-comment"></i> 1 comment</a>
									</div>
									<div class="clear"></div>
									<p>Noaa气象数据下载，详见Read more</p>
									<a href="ftp://ftp.ncdc.noaa.gov/pub/data/noaa"
										class="btn btn-1">Read More</a> </section>
								</div>
							</li>
						</ul>
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