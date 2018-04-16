package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UIServlet extends HttpServlet {

	public UIServlet() {
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

		if (url.equals("/login.ui")) {
			request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(
					request, response);
		}
		if (url.equals("/registe.ui")) {
			request.getRequestDispatcher("/WEB-INF/pages/Register.jsp")
					.forward(request, response);
		}
	}

	public void init() throws ServletException {
	}

}
