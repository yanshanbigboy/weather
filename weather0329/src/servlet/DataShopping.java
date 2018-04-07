package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.SendMail;
import Util.ServletUtil;
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
		System.out.println("path==" + path);
		String url = request.getServletPath();
		System.out.println("url==" + url);

		// 获取Jsp提交的数据
		String[] elem = request.getParameterValues("elements");
		String[] area = request.getParameterValues("area");
		String[] frequency = request.getParameterValues("frequency");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		String email = request.getParameter("email");
		String other = request.getParameter("other");
		// 将String数组转换成字符串
		String strElem = ServletUtil.revert(elem);
		String strArea = ServletUtil.revert(area);
		String strFrequency = ServletUtil.revert(frequency);
		// 生成ShoppingItem对象
		ShoppingItem item = new ShoppingItem(strElem, strArea, strFrequency,
				name, company, phone, email, other);

		// 给用户的邮箱发送邮件
		SendMail send = new SendMail(item);
		send.start();
		String message = "恭喜您，注册成功，我们已经发了一封带了注册信息的电子邮件，请查收，如果没有收到，可能是网络原因，过一会儿就收到了！！";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/Message.jsp").forward(request, response);
		// 验证数据的合法性(封装在ShoppingItem对象中的方法)

		/*
		 * if (item.validate() != false) {// 数据合理，验证通过 // 写入数据库的购物表 // int count
		 * = ShoppingItemDao.addItem(item); } else {//
		 * 验证不通过,将原对象的数据转发回ShoppingView页面 request.setAttribute("ShoppingItem",
		 * item);
		 * request.getRequestDispatcher("/ShoppingView.jsp").forward(request,
		 * response); }
		 */
	}

	public void init() throws ServletException {
	}

}
