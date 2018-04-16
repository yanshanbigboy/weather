package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import bean.Admin;
import bean.User;
import dao.AdminDao;
import dao.UserDao;

public class Login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String enrolleeType = request.getParameter("enrolleeType");
		String validateCode = request.getParameter("validationCode");
		System.out.println("this is in servlet-Login" + name + password
				+ validateCode);
		HttpSession session = request.getSession();
		String validation_code = (String) session
				.getAttribute("validation_code");

		// 判断用户名和密码是否为空
		if (password != null && name != null) {
			// 如果是管理员登录
			if (enrolleeType.equals("admin")) {
				Admin admin = new Admin(name, password);
				String adminPasswordDB = AdminDao.adminLogin(admin);
				System.out.println("this is servlet_Login adminPasswordDb "
						+ adminPasswordDB);
				if (adminPasswordDB != null && adminPasswordDB.equals(password)
						&& validateCode.equalsIgnoreCase(validation_code)) {

					System.out.println("登陆成功");
					session.setAttribute("admin", admin);
					request.getRequestDispatcher("home.jsp").forward(request,
							response);
				} else if (!validateCode.equalsIgnoreCase(validation_code)) {
					System.out.println("密码正确+验证码错误");
					Object[] options = { "确定", "取消" };
					JOptionPane.showOptionDialog(null, "验证码错误", "Warning",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					request.setAttribute(name, password);
					RequestDispatcher rd = request
							.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				} else if (!adminPasswordDB.equals(password)) {
					System.out.println("密码错误+登陆失败");
					Object[] options = { "确定", "取消" };
					JOptionPane.showOptionDialog(null, "  用户名或密码错误", "警告",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					request.setAttribute(name, password);
					RequestDispatcher rd = request
							.getRequestDispatcher("home.jsp");
					rd.forward(request, response);
				} else {
					System.out.println("用户名错误+登陆失败");
					Object[] options = { "确定", "取消" };
					JOptionPane.showOptionDialog(null, "  用户名或密码错误", "警告",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					request.setAttribute(name, password);
					RequestDispatcher rd = request
							.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}

			// 如果是用户登录
			if (enrolleeType.equals("user")) {
				User user = new User(name, password);
				String userPasswordDB = UserDao.userLogin(user);
				if (userPasswordDB != null && userPasswordDB.equals(password)
						&& validateCode.equalsIgnoreCase(validation_code)) {
					System.out.println("登陆成功");
					session.setAttribute("user", user);
					session.setAttribute("onlineUserBindingListener",
							new OnlineUserBindingListener(name));

					request.getRequestDispatcher("home.jsp").forward(request,
							response);

				} else if (!validateCode.equalsIgnoreCase(validation_code)) {

					System.out.println("密码正确+验证码错误");
					Object[] options = { "确定", "取消" };
					JOptionPane.showOptionDialog(null, "  用户名或密码错误", "警告",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					request.setAttribute(name, password);
					RequestDispatcher rd = request
							.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);

				} else if (!userPasswordDB.equals(password)) {

					System.out.println("密码错误+登陆失败");
					Object[] options = { "确定", "取消" };
					JOptionPane.showOptionDialog(null, "  用户名或密码错误", "警告",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					request.setAttribute(name, password);
					RequestDispatcher rd = request
							.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);

				} else {

					System.out.println("用户名错误+登陆失败");
					Object[] options = { "确定", "取消" };
					JOptionPane.showOptionDialog(null, "  用户名或密码错误", "警告",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					request.setAttribute(name, password);
					RequestDispatcher rd = request
							.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}

		} else {
			Object[] options = { "确定", "取消" };
			JOptionPane.showOptionDialog(null, "  用户名或密码错误", "警告",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
			request.setAttribute(name, password);
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
