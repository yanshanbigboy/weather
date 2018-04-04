package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDao;

import bean.Message;

public class MessageAdd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MessageAdd() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//String name=request.getParameter("name");
		String name=(String)session.getAttribute("name");
		String content=request.getParameter("content");
		System.out.println("–’√˚"+name+"ƒ⁄»›"+content);	
		int telephone=Integer.parseInt(request.getParameter("telephone"));
        String email=request.getParameter("email");
		Message msg=new Message(name,content,telephone,email);
		int count1=MessageDao.addMessage(msg);
		if(count1==1){
			System.out.println("ÃÌº”¡Ù—‘∞Â≥…π¶");
		}else{
			System.out.println("ÃÌº”¡Ù—‘∞Â ß∞‹");
		}
		RequestDispatcher rd=request.getRequestDispatcher("Messboard.jsp");
		rd.forward(request, response);
	}

}
