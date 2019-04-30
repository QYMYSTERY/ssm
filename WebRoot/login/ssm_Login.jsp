<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>女院便捷打印服务系统_登录</title>
    <link rel="stylesheet" type="text/css" href="../css/ssm_Login.css">
  </head>
  
  <body>
    <div id="wrapper">
    	<header role="banner">
    		<h1>女院便捷打印服务系统</h1>
    		<div id="logo">
    			<img src="../image/login/logo.png" width="90" height="90"/>
    		</div>
    		<div id="word">
    			<img src="../image/login/logo_word.png" width="300" height="110"/>
    		</div>
    		<a href="#">
	    		<div class="QR_code">
	    			<img src="../image/login/QR_code.png" width="60" height="40"/><b>扫一扫</b>
	    		</div>
    		</a>
    	</header>
    	
    	<main role="main">
    		<div id="did" onmouseover="doStop()" onmouseout="doStart()">
   				<img src="../image/login/01.jpg" width="100%" height="400" id="m1"/>
			    <img src="../image/login/02.jpg" width="100%" height="400" id="m2"/>
			    <img src="../image/login/03.jpg" width="100%" height="400" id="m3"/>
			    <img src="../image/login/04.jpg" width="100%" height="400" id="m4"/>
			    <img src="../image/login/05.jpg" width="100%" height="400" id="m5"/>
			    <img src="../image/login/06.jpg" width="100%" height="400" id="m6"/>
 			</div>
    	</main>
    	
    	<aside role="complementary">
    		<div class="User_Login">
    			<div>
    				<div class="pwdlogin">
    					<img src="../image/login/pwdlogin.png" width="120" height="50" class="txUsername"/>
    					<pre class="error"><b>${errorMap.accounterror}${errorMap.passworderror}${errorMap.error}</b></pre>
    				</div>
    			</div>
    			
    			<form action="<c:url value='/login/ssm_Login'/>" method="post">
				    <div class="username">
				    	<img src="../image/login/username.png" width="18" height="18" class="txUsername"/>
						<input type="text" name="accountnumber" placeholder="帐号|手机号" class="inputUsername" value="${param.accountnumber}"/>
				    </div>
				    <div class="userpwd">
				    	<img src="../image/login/userpwd.png" width="18" height="18" class="txPwd"/>
						<input type="password" name="password" placeholder="密码（6位~12位）" class="inputPwd"/>
				    </div>
				    <div class="loginRegister">
				    	<input type="submit" name="userLogin" value="登录" class="login"/>
						<pre class="register"><a href="<c:url value='/login/userRegister'/>">去注册</a></pre>
				    </div>
	    		</form>
    		</div>
    	</aside>
    	
    	<footer role="contentinfo">
    	
    	</footer>
    </div>
  </body>
</html>

<script>
  var m = 0;
  var time = null;

  function doStart(){
    if(time == null){
      time = setInterval(function(){
        m++;
        show(m);
        if(m >=6){
          m = 0;
        }
      },3000)
    }
    
  }

  doStart();

  function doStop(){
    if(time != null){
      clearInterval(time);
    }
    time = null;
  }

  function show(x){
    for(var i=1;i<=6;i++){
      var img = document.getElementById("m"+i);
      if(i == x){
        img.style.display = "block";
      }else{
        img.style.display = "none";
      }
    }
  }
</script>
