package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Weather;
import dao.WeatherDao;

public class WeatherAdd extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int month = Integer.parseInt(request.getParameter("month"));
		String province = request.getParameter("province");
		float avgPressure = Float.parseFloat(request
				.getParameter("avgPressure"));
		float avgTemperature = Float.parseFloat(request
				.getParameter("avgTemperature"));
		int avgHumidity = Integer.parseInt(request.getParameter("avgHumidity"));
		float avgPrecipitation = Float.parseFloat(request
				.getParameter("avgPrecipitation"));
		float avgWindSpeed = Float.parseFloat(request
				.getParameter("avgWindSpeed"));
		Weather weather = new Weather(month, province, avgPressure,
				avgTemperature, avgHumidity, avgPrecipitation, avgWindSpeed);
		int count = WeatherDao.addProvinceWeather(weather);
		if (count == 1) {
			System.out.println("��������ɹ�");
		} else {
			System.out.println("�������ʧ��");
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("AdminWeatherModify.jsp");
		rd.forward(request, response);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
