package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WeatherDao;

import bean.Weather;

public class WeatherAdd extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
        int month=Integer.parseInt(request.getParameter("month"));
        String province=request.getParameter("province");
        float avgPressure=Float.parseFloat(request.getParameter("avgPressure"));
        float avgTemperature=Float.parseFloat(request.getParameter("avgTemperature"));
        int avgHumidity=Integer.parseInt(request.getParameter("avgHumidity"));
        float avgPrecipitation=Float.parseFloat(request.getParameter("avgPrecipitation"));
        float avgWindSpeed=Float.parseFloat(request.getParameter("avgWindSpeed"));
        Weather weather=new Weather(month,province,avgPressure,avgTemperature,avgHumidity,avgPrecipitation,avgWindSpeed);
        int count=WeatherDao.addProvinceWeather(weather);
        if(count==1){
        	System.out.println("添加天气成功");
        }else{
        	System.out.println("添加天气失败");
        }
        RequestDispatcher rd=request.getRequestDispatcher("AdminWeatherModify.jsp");
        rd.forward(request,response);
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
