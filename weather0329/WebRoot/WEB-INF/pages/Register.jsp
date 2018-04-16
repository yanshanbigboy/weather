<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>注册</title>
<meta author="liuzhen">
<link rel="stylesheet" type="text/css" href="css/register-login.css">
<script language="javascript" type="text/javascript">
	function checkUserExists() {
		var username = document.getElementById("user").value;
		if ("" == username) {
			var messdiv = document.getElementById("mess");
			messdiv.innerHTML = "用户名不能为空"
			//alert("用户名不能为空");
			return false;
		} else {
			doAjax("CheckUserServlet?username=" + username);
		}
	}
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}
	}
	function doAjax(url) {
		createXMLHttpRequest();
		xmlhttp.onreadystatechange = processRequest;
		xmlhttp.open("GET", url, true);
		xmlhttp.send(null);
	}
	function processRequest() {
		var messdiv = document.getElementById("mess");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			if (xmlhttp.responseText == "false") {
				messdiv.innerHTML = "用户名可以使用";
			} else {
				messdiv.innerHTML = "用户名已被使用";

			}
		}

	}
</script>

</head>
<body>
	<div id="box"></div>
	<div class="cent-box register-box">
		<div class="cent-box-header">
			<h1 class="main-title hide">Weather Forecast</h1>
			<h2 class="sub-title">你与预知未来，只有一个网站的距离</h2>
		</div>

		<div class="cont-main clearfix">
			<div class="index-tab">
				<div class="index-slide-nav">
					<a href="login.ui">登录</a> <a href="UserEnroll.jsp" class="active">注册</a>
					<div class="slide-bar slide-bar1"></div>
				</div>
			</div>
			<form action="UserEnroll" method="post">
				<div class="login form">
					<div class="group">

						<div class="group-ipt user">
							<input type="text" name="userName" id="user" class="ipt"
								onblur="checkUserExists()" placeholder="输入一个用户名" required>
							<div id="mess" style="display:inline"></div>
						</div>
						<div class="group-ipt password">
							<input type="password" name="userPassword" id="password"
								class="ipt" placeholder="设置登录密码" required>
						</div>

					</div>
				</div>

				<div class="button">
					<button type="submit" class="login-btn register-btn" id="button">注册</button>
				</div>
		</div>
		</form>
	</div>

	<div class="footer">
		<p>Weather Forecast</p>
	</div>

	<script src='js/particles.js' type="text/javascript"></script>
	<script src='js/background.js' type="text/javascript"></script>
	<script src='js/jquery.min.js' type="text/javascript"></script>
	<script src='js/layer.js' type="text/javascript"></script>
	<!-- 
 <script>
    $('.imgcode').hover(function(){
        layer.tips("看不清？点击更换", '.verify', {
            time: 6000,
            tips: [2, "#3c3c3c"]
        })
    },function(){
        layer.closeAll('tips');
    }).click(function(){
        $(this).attr('src','http://zrong.me/home/index/imgcode?id=' + Math.random());
    })

    $(".login-btn").click(function(){
        var email = $("#email").val();
        var password = $("#password").val();
        var verify = $("#verify").val();
    })
    $("#remember-me").click(function(){
        var n = document.getElementById("remember-me").checked;
        if(n){
            $(".zt").show();
        }else{
            $(".zt").hide();
        }
    })
</script>
 -->
</body>
</html>