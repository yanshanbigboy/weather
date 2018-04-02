<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	errorPage="error.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!--start of  content -->

<jsp:include page="/Header.jsp"></jsp:include>

<!--end of  content -->

<div id="content" class="content-extra">
	<div class="ic"></div>
	<div class="row-1">
		<div class="container">
			<div class="row">
				<article class="span12">
					<h4>产品简介Product Introduction</h4>
					<br>
				</article>
				<div class="clear"></div>
				<h6>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					地面气候统计产品包括1951年以来的中国范围县市级气象站（2400站）和全球范围重点城市8000气象站的本站气压、
					气温、相对湿度、降水量、风向风速、地温、水汽压、日照时数、天气现象等数据。
					其中天气现象为日值数据，包括扬沙、浮尘、露、霜、结冰、霾、雾、大风、雷暴等天气现象及出现时间。<br> <br>
					<h5>数据描述Data Description</h5>
					<h6>1）频次：中国日值、旬值、候值、月值、年值；全球日值、月值</h6>
					<h6>2）空间范围：中国、全球范围</h6>
					<h6>3）更新时次：1951年1月1日至今</h6>
					<h6>4）数据格式：TXT</h6>

					<h5>选择要素Element Selection</h5>
					<form>
						气温 <input type="checkbox" name="avgTemperature"> 气压 <input
							type="checkbox" name="avgPressure">降水量<input
							type="checkbox" name="avgPrecipitation"> 湿度<input
							type="checkbox" name="avgHumidity">风速<input
							type="checkbox" name="avgWindSpeed">
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
					<img src="img/mine/us.jpg " alt="" />
				</figure>
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
					<li><a href="#">Campaigns</a>
					</li>
					<li><a href="#">Portraits</a>
					</li>
					<li><a href="#">Fashion</a>
					</li>
					<li><a href="#">Fine Art</a>
					</li>
				</ul>
				<ul class="list list-pad">
					<li><a href="#">Campaigns</a>
					</li>
					<li><a href="#">Portraits</a>
					</li>
					<li><a href="#">Fashion</a>
					</li>
					<li><a href="#">Fine Art</a>
					</li>
				</ul>
				<ul class="list list-pad">
					<li><a href="#">Campaigns</a>
					</li>
					<li><a href="#">Portraits</a>
					</li>
					<li><a href="#">Fashion</a>
					</li>
					<li><a href="#">Fine Art</a>
					</li>
				</ul>
				<ul class="list">
					<li><a href="#">Advertising</a>
					</li>
					<li><a href="#">Lifestyle</a>
					</li>
					<li><a href="#">Love story</a>
					</li>
					<li><a href="#">Landscapes</a>
					</li>
				</ul>
			</div>
		</article>
	</div>
</div>
</div>
</div>

<!-- footer -->
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