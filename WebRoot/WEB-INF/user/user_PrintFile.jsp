<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>打印文档-女院便捷打印服务系统</title>
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
                	<form action="${pageContext.request.contextPath }/printFile/upload.do" method="post" enctype="multipart/form-data">
	                    <input type="file" name="uploadFile" style="display: inline-block; margin-left: 15px;">
	                    <input class="btn btn-primary btn-sm" type="submit" value="上传"/>
	                   	 ${uploadMsg}${printCopiesNull}
	                   	 <br/>
	                   	 ${files}
                    </form>
                </div>
                <table data-toggle="table" id="table" data-striped="true" data-sort-name="文件名称" data-sort-order="desc"
                    data-search="true" data-strict-search="true" data-pagination="true" data-pagination-loop="false"
                    data-page-size="5" data-page-list=[5,10,20]>
                    <thead>
                        <tr>
                        	<th data-field="文件ID" data-align="center" data-sortable="true">文件ID</th>
                            <th data-field="文件名称" data-align="center" data-sortable="true">文件名称</th>
                            <th data-field="上传日期" data-align="center" data-sortable="true">上传日期</th>
                            <th data-field="操作" data-align="center" data-sortable="true">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${flist}" var="file" >
                        <tr>
                            <td>${file.id}</td>
                            <td>${file.fileName}</td>
                            <td><fmt:formatDate type="both" value="${file.uploadTime}" /></td>
                            <td>
                                <a class="btn btn-primary btn-sm" href="#" role="button" data-toggle="modal"
                                    data-target="#myModal" onclick="Values('${file.fileName}',${file.id})">打印</a>
                                <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/printFile/deleteFile?fileId=${file.id}" role="button">删除</a>
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
                    <h4 class="modal-title">打印详情</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/printFile/pay" method="post">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">文件 ID:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="id" placeholder="文档名称" name="fileId"> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">文件名称:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name" placeholder="文档名称" name="fileName"> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="num" class="col-sm-2 control-label">打印份数:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="num" placeholder="打印份数" name="printCopies">
                            </div>
                        </div>
                         <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">是否紧急:</label>
                            <div class="col-sm-10">
                                <div class="radio">
                                    <label style="margin-right: 20px;">
                                        <input type="radio" name="urgentStatus" id="optionsRadios1" value=1
                                            checked>
                                       		 是
                                    </label>
                                    <label>
                                        <input type="radio" name="urgentStatus" id="optionsRadios1" value=0
                                            checked>
                                        	否
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">打印类型:</label>
                            <div class="col-sm-10">
                                <div class="radio">
                                    <label style="margin-right: 20px;">
                                        <input type="radio" name="printType" id="optionsRadios1" value=1
                                            checked>
                                       		 黑白单面
                                    </label>
                                    <label style="margin-right: 20px;">
                                        <input type="radio" name="printType" id="optionsRadios1" value=2
                                            checked>
                                        	黑白双面
                                    </label>
                                    <label style="margin-right: 20px;">
                                        <input type="radio" name="printType" id="optionsRadios1" value=3
                                            checked>
                                        	彩色单面
                                    </label>
                                    <label>
                                        <input type="radio" name="printType" id="optionsRadios1" value=4
                                            checked>
                                        	彩色双面
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="num" class="col-sm-2 control-label">备注信息:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="num" placeholder="备注信息" name="printRemark">
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
</body>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
<script>
	function Values(fileName,fileId){
		$("#name").val(fileName);
		$("#id").val(fileId);
	}
	
    var myHeight = window.innerHeight - 80;
    $('#table').bootstrapTable({
        height: myHeight,
    });
</script>
</html>
