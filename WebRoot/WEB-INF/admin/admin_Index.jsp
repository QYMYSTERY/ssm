<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>新订单-女院便捷打印服务系统</title>
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
                    <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/newOrder/urgencyNewOrder" role="button">紧急</a>
                    <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/newOrder/generalNewOrder" role="button">普通</a>
                    <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/newOrder/allNewOrder" role="button">所有</a>
                </div>
                <table data-toggle="table" id="table" data-striped="true" data-sort-name="订单编号" data-sort-order="desc"
                    data-pagination="true" data-search="true" data-strict-search="true" data-pagination-loop="false" data-page-size="5" data-page-list=[5,10,20]>
                    <thead>
                        <tr>
                            <th data-field="订单编号" data-align="center" data-sortable="true">订单编号</th>
                            <th data-field="用户名" data-align="center" data-sortable="true">用户名</th>
                            <th data-field="文件名称" data-align="center" data-sortable="true">文件名称</th>
                            <th data-field="订单状态" data-align="center" data-sortable="true">订单状态</th>
                            <th data-field="提交时间" data-align="center" data-sortable="true">提交时间</th>
                            <th data-field="打印要求" data-align="center" data-sortable="true">打印要求</th>
                            <th data-field="备注" data-align="center" data-sortable="true">备注</th>
                            <th data-field="操作" data-align="center" data-sortable="true">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                     <c:forEach items="${listOrder}" var="orderList" >
                        <tr>
                            <td>${orderList.id}</td>
                            <td>${orderList.userId}</td>
                            <td>${orderList.fileName}</td>
                            <td>
                            	<c:if test="${orderList.orderStatus==1}">
                            		已提交
                            	</c:if>
                            	<c:if test="${orderList.orderStatus==2}">
                            		打印中
                            	</c:if>
                            	<c:if test="${orderList.orderStatus==3}">
                            		已完成
                            	</c:if>
                            </td>
                            <td><fmt:formatDate type="both" value="${orderList.createTime}" /></td>
                            <td>
                            	<c:if test="${orderList.urgentStatus==0&&orderList.printType==1}">
                            		普通-黑白单面-${orderList.printCopies}份
                            	</c:if>
                            	<c:if test="${orderList.urgentStatus==0&&orderList.printType==2}">
                            		普通-黑白双面-${orderList.printCopies}份
                            	</c:if>
                            	<c:if test="${orderList.urgentStatus==0&&orderList.printType==3}">
                            		普通-彩色单面-${orderList.printCopies}份
                            	</c:if>
                            	<c:if test="${orderList.urgentStatus==0&&orderList.printType==4}">
                            		普通-彩色双面-${orderList.printCopies}份
                            	</c:if>
                            	<c:if test="${orderList.urgentStatus==1&&orderList.printType==1}">
                            		紧急-黑白单面-${orderList.printCopies}份
                            	</c:if>
                            	<c:if test="${orderList.urgentStatus==1&&orderList.printType==2}">
                            		紧急-黑白双面-${orderList.printCopies}份
                            	</c:if>
                            	<c:if test="${orderList.urgentStatus==1&&orderList.printType==3}">
                            		紧急-彩色单面-${orderList.printCopies}份
                            	</c:if>
                            	<c:if test="${orderList.urgentStatus==1&&orderList.printType==4}">
                            		紧急-彩色双面-${orderList.printCopies}份
                            	</c:if>
                            </td>
                            <td>${orderList.printRemark}</td>
                            <td>
                            	<a class="btn btn-danger btn-sm" href="#" role="button">下载</a>
                            </td>
                        </tr>
                      </c:forEach>
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
