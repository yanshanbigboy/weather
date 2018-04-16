<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<script>
function check(){
if(login.name.value==""){
    
    login.name.focus();
    return;
}else if(login.password.value==""){
    alert("密码不能为空");
    login.name.focus();
    return;
}else if(login.validationCode.value==""){
    alert("验证码不能为空");
    login.name.focus();
    return;
}else{
login.submit();
}
}
var xmlhttp;
function checkUserExists(){
    /* var username=document.getElementById("username").value;
    if(username==""){
        alert("用户名不能为空");
        return false;
    } */
        var messdiv=document.getElementById("mess");
    if( $("#username").val() == ""){
        messdiv.innerHTML="用户名不能为空" 
        //alert("用户名为空！");
        return false;
    }else{
        //doAjax("CheckUserServlet?username="+username);
        messdiv.innerHTML="✔"
    }
}
function createXMLHttpRequest(){
    if(window.ActiveXObject){
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
}
function doAjax(url){
     createXMLHttpRequest();
     xmlhttp.onreadystatechange=processRequest;
     xmlhttp.open("GET",url,true);
     xmlhttp.send(null);
}

</script>
<head>
    <meta charset="utf-8">
    <meta author="liuzhen">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/register-login.css">
</head>
<body>
<div id="box"></div>
<div class="cent-box">
    <div class="cent-box-header">
        <h1 class="main-title hide">Weather Forecast</h1>
        <h2 class="sub-title">你与预知未来，只有一个网站的距离</h2>
    </div>

    <div class="cont-main clearfix">
        <div class="index-tab">
            <div class="index-slide-nav">
                <a href="login.ui" class="active">登录</a>
                <a href="registe.ui">注册</a>
                <div class="slide-bar"></div>
            </div>
        </div>
     <form action="Login" method="post" name="login">
        <div class="login form">
            <div class="group">
                <div class="group-ipt user">
                    <input type="text" name="name" id="username" class="ipt" placeholder="输入一个用户名"  onblur="checkUserExists()" required>
                    <div id="mess" style="display:inline"></div>
                </div>
                <div class="group-ipt password">
                    <input type="password" name="password" id="password" class="ipt" placeholder="输入您的登录密码" required>
                </div>
                <div class="group-ipt verify">
                    <input type="text" name="validationCode" id="verify" class="ipt" placeholder="输入验证码" required>
                    <img src="ValidateCode" class="imgcode" onclick="this.src=this.src+'?'">
                </div>
                <div class="group-ipt role">
                    <select name="enrolleeType">
                        <option value="admin">管理员</option>
                        <option value="user" selected = "selected">普通用户</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="button">
            <button type="button" class="login-btn register-btn" id="button" onClick="check()">登录</button>
        </div>

     </form>
       <!-- 
        <div class="remember clearfix">
            <label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox" name="remember-me" id="remember-me" class="remember-mecheck" checked>记住我</label>
            <label class="forgot-password">
                <a href="#">忘记密码？</a>
            </label>
        </div>
        -->
    </div>
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
    });
    $("#remember-me").click(function(){
        var n = document.getElementById("remember-me").checked;
        if(n){
            $(".zt").show();
        }else{
            $(".zt").hide();
        }
    });
</script>
 -->
</body>
</html>