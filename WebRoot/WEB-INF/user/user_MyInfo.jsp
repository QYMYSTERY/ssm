<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        <div class="row" style="display: flex; flex-direction: column;height:30%">
            <jsp:include page="user_menu.jsp" flush="true"/>
        </div>
        <div class="row">
        	<div class="col-md-3"></div>
        	<div class="col-md-6">
	        	<table class="table table-condensed" style="margin: auto">
		            <thead>
		                <tr class="active">
		                    <th colspan="2" text-align="center">个人信息：</th>
		                </tr>
		            </thead>
		            <tbody>
		                <tr>
		                    <td align="right">用户名：</td>
		                    <td align="center">
		                    	<input type="text" name="userName" value="${username}" readonly="readonly" style="width:80%">
		                    </td>
		                </tr>
		                <tr class="active">
		                    <td align="right">手机号：</td>
		                    <td align="center">
		                    	<input type="text" name="userPhone" value="${userPhone}" readonly="readonly" style="width:80%">
		                    </td>
		                </tr>
		                <tr>
		                    <td align="right">密码：</td>
		                    <td align="center">
		                    	<input type="password" name="userPwd" value="${userePwd}" readonly="readonly" style="width:80%">
		                    </td>
		                </tr>
		                <tr class="active">
		                    <td align="right">注册时间：</td>
		                    <td align="center">
		                    	<input type="text" name="cTime" value="<fmt:formatDate type="both" value="${cTime}" />" readonly="readonly" style="width:80%">
		                    </td>
		                </tr>
		            </tbody>
		        </table>
		        <div style="height:5%" align="center"></div>
		        <div style="height:5%;color:red" align="center">
		        	${Msg}${payError}
		        </div>
	        	<div align="center">
	        		<a class="btn btn-primary btn-sm" href="#" role="button" data-toggle="modal"
                                   data-target="#myModal" onclick="Values('${username}','${userPhone}')">修改个人信息</a>
	        	</div>
	        </div>
	        <div class="col-md-3"></div>
        </div>
    </div>
    <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改个人信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/personal/updateUserInfo" method="post">
                    	<div class="form-group">
                            <label for="name" class="col-sm-3 control-label">手机号:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="id" placeholder="手机号" name="userPhone" value="${userPhone}"> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">用户名:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="id" placeholder="用户名" name="userName" value="${username}"> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">原密码:</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="id" placeholder="请输入原密码" name="oldPwd"> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">新密码:</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="id" placeholder="密码" name="userPwd"> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">新密码确认:</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="id" placeholder="密码" name="userRpwd"> 
                            </div>
                        </div>
                        <div class="modal-footer">
                   	 		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    		<button type="submit" class="btn btn-primary">确认修改</button>
                		</div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </div>
</body>
</html>
