<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>我的钱包-女院便捷打印服务系统</title>
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
        <div class="row" style="display: flex; flex-direction: column; height: 30%;">
            <jsp:include page="user_menu.jsp" flush="true"/>
            
        </div>
        <div class="row">
        	<div class="col-md-4"></div>
            <div class="col-md-4">
	            <table class="table table-condensed" style="margin: auto">
		            <tbody>
		                <tr class="active">
		                    <td align="center" style="font-size:28px;">余额:</td>
		                    <td align="center" style="font-size:28px;">${balance}</td>
		                </tr>
		            </tbody>
		        </table>
		        <div class="row" style="height:8%" align="center"> </div>
		        <div class="row" style="height:10%;color:red" align="center">
		        	${uuidNull}${uuidNotExist}${cardInvalid}
		        </div>
		        <div align="center">
	        		<a class="btn btn-primary btn-sm" href="#" role="button" data-toggle="modal"
                                    data-target="#myModal">充    值</a>
                    <a class="btn btn-primary btn-sm" href="#" role="button">明细</a>
	        	</div>
	        </div>
	        <div class="col-md-4"></div>
        </div>
        <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">充值中心</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/myWallet/recharge" method="post">
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">充值卡序列号:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="id" placeholder="请输入充值卡序列号" name="uuid"> 
                            </div>
                        </div>
                        <div class="modal-footer">
                   	 		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    		<button type="submit" class="btn btn-primary">确认</button>
                		</div>
                    </form>
                </div>
                
            </div>
        </div>
    </div>
    </div>
</body>
</html>
