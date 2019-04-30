<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人中心-女院便捷打印服务系统</title>
    <style>
        body,
        html {
            width: 100%;
            height: 100%;
            overflow: hidden;
        }
    </style>
  </head>
  
  <body>
    <div class="container-fluid" style="min-width: 1200px; height: 100%;">
        <div class="row" style="display: flex; flex-direction: column; height: 100%;">
            <jsp:include page="user_menu.jsp" flush="true"/>
        </div>
    </div>
</body>
</html>
