<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>权限管理-女院便捷打印服务系统</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" rel="stylesheet">
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
            <jsp:include page="admin_menu.jsp" flush="true"/>
            <div style="padding: 0 15px; flex: 1;">
            	 <div class="col-sm-8 text-xs-center text-left" style="margin-top: 15px; padding-left: 0;">
                    <a class="btn btn-primary btn-sm" href="#" role="button" data-toggle="modal"
                                   data-target="#myModal" onclick="Values('${username}','${userPhone}')">新增管理员</a>
                    ${Msg}
                </div>
                <table data-toggle="table" id="table" data-striped="true" data-sort-name="用户名" data-sort-order="desc"
                    data-pagination="true" data-search="true" data-strict-search="true" data-pagination-loop="false" data-page-size="5" data-page-list=[5,10,20]>
                    <thead>
                        <tr>
                            <th data-field="用户名" data-align="center" data-sortable="true">用户名</th>
                            <th data-field="手机号" data-align="center" data-sortable="true">手机号</th>
                            <th data-field="密码" data-align="center" data-sortable="true">密码</th>
                            <th data-field="创建时间" data-align="center" data-sortable="true">创建时间</th>
                            <th data-field="操作" data-align="center" data-sortable="true">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                     <c:forEach items="${userList}" var="userList" >
                        <tr>
                            <td>${userList.userName}</td>
                            <td>${userList.userPhone}</td>
                            <td align="center">
                            	<input type="password" class="text-xs-center" readonly="readonly" name="u1" value="${userList.userPwd}" 
                            	style="width:150px;border:0;outline:none;background-color:rgba(0,0,0,0);text-align:center">
                            </td>
                            <td>
                            	<fmt:formatDate type="both" value="${userList.createTime}" />
                            </td>
                            <td>
                            	<a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/AuthorityManage/deleteAdmin?userId=${userList.id}" role="button">删除</a>
                            </td>
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">新增管理员</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/AuthorityManage/addAdmin" method="post">
                    	<div class="form-group">
                            <label for="name" class="col-sm-3 control-label">用户名:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="id" placeholder="用户名" name="userName"> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">手机号:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="id" placeholder="手机号" name="userPhone"> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">密码:</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="id" placeholder="请输入原密码" name="userPwd"> 
                            </div>
                        </div>
                        <div class="modal-footer">
                   	 		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    		<button type="submit" class="btn btn-primary">新增</button>
                		</div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
<script>
    var myHeight = window.innerHeight - 80;
    $('#table').bootstrapTable({
        height: myHeight,
    });
</script>
</html>
