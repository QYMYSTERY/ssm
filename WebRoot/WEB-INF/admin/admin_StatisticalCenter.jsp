<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>统计中心-女院便捷打印服务系统</title>
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
    	    backgroundColor: '#2c343c',

    	    title: {
    	        text: '订单类型统计',
    	        left: 'center',
    	        top: 20,
    	        textStyle: {
    	            color: '#ccc'
    	        }
    	    },

    	    tooltip : {
    	        trigger: 'item',
    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    	    },

    	    visualMap: {
    	        show: false,
    	        min: 80,
    	        max: 600,
    	        inRange: {
    	            colorLightness: [0, 1]
    	        }
    	    },
    	    series : [
    	        {
    	            name:'访问来源',
    	            type:'pie',
    	            radius : '55%',
    	            center: ['50%', '50%'],
    	            data:[
    	                {value:335, name:'黑白双面'},
    	                {value:310, name:'黑白单面'},
    	                {value:274, name:'彩色单面'},
    	                {value:235, name:'彩色双面'}
    	            ].sort(function (a, b) { return a.value - b.value; }),
    	            roseType: 'radius',
    	            label: {
    	                normal: {
    	                    textStyle: {
    	                        color: 'rgba(255, 255, 255, 0.3)'
    	                    }
    	                }
    	            },
    	            labelLine: {
    	                normal: {
    	                    lineStyle: {
    	                        color: 'rgba(255, 255, 255, 0.3)'
    	                    },
    	                    smooth: 0.2,
    	                    length: 10,
    	                    length2: 20
    	                }
    	            },
    	            itemStyle: {
    	                normal: {
    	                    color: '#c23531',
    	                    shadowBlur: 200,
    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    	                }
    	            },

    	            animationType: 'scale',
    	            animationEasing: 'elasticOut',
    	            animationDelay: function (idx) {
    	                return Math.random() * 200;
    	            }
    	        }
    	    ]
    	};
    myChart.setOption(option);
</script>
</html>
