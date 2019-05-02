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
        		<form action="${pageContext.request.contextPath}/printFile/createOrder" method="post">
		        	<table class="table table-condensed" style="margin: auto">
			            <thead>
			                <tr class="active">
			                    <th colspan="2" text-align="center">打印信息：</th>
			                </tr>
			            </thead>
			            <tbody>
			                <tr class="active">
			                    <td align="right">文件ID号：</td>
			                    <td align="center">
			                    	<input type="text" name="fileIdstr" value="${Msg.fileId}" readonly="readonly" style="width:80%">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">文件名称：</td>
			                    <td align="center">
			                    	<input type="text" name="fileName" value="${Msg.fileName}" readonly="readonly" style="width:80%">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">打印份数：</td>
			                    <td align="center">
			                    	<input type="text" name="printCopiesstr" value="${Msg.printCopies }" readonly="readonly" style="width:80%">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">是否紧急：</td>
			                    <td align="center">
			                    	<input type="text" name="urgentStatusstr" value="${Msg.urgentStatus }" readonly="readonly" style="width:80%">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">打印类型：</td>
			                    <td align="center">
			                    	<input type="text" name="printTypestr" value="${Msg.printType }" readonly="readonly" style="width:80%">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">备注：</td>
			                    <td align="center">
			                    	<input type="text" name="printRemark" value="${Msg.printRemark }" readonly="readonly" style="width:80%">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right">文档总页数：</td>
			                    <td align="center">
			                    	<input type="text" name="pageNumstr" value="${Msg.pageNum}" readonly="readonly" style="width:80%">
			                    </td>
			                </tr>
			                <tr class="active">
			                    <td align="right"><b>打印总金额：</b></td>
			                    <td align="center" style="color:red;font-size:20px">
			                    	<input type="text" name="payAmountstr" value="${Msg.payAmount}" readonly="readonly" style="width:80%">
			                    </td>
			                </tr>
			            </tbody>
			        </table>
			        <div style="height:10%" align="center">
			        	${noRemainSum}${payError}
			        </div>
		        	<div align="center">
		        		<button type="submit" class="btn btn-primary">确认支付</button>
		        	</div>
	        	</form>
	        </div>
	        <div class="col-md-3"></div>
        </div>
    </div>
</body>
</html>
