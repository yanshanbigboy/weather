package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Province;
import dao.ProvinceDao;
import dao.WeatherDao;

public class ProvinceAdd extends HttpServlet {

	public ProvinceAdd() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String provinceName = request.getParameter("provinceName");
		int population = Integer.parseInt(request.getParameter("population"));
		Province province = new Province(provinceName, population);
		int count1 = ProvinceDao.addProvince(province);
		int count2 = WeatherDao.addProvinceTable(provinceName);
		if (count1 == 1) {
			System.out.println("添加省份成功");
		} else {
			System.out.println("添加省份失败");
		}
		if (count2 == 1) {
			System.out.println("添加省份表成功");
		} else {
			System.out.println("添加省份表失败");
		}

		RequestDispatcher rd = request
				.getRequestDispatcher("AdminWeatherModify.jsp");
		rd.forward(request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
