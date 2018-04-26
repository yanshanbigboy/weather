package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Util.DBUtil;
import bean.Message;
import bean.Reply;
import bean.User;
import dao.MessageDao;
import dao.ReplyDao;

public class MessageAdd extends HttpServlet {
	public MessageAdd() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String path = request.getContextPath();
		System.out.println("path==" + path);
		String url = request.getServletPath();
		System.out.println("url==" + url);

		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {

			if (url.equals("/query.message")) {
				MessageDao dao = new MessageDao();
				List<Message> messageList = dao.printMessage();
				request.setAttribute("messageList", messageList);
				request.getRequestDispatcher("Messageboard.jsp").forward(
						request, response);
			}
			if (url.equals("/add.message")) {

				User user = (User) session.getAttribute("user");
				System.out.println(user.getUserName());
				String name = user.getUserName();
				String content = request.getParameter("content");
				System.out.println("姓名" + name + "内容" + content);
				Message msg = new Message(name, content);
				int count1 = MessageDao.addMessage(msg);
				if (count1 == 1) {
					System.out.println("添加留言板成功");
				} else {
					System.out.println("添加留言板失败");
				}
				Reply reply = new Reply("", "");
				ReplyDao.addReply((DBUtil.getNextId("message", "send_id")) - 1,
						reply);
				RequestDispatcher rd = request
						.getRequestDispatcher("query.message");
				rd.forward(request, response);
			}
			if (url.equals("/addreply.message")) {

				int sendId = Integer.parseInt(request.getParameter("send_id"));
				String reply_Content = request.getParameter("reply_Content");
				System.out.println("reply_Content" + reply_Content);
				User user = (User) request.getSession().getAttribute("user");
				String reply_name = user.getUserName();
				Reply reply = new Reply(reply_name, reply_Content);
				int count = ReplyDao.addReply(sendId, reply);
				if (count == 1) {
					System.out.println("添加回复成功");
				} else {
					System.out.println("添加回复失败");
				}
				request.getRequestDispatcher("query.message").forward(request,
						response);
			}
		} else {
			String message = String
					.format("您还没有以用户身份登录，请先登录。<br><br>自动跳转到登录页面<meta http-equiv='refresh' content='5;url=%s'/>",
							request.getContextPath() + "/login.ui");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/pattern/Message.jsp").forward(
					request, response);
		}
	}
}
