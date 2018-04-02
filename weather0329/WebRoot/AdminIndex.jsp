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
					<h4>Our Work</h4>
				</article>
				<div class="clear"></div>
				<ul class="portfolio clearfix">
					<li class="box"><a href="img/image-blank.png"
						class="magnifier"><img alt="" src="img/mine/work1.jpg">
					</a>
					</li>
					<li class="box"><a href="img/image-blank.png"
						class="magnifier"><img alt="" src="img/mine/work2.jpg">
					</a>
					</li>
					<li class="box"><a href="img/image-blank.png"
						class="magnifier"><img alt="" src="img/mine/work3.jpg">
					</a>
					</li>
					<li class="box"><a href="img/image-blank.png"
						class="magnifier"><img alt="" src="img/mine/work4.jpg">
					</a>
					</li>
					<li class="box"><a href="img/image-blank.png"
						class="magnifier"><img alt="" src="img/mine/graph1.jpg">
					</a>
					</li>
					<li class="box"><a href="img/image-blank.png"
						class="magnifier"><img alt="" src="img/mine/graph2.jpg">
					</a>
					</li>
					<li class="box"><a href="img/image-blank.png"
						class="magnifier"><img alt="" src="img/mine/graph3.jpg">
					</a>
					</li>
					<li class="box"><a href="img/image-blank.png"
						class="magnifier"><img alt="" src="img/mine/graph4.jpg">
					</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="row-2">
		<div class="container">
			<h3>专业高效的气象服务</h3>
			<h3>使用简单，操作方便，结果易于理解，适用于更广泛的人群!</h3>
			<p>数据来源可靠、准确，提供高准度的个性化服务，为您的地区提供更加完善的报告</p>
			<a href="AdminListener.jsp" class="btn btn-1">监听器</a>
		</div>
	</div>
	<div class="row-1">
		<div class="container">
			<div class="row">
				<article class="span12">
					<h4>From blog</h4>
				</article>
				<ul class="thumbnails thumbnails-1">
					<li class="span3">
						<div class="thumbnail thumbnail-1">
							<h3>Web Design</h3>
							<img src="img/mine/graph5.jpg" alt="">
							<section>
								<a href="#"><h3>At vero eos et accusamus et iusto</h3>
								</a>
								<div class="meta">
									<time datetime="2012-11-09" class="date-1">
										<i class="icon-calendar"></i> 9.11.2012
									</time>
									<div class="name-author">
										<i class="icon-user"></i> <a href="#">Admin</a>
									</div>
									<a href="#" class="comments"><i class="icon-comment"></i> 7
										comments</a>
								</div>
								<div class="clear"></div>
								<p>Vivamus sollicitudin libero auctor arcu pulvinar commodo.</p>
								<a href="#" class="btn btn-1">Read More</a>
							</section>
						</div></li>
					<li class="span3">
						<div class="thumbnail thumbnail-1">
							<h3>Graphics</h3>
							<img src="img/mine/graph6.jpg" alt="">
							<section>
								<a href="#"><h3>Deleniti atque corrupti quos</h3>
								</a>
								<div class="meta">
									<time datetime="2012-11-09" class="date-1">
										<i class="icon-calendar"></i> 9.11.2012
									</time>
									<div class="name-author">
										<i class="icon-user"></i> <a href="#">Admin</a>
									</div>
									<a href="#" class="comments"><i class="icon-comment"></i> 4
										comments</a>
								</div>
								<div class="clear"></div>
								<p>Vestibulum volutpat urna sed sapien vehicula varius.</p>
								<a href="#" class="btn btn-1">Read More</a>
							</section>
						</div></li>
					<li class="span3">
						<div class="thumbnail thumbnail-1">
							<h3>Social Media</h3>
							<img src="img/mine/graph7.jpg" alt="">
							<section>
								<a href="#"><h3>Similique sunt in culpa qui officia</h3>
								</a>
								<div class="meta">
									<time datetime="2012-11-09" class="date-1">
										<i class="icon-calendar"></i> 9.11.2012
									</time>
									<div class="name-author">
										<i class="icon-user"></i> <a href="#">Admin</a>
									</div>
									<a href="#" class="comments"><i class="icon-comment"></i> 9
										comments</a>
								</div>
								<div class="clear"></div>
								<p>Pellentesque mi justo, laoreet non bibendum non, auctor
									imperdiet eros.</p>
								<a href="#" class="btn btn-1">Read More</a>
							</section>
						</div></li>
					<li class="span3">
						<div class="thumbnail thumbnail-1">
							<h3 class="title-1 extra">Photography</h3>
							<img src="img/mine/graph8.jpg" alt="">
							<section>
								<a href="#"><h3>Similique sunt in culpa qui officia</h3>
								</a>
								<div class="meta">
									<time datetime="2012-11-09" class="date-1">
										<i class="icon-calendar"></i> 9.11.2012
									</time>
									<div class="name-author">
										<i class="icon-user"></i> <a href="#">Admin</a>
									</div>
									<a href="#" class="comments"><i class="icon-comment"></i> 1
										comment</a>
								</div>
								<div class="clear"></div>
								<p>Vestibulum volutpat urna sed sapien vehicula varius.</p>
								<a href="#" class="btn btn-1">Read More</a>
							</section>
						</div></li>
				</ul>
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