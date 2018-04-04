package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WeatherDao;

public class WeatherDel extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
				.getRequestDispatcher("AdminWeatherModify.jsp");
		rd.forward(request, response);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
