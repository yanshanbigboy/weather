<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	errorPage="error.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!--start of  content -->

<jsp:include page="/pattern/Header.jsp"></jsp:include>

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
				<h6 style="color:red;font-size:15px">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					地面气候统计产品包括最近10年以来的中国范围县市级气象站（2400站）本站气压、
					气温、相对湿度、降水量、风向风速、地温、水汽压、日照时数、天气现象等数据。 <br> <br>
					<h5>数据描述Data Description</h5>
					<h6 style="color:red;font-size:15px">1）频次：中国月值、年值</p3>
					<h6 style="color:red;font-size:15px">2）空间范围：中国范围</h6>
					<h6 style="color:red;font-size:15px">3）更新时次：2007年至今</h6>
					<h6 style="color:red;font-size:15px">4）数据格式：.xls</h6>
					<br> <br>

					<h5>选择要素* Element Selection</h5>
					${ShoppingItem.errors["elem"]}
					<form action="DataShopping" method="post">
						气温 <input type="checkbox" name="elements" value="avgTemperature">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 气压 <input type="checkbox"
							name="elements" value="avgPressure">&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 降水量<input type="checkbox" name="elements"
							value="avgPrecipitation"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;湿度<input type="checkbox" name="elements"
							value="avgHumidity">&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;风速<input type="checkbox" name="elements"
							value="avgWindSpeed"> <br> <br>
						<h5>选择地区* Area Selection</h5>
						${ShoppingItem.errors["area"]}<br> 北京 <input type="checkbox"
							name="area" value="beijing"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;天津 <input type="checkbox" name="area"
							value="tianjin"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;河北
						<input type="checkbox" name="area" value="hebei">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;山西 <input type="checkbox"
							name="area" value="shanxi"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 内蒙古<input type="checkbox" name="area"
							value="neimenggu"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						辽宁<input type="checkbox" name="area" value="liaoning">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 吉林<input type="checkbox"
							name="area" value="jilin"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 黑龙江<input type="checkbox" name="area"
							value="heilongjiang"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 上海<input type="checkbox" name="area"
							value="shanghai"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						江苏<input type="checkbox" name="area" value="jiangsu">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 浙江<input type="checkbox"
							name="area" value="zhejiang"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 安徽<input type="checkbox" name="area"
							value="anhui"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 福建<input
							type="checkbox" name="area" value="fujian">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 江西<input type="checkbox"
							name="area" value="jiangxi"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 山东<input type="checkbox" name="area"
							value="shandong"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						河南<input type="checkbox" name="area" value="henan">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 湖北<input type="checkbox"
							name="area" value="hubei"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 湖南<input type="checkbox" name="area"
							value="hunan"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 广东<input
							type="checkbox" name="area" value="guangdong">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 广西<input type="checkbox"
							name="area" value="guangxi"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 海南<input type="checkbox" name="area"
							value="hainan"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 重庆<input
							type="checkbox" name="area" value="chongqing">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 四川<input type="checkbox"
							name="area" value="sichuan"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 贵州<input type="checkbox" name="area"
							value="guizhou"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 云南<input
							type="checkbox" name="area" value="yunnan">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 西藏<input type="checkbox"
							name="area" value="xizang"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 陕西<input type="checkbox" name="area"
							value="shanxixi"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						甘肃<input type="checkbox" name="area" value="gansu">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 青海<input type="checkbox"
							name="area" value="qinghai"> &nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; 宁夏<input type="checkbox" name="area"
							value="ningxia"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 新疆<input
							type="checkbox" name="area" value="xinjiang">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <br> <br>
						<h5>选择频次 *Frequency Selection</h5>
						${ShoppingItem.errors["frequency"]}<br> 逐月 <input
							type="checkbox" name="frequency" value="eachMonth"> 逐年 <input
							type="checkbox" name="frequency" value="eachYear"> <br>
						<br>

						<h5>请填写您的个人信息，我们将进一步与您沟通</h5>
						姓名*： <input type="text" name="name">${ShoppingItem.errors["name"]}
						<br> 单位*： <input type="text" name="company">${ShoppingItem.errors["company"]}
						<br> 联系电话*： <input type="text" name="phone">${ShoppingItem.errors["phoneNum"]}
						<br> 邮箱*： <input type="text" name="email">${ShoppingItem.errors["email"]}
						<br> 其他需求： <input type="text"
							style="width:280px;height:150px;" name="other">${ShoppingItem.errors["addRequest"]}
						<br> <input type="submit" style="width:280px;" value="提交">
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

<!--start of footer  -->
<jsp:include page="/pattern/Footer.jsp"></jsp:include>
<!--end of footer  -->

<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>