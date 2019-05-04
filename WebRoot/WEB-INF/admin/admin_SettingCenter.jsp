<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>设置中心-女院便捷打印服务系统</title>
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
        <div class="row" style="display: flex; flex-direction: column;">
            <jsp:include page="admin_menu.jsp" flush="true"/>
        </div>
        <div class="row">
        	<div class="col-md-1"></div>
        	<div class="col-md-3">
	        	<form class="bs-example bs-example-form" role="form" action="${pageContext.request.contextPath}/SettingCenter/setTypePrice" method="post">
					<div class="text-center">
						<b>设置不同打印类型单价</b>
					</div>
					<div class="row" style="height:2%;"></div>
					<div class="input-group">
						<span class="input-group-addon">紧急-黑白单面：</span>
						<input type="text" class="form-control" placeholder="每页单价" name="J_BW_S" value="${J_BW_S}">
						<span class="input-group-addon">￥</span>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">紧急-黑白双面：</span>
						<input type="text" class="form-control" placeholder="每页单价" name="J_BW_D" value="${J_BW_D}">
						<span class="input-group-addon">￥</span>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">紧急-彩色单面：</span>
						<input type="text" class="form-control" placeholder="每页单价" name="J_CO_S" value="${J_CO_S}">
						<span class="input-group-addon">￥</span>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">紧急-彩色双面：</span>
						<input type="text" class="form-control" placeholder="每页单价" name="J_CO_D" value="${J_CO_D}">
						<span class="input-group-addon">￥</span>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">普通-黑白单面：</span>
						<input type="text" class="form-control" placeholder="每页单价" name="P_BW_S" value="${P_BW_S}">
						<span class="input-group-addon">￥</span>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">普通-黑白双面：</span>
						<input type="text" class="form-control" placeholder="每页单价" name="P_BW_D" value="${P_BW_D}">
						<span class="input-group-addon">￥</span>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">普通-彩色单面：</span>
						<input type="text" class="form-control" placeholder="每页单价" name="P_CO_S" value="${P_CO_S}">
						<span class="input-group-addon">￥</span>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">普通-彩色双面：</span>
						<input type="text" class="form-control" placeholder="每页单价" name="P_CO_D" value="${P_CO_D}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:2%;"></div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary" style ="width:100%;">保存更改</button>
					</div>
					
				</form>
			</div>
			
        	<div class="col-md-2">
        		<div class="row" style="height:30%;"></div>
        		<div class="text-center">${Msg}</div>
        	</div>
			<div class="col-md-5">
				<form class="bs-example bs-example-form" role="form" action="${pageContext.request.contextPath}/SettingCenter/setCardPrice" method="post">
					<div class="text-center">
						<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/SettingCenter/createCardCode" role="button" style ="width:100%;">生成充值卡序列号</a>
					</div>
					<div class="row" style="height:2%;"></div>
					<div class="input-group">
						<span class="input-group-addon">01.</span>
						<input type="text" class="form-control" readonly="readonly" name="u1" value="${u0}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p1" value="${p1}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:1%;"></div>
					<div class="input-group">
						<span class="input-group-addon">02.</span>
						<input type="text" class="form-control" readonly="readonly" name="u2" value="${u1}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p2" value="${p2}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:1%;"></div>
					<div class="input-group">
						<span class="input-group-addon">03.</span>
						<input type="text" class="form-control" readonly="readonly" name="u3" value="${u2}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p3" value="${p3}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:1%;"></div>
					<div class="input-group">
						<span class="input-group-addon">04.</span>
						<input type="text" class="form-control" readonly="readonly" name="u4" value="${u3}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p4" value="${p4}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:1%;"></div>
					<div class="input-group">
						<span class="input-group-addon">05.</span>
						<input type="text" class="form-control" readonly="readonly" name="u5" value="${u4}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p5" value="${p5}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:1%;"></div>
					<div class="input-group">
						<span class="input-group-addon">06.</span>
						<input type="text" class="form-control" readonly="readonly" name="u6" value="${u5}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p6" value="${p6}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:1%;"></div>
					<div class="input-group">
						<span class="input-group-addon">07.</span>
						<input type="text" class="form-control" readonly="readonly" name="u7" value="${u6}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p7" value="${p7}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:1%;"></div>
					<div class="input-group">
						<span class="input-group-addon">08.</span>
						<input type="text" class="form-control" readonly="readonly" name="u8" value="${u7}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p8" value="${p8}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:1%;"></div>
					<div class="input-group">
						<span class="input-group-addon">09.</span>
						<input type="text" class="form-control" readonly="readonly" name="u9" value="${u8}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p9" value="${p9}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:1%;"></div>
					<div class="input-group">
						<span class="input-group-addon">10.</span>
						<input type="text" class="form-control" readonly="readonly" name="u10" value="${u9}">
						<span class="input-group-addon">:</span>
						<input type="text" class="form-control" placeholder="设定充值卡金额" name="p10" value="${p10}">
						<span class="input-group-addon">￥</span>
					</div>
					<div class="row" style="height:2%;"></div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary" style ="width:100%;">保存</button>
					</div>
					
				</form>
			</div>
			<div class="col-md-1"></div>
        </div>
    </div>
</body>
</html>
