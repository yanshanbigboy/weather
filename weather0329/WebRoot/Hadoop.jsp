<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<body>
<!-- start of header -->
<jsp:include page="/pattern/Header.jsp"></jsp:include>
<!-- end of header -->


<div class="bg-content">
	<p style="color: #FF4500;font-size:35px; margin-left: 5px; position: relative;top:20px;">基于Hadoop的大数据处理<p>
	<!-- content-->
	<br>
	<h5 style="color: #FF4500;position: relative;top:20px;left:5px">2017全国平均温度（摄氏度）</h5>
	<h5 style="position: relative;top:10px;left:5px">数据来自国家气象局</h5>
	<div style="height: 50px"></div>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->

<div id="main" style="height:600px"></div>
<!-- ECharts单文件引入 -->
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<script type="text/javascript">
    // 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    require(
        [
            'echarts',
            'echarts/chart/pie',
            'echarts/chart/map'
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('main'));

            var option = {
                title : {
                    
                },
                tooltip : {
                    trigger: 'item'
                },
                legend: {
                    x:'right',
                    selectedMode:false,
                    data:['北京','上海','广东']
                },
                dataRange: {
                    orient: 'horizontal',
                    min: 3,
                    max: 25,
                    text:['高','低'],           // 文本，默认为数值文本
                    splitNumber:0,
                },
                toolbox: {
                    show : true,
                    orient: 'vertical',
                    x:'right',
                    y:'center',
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false}
                    }
                },
                series : [
                    {
                        name: '2017年各省市平均气温',
                        type: 'map',
                        mapType: 'china',
                        mapLocation: {
                            x: 'left'
                        },
                        selectedMode : 'multiple',
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{label:{show:true}}
                        },
                        data:[
                            {name:'西藏', value:7.04},
                            {name:'青海', value:3.56},
                            {name:'宁夏', value:9.525},
                            {name:'海南', value:24.85},
                            {name:'甘肃', value:5.42},
                            {name:'贵州', value:16.36},
                            {name:'新疆', value:15.125},
                            {name:'云南', value:15.05},
                            {name:'重庆', value:17.21},
                            {name:'吉林', value:6.125},
                            {name:'山西', value:10.42},
                            {name:'天津', value:12.9},
                            {name:'江西', value:18},
                            {name:'广西', value:21.83},
                            {name:'陕西', value:13.53},
                            {name:'黑龙江', value:4.85},
                            {name:'内蒙古', value:7.725},
                            {name:'安徽', value:16.19},
                            {name:'北京', value:12.75, selected:true},
                            {name:'福建', value:20.7},
                            {name:'上海', value:17.13, selected:true},
                            {name:'湖北', value:17.13},
                            {name:'湖南', value:17.4},
                            {name:'四川', value:18.06},
                            {name:'辽宁', value:8.525},
                            {name:'河北', value:13.325},
                            {name:'河南', value:14.73},
                            {name:'浙江', value:16.95},
                            {name:'山东', value:14.12},
                            {name:'江苏', value:15.9},
                            {name:'广东', value:22.675, selected:true}
                        ]
                    },
                    {
                        name:'2017全国平均温度对比',
                        type:'pie',
                        roseType : 'area',
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        center: [document.getElementById('main').offsetWidth - 250, 225],
                        radius: [30, 120],
                        data:[
                            {name: '北京', value: 12.75},
                            {name: '上海', value: 17.13},
                            {name: '广东', value: 22.675}
                        ]
                    }
                ],
                animation: false
            };
            myChart.setOption(option)
            var ecConfig = require('echarts/config');
            myChart.on(ecConfig.EVENT.MAP_SELECTED, function (param){
                var selected = param.selected;
                var mapSeries = option.series[0];
                var data = [];
                var legendData = [];
                var name;
                for (var p = 0, len = mapSeries.data.length; p < len; p++) {
                    name = mapSeries.data[p].name;
                    //mapSeries.data[p].selected = selected[name];
                    if (selected[name]) {
                        data.push({
                            name: name,
                            value: mapSeries.data[p].value
                        });
                        legendData.push(name);
                    }
                }
                option.legend.data = legendData;
                option.series[1].data = data;
                myChart.setOption(option, true);
            })
        }
    );
</script>

<!--  footer  -->
<!--start of footer  -->
<jsp:include page="/pattern/Footer.jsp"></jsp:include>
<!--end of footer  -->

<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>