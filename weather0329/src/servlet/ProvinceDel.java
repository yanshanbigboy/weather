package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProvinceDao;
import dao.WeatherDao;

public class ProvinceDel extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html��charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String provinceName=request.getParameter("provinceName");
		int count=ProvinceDao.delProvince(provinceName);
		int count2=WeatherDao.delProvinceTable(provinceName);
		if(count==1){
			System.out.println("ɾ��ʡ�ɹ�");
		}else{
			System.out.println("ɾ��ʡʧ��");
		}
		if(count2==1){
			System.out.println("ɾ��ʡ��ɹ�");
		}else{
			System.out.println("ɾ��ʡ��ʧ��");
		}
		RequestDispatcher rd=request.getRequestDispatcher("AdminWeatherModify.jsp");
		rd.forward(request, response);
		out.flush();
		out.close();
	}


}
