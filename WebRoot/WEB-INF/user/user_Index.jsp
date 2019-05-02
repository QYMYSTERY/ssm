<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页-女院便捷打印服务系统</title>
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
            <div style="flex: 1;">
                <div id="main" style="width: 100%; height: 100%;"></div>
            </div>
        </div>
    </div>
</body>
<script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts-en.common.js"></script>
<script type="text/javascript">
	var myHeight = window.innerHeight - 100;
	$('#main').css({
	'height': myHeight
	})
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '高峰时段统计',
            x: 'center',
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        xAxis: {
            type: 'category',
            data: ['0','1', '2', '3', '4', '5', '6', '7','8', '9', '10', '11', '12', '13', '14','15', '16', '17', '18', '19', '20', '21','22', '23']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [901, 934, 1290, 1330, 1320, 932, 901, 934, 1290, 1330, 1320,820, 932, 901, 934, 1290, 1330, 1320, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
        }]
    };
    myChart.setOption(option);
</script>
</html>
