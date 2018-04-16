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

		// ��ȡServletPath
		String url = request.getServletPath();
		// ��ȡContextPath
		String path = request.getContextPath();
		System.out.println("url====" + url);
		System.out.println("path====" + path);
		// Servlet����·��ƥ��

		if (session.getAttribute("admin") == null
				&& session.getAttribute("user") == null) {
			String message = String
					.format("����û�е�¼�����ȵ�¼���Զ���ת����¼����<meta http-equiv='refresh' content='2;url=%s'/>",
							request.getContextPath() + "/login.ui");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/pattern/Message.jsp").forward(
					request, response);
		} else if (session.getAttribute("admin") == null) {
			String message = String
					.format("����û���Թ���Ա��ݵ�¼������ע�����Թ���Ա��ݵ�¼���Զ���ת����ҳ<meta http-equiv='refresh' content='3;url=%s'/>",
							request.getContextPath() + "/home.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/pattern/Message.jsp").forward(
					request, response);
		} else {// ��֤ͨ���� ǰ���ǲ�����ͬʱ�й���Ա���û�������ͬһ��Session��(��¼���Ѿ�����������)

			if (url.equals("/add.user")) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				String username = request.getParameter("username");
				String userpassword = request.getParameter("userpassword");
				User user = new User(username, userpassword);
				int i = UserDao.addUser(user);
				if (i == 1) {
					System.out.println("���ĳɹ�");
				} else {
					System.out.println("����ʧ��");
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
					System.out.println("���ĳɹ�");
				} else {
					System.out.println("����ʧ��");
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
					System.out.println("ɾ���ɹ�");
				} else {
					System.out.println("ɾ��ʧ��");
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
