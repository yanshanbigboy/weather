<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="ProvinceAdd" method="post">
        <h3>增加省份：请输入要添加的省份</h3>
        <input type="text" name="provinceName"></br>
        <input type="text" name="population"></br>
        <input type="Submit" value="确定">
    </form>
<h3>==============================================s</h3>

<form action="WeatherAdd" method="post">
        <h3>添加省份天气数据</h3>
                     月份：<input type="text" name="month"><br>
                     省份：<input type="text" name="province"><br>
                     平均气压（单位百帕）：<input type="text" name="avgPressure"><br>
                     平均气温（单位℃）：<input type="text" name="avgTemperature"><br>
                     平均湿度（单位%）：<input type="text" name="avgHumidity"><br>
                     平均降水量（单位mm）：<input type="text" name="avgPrecipitation"><br>
                     平均风速（单位m/s）：<input type="text" name="avgWindSpeed"><br>
         <input type="Submit" value="确定">
</form>
<form action="WeatherDel" method="post">
        <h3>天气数据删除：请输入省份和要删除数据的月份</h3>
                   省份：<input type="text" name="provinceName">
                   月份：<input type="text" name="month">
                   <input type="Submit" value="确定">
    </form>

</body>
</html>