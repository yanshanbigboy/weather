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

public class ProvinceServlet extends HttpServlet {

	public ProvinceServlet() {
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
		// ��ȡServletPath
		String url = request.getServletPath();
		// ��ȡContextPath
		String path = request.getContextPath();
		System.out.println("url====" + url);
		System.out.println("path====" + path);
		// Servlet����·��ƥ��
		if (url.equals("/add.province")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			String provinceName = request.getParameter("provinceName");
			int population = Integer.parseInt(request
					.getParameter("population"));
			Province province = new Province(provinceName, population);
			int count1 = ProvinceDao.addProvince(province);
			int count2 = WeatherDao.addProvinceTable(provinceName);
			if (count1 == 1) {
				System.out.println("���ʡ�ݳɹ�");
				RequestDispatcher rd = request
						.getRequestDispatcher("WeatherModify.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("���ʡ��ʧ��");
				String message = String
						.format("�������ʡ���Ѵ��ڣ�����ɾ����<meta http-equiv='refresh' content='3;url=%s'/>",
								request.getContextPath() + "/WeatherModify.jsp");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/pattern/Message.jsp").forward(
						request, response);
			}
			
			
			
		}

		if (url.equals("/del.province")) {
			response.setContentType("text/html��charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			String provinceName = request.getParameter("provinceName");
			int count = ProvinceDao.delProvince(provinceName);
			int count2 = WeatherDao.delProvinceTable(provinceName);
			if (count == 1) {
				System.out.println("ɾ��ʡ�ɹ�");
			} else {
				System.out.println("ɾ��ʡʧ��");
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
