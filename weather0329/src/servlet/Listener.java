package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.User;

public class Listener extends HttpServlet {

	public Listener() {
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

		if (url.equals("/logout.listener")) {
			HttpSession session = request.getSession();
			if ((session.getAttribute("user")) != null) {
				User user = (User) session.getAttribute("user");
				// 获取application对象
				ServletContext application = session.getServletContext();
				List<OnlineUserBindingListener> onlineUserList = (List<OnlineUserBindingListener>) application
						.getAttribute("onlineUserList");
				if (onlineUserList != null) {
					System.out.println("onlineUserList!=null");
				}
				Iterator<OnlineUserBindingListener> it = onlineUserList
						.iterator();
				while (it.hasNext()) {
					OnlineUserBindingListener onlineUser = it.next();
					if (onlineUser.getName().equals(user.getUserName())) {
						it.remove();
					}
				}
				session.removeAttribute("user");
				// 不要使用session.invalidate();全部数据丢失
				response.sendRedirect("home.jsp");
			}
			if ((session.getAttribute("admin")) != null) {
				Admin admin = (Admin) session.getAttribute("admin");
				session.invalidate();
				response.sendRedirect("home.jsp");
			}
		}
	}

	public void init() throws ServletException {
	}

}
