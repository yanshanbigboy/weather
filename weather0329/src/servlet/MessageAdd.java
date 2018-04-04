package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Message;
import dao.MessageDao;

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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		// String name=request.getParameter("name");
		String name = (String) session.getAttribute("name");
		String content = request.getParameter("content");
		System.out.println("–’√˚" + name + "ƒ⁄»›" + content);
		int telephone = Integer.parseInt(request.getParameter("telephone"));
		String email = request.getParameter("email");
		Message msg = new Message(name, content, telephone, email);
		int count1 = MessageDao.addMessage(msg);
		if (count1 == 1) {
			System.out.println("ÃÌº”¡Ù—‘∞Â≥…π¶");
		} else {
			System.out.println("ÃÌº”¡Ù—‘∞Â ß∞‹");
		}
		RequestDispatcher rd = request.getRequestDispatcher("Messboard.jsp");
		rd.forward(request, response);
	}

}
