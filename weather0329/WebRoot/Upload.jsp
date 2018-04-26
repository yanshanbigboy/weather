<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<%@ page import="bean.Province"%>
<%@ page import="dao.ProvinceDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
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
					<h4>文件上传</h4>
					<br>
					</article>
					<div class="clear"></div>
					<div>
						<form
							action="${pageContext.request.contextPath}/UploadHandleServlet"
							enctype="multipart/form-data" method="post">
							上传文件：<input type="file" name="file1"> 文件描述：<input type="text" name="fileMess"><br /> 
							<input type="submit"
								value="提交">
						</form>
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
					<figure class="img-indent">
					<img src="img/mine/us.jpg " alt="" /></figure>
					<div class="inner-1 overflow extra">
						<div class="txt-1">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							我们是致力于通过大数据气象统计和数据分析，来给政府部门、社会组织和市民提供精准有效的气象预测和分析。
							并提供精准的数据查询，方便广大学者和研究人员收集数据进行数据挖掘，同时提供最新的气象研究论文，开放讨论区，
							支持广大气象爱好者进行科研交流。</div>
					</div>
				</article>
				<article class="span6">
                    <h3>友情链接</h3>
					<div class="wrapper">
						<ul class="list list-pad">
							<li><a href="https://500px.com/">500Px</a></li>
							<li><a href="http://echarts.baidu.com/">Echarts</a></li>
							<li><a href="http://www.bootcss.com/">Bootstrap</a></li>
							<li><a href="http://www.hcharts.cn/">Highcharts</a></li>
						</ul>
						<ul class="list list-pad">
							<li><a href="https://git-scm.com/">Git</a></li>
							<li><a href="http://mvnrepository.com/">Maven</a></li>
							<li><a href="https://github.com/">GitHub</a></li>
							<li><a href="http://www.sdufe.edu.cn/">山东财经大学</a></li>
						</ul>
						<ul class="list list-pad">
							<li><a href="ftp://ftp.ncdc.noaa.gov/pub/data/noaa">Data</a>
							</li>
							<li><a href="http://www.cma.gov.cn/">中国气象局</a></li>
							<li><a
								href="https://github.com/yanshanbigboy/weather/tree/master/weather0329">我们的github项目</a>
							</li>
							<li><a
								href="https://cloud.tencent.com/?fromSource=gwzcw.234975.234975.234975">腾讯云</a>
							</li>
						</ul>
						<ul class="list">
							<li><a href="http://www.cnki.net/">中国知网</a></li>
							<li><a href="https://ww2.mathworks.cn/">MATLAB</a></li>
							<li><a href="http://www.mathtype.cn/">MathType</a></li>
							<li><a
								href="https://baike.baidu.com/item/%E5%9B%9E%E5%BD%92%E5%88%86%E6%9E%90/2625498?fr=aladdin">回归分析</a>
							</li>
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