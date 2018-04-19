package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Weather;
import dao.WeatherDao;

public class WeatherServlet extends HttpServlet {

	public WeatherServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取ServletPath
		String url = request.getServletPath();
		// 获取ContextPath
		String path = request.getContextPath();
		System.out.println("url====" + url);
		System.out.println("path====" + path);

		if (url.equals("/query.weather")) {

			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			String provinceName = request.getParameter("provinceName");
			Weather weather = new Weather(provinceName);
			System.out.println("this is servlet-weatherdisplay   "
					+ provinceName);
			try {
				List<Weather> weatherList = WeatherDao
						.printProvinceWeather(weather);
				request.setAttribute("weatherList", weatherList);
				request.getRequestDispatcher("WeatherDisplay.jsp").forward(
						request, response);
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("11111");
				String message = String
						.format("您输入的省份有误，请输入省份中文名称！<meta http-equiv='refresh' content='3;url=%s'/>",
								request.getContextPath() + "/WeatherModify.jsp");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/pattern/Message.jsp").forward(
						request, response);
			}
		}

		if (url.equals("/query2.weather")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			String provinceName = request.getParameter("provinceName");
			System.out.println("this is servlet-weatherdisplay   "
					+ provinceName);
			Weather weather = new Weather(provinceName);
			try {
				List<Weather> weatherList = WeatherDao
						.printProvinceWeatherUser(weather);
				request.setAttribute("weatherList", weatherList);
				request.getRequestDispatcher("WeatherDisplay.jsp").forward(
						request, response);
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("11111");
				String message = String
						.format("您输入的省份有误，请输入省份中文名称！<meta http-equiv='refresh' content='3;url=%s'/>",
								request.getContextPath() + "/WeatherModify.jsp");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/pattern/Message.jsp").forward(
						request, response);
			}
		}

		if (url.equals("/add.weather")) {
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
			int avgHumidity = Integer.parseInt(request
					.getParameter("avgHumidity"));
			float avgPrecipitation = Float.parseFloat(request
					.getParameter("avgPrecipitation"));
			float avgWindSpeed = Float.parseFloat(request
					.getParameter("avgWindSpeed"));
			Weather weather = new Weather(month, province, avgPressure,
					avgTemperature, avgHumidity, avgPrecipitation, avgWindSpeed);
			int count = WeatherDao.addProvinceWeather(weather);
			if (count == 1) {
				System.out.println("添加天气成功");
			} else {
				System.out.println("添加天气失败");
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("WeatherModify.jsp");
			rd.forward(request, response);
			out.flush();
			out.close();
		}

		if (url.equals("/del.weather")) {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			int month = Integer.parseInt(request.getParameter("month"));
			String provinceName = request.getParameter("provinceName");
			System.out.println("this is WeatherDel " + month + provinceName);
			int count = WeatherDao.delProvinceWeather(provinceName, month);
			if (count == 1) {
				System.out.println("删除天气成功");
			} else {
				System.out.println("删除天气失败");
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("WeatherModify.jsp");
			rd.forward(request, response);
			out.flush();
			out.close();
		}
	}

	public void init() throws ServletException {
	}

}
