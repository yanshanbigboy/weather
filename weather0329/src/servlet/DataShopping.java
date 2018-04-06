package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ShoppingItem;

public class DataShopping extends HttpServlet {

	public DataShopping() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String path = request.getContextPath();
		String url = request.getServletPath();
		System.out.println(url);

		String[] elem = request.getParameterValues("elements");
		String[] area = request.getParameterValues("area");
		String[] frequency = request.getParameterValues("frequency");
		System.out.println("area.length===" + area.length);
		if (elem.length <= 0 || area.length <= 0 || frequency.length <= 0) {
			String message = String.format(
					"请填写完整信息<meta http-equiv='refresh' content='2;url=%s'/>",
					path + "/ShoppingView.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/Message.jsp").forward(request,
					response);
		}
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		String email = request.getParameter("email");
		String other = request.getParameter("other");
		String strElem = "";
		String strArea = "";
		String strFrequency = "";

		for (int i = 0; i < elem.length; i++) {
			strElem += elem[i];
		}
		System.out.println(strElem);

		for (int i = 0; i < area.length; i++) {
			strArea += area[i];
		}
		for (int i = 0; i < frequency.length; i++) {
			strElem += frequency[i];
		}
		ShoppingItem item = new ShoppingItem(strElem, strArea, strFrequency,
				name, company, phone, email, other);

	}

	public void init() throws ServletException {
	}

}
