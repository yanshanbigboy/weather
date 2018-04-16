package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDao;

public class UserManagement extends HttpServlet {

	public UserManagement() {
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
		HttpSession session = request.getSession();

		// 获取ServletPath
		String url = request.getServletPath();
		// 获取ContextPath
		String path = request.getContextPath();
		System.out.println("url====" + url);
		System.out.println("path====" + path);
		// Servlet采用路径匹配

		if (session.getAttribute("admin") == null
				&& session.getAttribute("user") == null) {
			String message = String
					.format("您还没有登录，请先登录！自动跳转到登录界面<meta http-equiv='refresh' content='2;url=%s'/>",
							request.getContextPath() + "/login.ui");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/pattern/Message.jsp").forward(
					request, response);
		} else if (session.getAttribute("admin") == null) {
			String message = String
					.format("您还没有以管理员身份登录，请先注销并以管理员身份登录！自动跳转到主页<meta http-equiv='refresh' content='3;url=%s'/>",
							request.getContextPath() + "/home.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/pattern/Message.jsp").forward(
					request, response);
		} else {// 验证通过， 前提是不允许同时有管理员和用户对象在同一个Session中(登录中已经进行了限制)

			if (url.equals("/add.user")) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				String username = request.getParameter("username");
				String userpassword = request.getParameter("userpassword");
				User user = new User(username, userpassword);
				int i = UserDao.addUser(user);
				if (i == 1) {
					System.out.println("更改成功");
				} else {
					System.out.println("更改失败");
				}
				request.setAttribute(username, userpassword);
				request.getRequestDispatcher("display.user").forward(request,
						response);
			}

			if (url.equals("/update.user")) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				String username = request.getParameter("username");
				String userpassword = request.getParameter("userpassword");
				int i = UserDao.updateUserPassword(username, userpassword);
				if (i == 1) {
					System.out.println("更改成功");
				} else {
					System.out.println("更改失败");
				}
				request.setAttribute(username, userpassword);
				request.getRequestDispatcher("display.user").forward(request,
						response);
			}

			if (url.equals("/del.user")) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				String username = request.getParameter("username");
				int i = UserDao.delUser(username);
				if (i == 1) {
					System.out.println("删除成功");
				} else {
					System.out.println("删除失败");
				}
				request.getRequestDispatcher("display.user").forward(request,
						response);
			}

			if (url.equals("/display.user")) {
				List<User> userList = UserDao.printAllUsers();
				request.setAttribute("userList", userList);
				request.getRequestDispatcher("/UserModify.jsp").forward(
						request, response);
			}
		}

	}

	public void init() throws ServletException {
	}

}
