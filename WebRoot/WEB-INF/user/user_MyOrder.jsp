<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>我的订单-女院便捷打印服务系统</title>
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
            <jsp:include page="user_menu.jsp" flush="true"/>
            <div style="padding: 0 15px; flex: 1;">
            	 <div class="col-sm-8 text-xs-center text-left" style="margin-top: 15px; padding-left: 0;">
                    <a class="btn btn-primary btn-sm" href=" #" role="button">已完成</a>
                    <a class="btn btn-default btn-sm" href=" #" role="button">未完成</a>
                </div>
                <table data-toggle="table" id="table" data-striped="true" data-sort-name="订单编号" data-sort-order="desc"
                    data-pagination="true" data-search="true" data-strict-search="true" data-pagination-loop="false" data-page-size="5" data-page-list=[5,10,20]>
                    <thead>
                        <tr>
                            <th data-field="订单编号" data-align="center" data-sortable="true">订单编号</th>
                            <th data-field="文件名称" data-align="center" data-sortable="true">文件名称</th>
                            <th data-field="提交时间" data-align="center" data-sortable="true">提交时间</th>
                            <th data-field="状态" data-align="center" data-sortable="true">状态</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>001</td>
                            <td>测试表格</td>
                            <td>2019-05-01</td>
                            <td>打印完成</td>
                        </tr>
                        <tr>
                            <td>001</td>
                            <td>测试表格</td>
                            <td>2019-05-01</td>
                            <td>打印完成</td>
                        </tr>
                        <tr>
                            <td>001</td>
                            <td>测试表格</td>
                            <td>2019-05-01</td>
                            <td>打印完成</td>
                        </tr>
                        <tr>
                            <td>001</td>
                            <td>测试表格</td>
                            <td>2019-05-01</td>
                            <td>打印完成</td>
                        </tr>
                        <tr>
                            <td>001</td>
                            <td>测试表格</td>
                            <td>2019-05-01</td>
                            <td>打印完成</td>
                        </tr>
                        <tr>
                            <td>001</td>
                            <td>测试表格</td>
                            <td>2019-05-01</td>
                            <td>打印完成</td>
                        </tr>
                        <tr>
                            <td>001</td>
                            <td>测试表格</td>
                            <td>2019-05-01</td>
                            <td>打印完成</td>
                        </tr>
                    </tbody>
                </table>
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
