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
        	<div class="col-md-3"></div>
        	<div class="col-md-6">
        		<form action="${pageContext.request.contextPath}/printFile/pay" method="post">
		        	<table class="table table-condensed" style="margin: auto">
			            <thead>
			                <tr class="active">
			                    <th colspan="2" text-align="center">打印信息：</th>
			                </tr>
			            </thead>
			            <tbody>
			                <tr class="active">
			                    <td align="right">文件ID：</td>
			                    <td align="center">
			                    	<input type="text" name="fileId" value="${Msg.fileId}" disabled="disabled">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">文件名：</td>
			                    <td align="center">
			                    	<input type="text" name="fileName" value="${Msg.fileName}" disabled="disabled">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">打印份数：</td>
			                    <td align="center">
			                    	<input type="text" name="printCopies" value="${Msg.printCopies }" disabled="disabled">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">是否紧急：</td>
			                    <td align="center">
			                    	<input type="text" name="urgentStatus" value="${Msg.urgentStatus }" disabled="disabled">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">打印类型：</td>
			                    <td align="center">
			                    	<input type="text" name="printType" value="${Msg.printType }" disabled="disabled">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">备注：</td>
			                    <td align="center">
			                    	<input type="text" name="printRemark" value="${Msg.printRemark }" disabled="disabled">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">文档总页数：</td>
			                    <td align="center">
			                    	<input type="text" name="pageNum" value="${Msg.pageNum}" disabled="disabled">
			                    </td>
			                </tr>
			                <tr>
			                    <td align="right">打印总金额：</td>
			                    <td align="center" style="color:red">
			                    	${Msg.payAmount}
			                    </td>
			                </tr>
			            </tbody>
			        </table>
		        	<div>
		        		<button type="submit" class="btn btn-primary">提交支付</button>
		        	</div>
	        	</form>
	        </div>
	        <div class="col-md-3"></div>
        </div>
    </div>
</body>
</html>
