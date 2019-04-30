<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>提交订单-女院便捷打印服务系统</title>
    <style>
        html {
            width: 100%;
            height: 100%;
            /* overflow: hidden; */
        }
    </style>
  </head>
  
  <body>
    <div class="container-fluid" style="min-width: 1200px; height: 100%;">
        
        <div class="row" style="display: flex; flex-direction: column;height: 15%">
            <jsp:include page="user_menu.jsp" flush="true"/>
        </div>
        
        <div class="row">
        	<div class="col-md-2"></div>
        	<div class="col-md-8">
        	<table class="table table-condensed" style="margin: auto">
	            <thead>
	                <tr class="active">
	                    <th colspan="2" text-align="center">打印信息：</th>
	                </tr>
	            </thead>
	            <tbody>
	                <tr class="active">
	                    <td align="center">文件ID：</td>
	                    <td align="center">123</td>
	                </tr>
	                <tr class="active">
	                    <td align="center">文件名：</td>
	                    <td align="center">简历.pdf</td>
	                </tr>
	                <tr class="active">
	                    <td align="center">打印份数：</td>
	                    <td align="center">2</td>
	                </tr>
	                <tr class="active">
	                    <td align="center">是否紧急：</td>
	                    <td align="center">否</td>
	                </tr>
	                <tr class="active">
	                    <td align="center">打印类型：</td>
	                    <td align="center">彩色单面</td>
	                </tr>
	                <tr class="active">
	                    <td align="center">备注：</td>
	                    <td align="center">无</td>
	                </tr>
	                <tr class="active">
	                    <td align="center">文档总页数：</td>
	                    <td align="center">10</td>
	                </tr>
	                <tr class="active">
	                    <td align="center">打印金额：</td>
	                    <td align="center" style="color:red">${Msg.printPrice}</td>
	                </tr>
	            </tbody>
	        </table>
	        </div>
	        <div class="col-md-2"></div>
        </div>
    </div>
</body>
</html>
