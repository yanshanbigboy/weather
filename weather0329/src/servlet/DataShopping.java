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

		// ��ȡJsp�ύ������
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
		// ��String����ת�����ַ���
		String strElem = ServletUtil.revert(elem);
		String strArea = ServletUtil.revert(area);
		String strFrequency = ServletUtil.revert(frequency);
		// ����ShoppingItem����
		ShoppingItem item = new ShoppingItem(strElem, strArea, strFrequency,
				name, company, phone, email, other);

		// ���û������䷢���ʼ�
		SendMail send = new SendMail(item);
		send.start();
		String message = "��ϲ����ע��ɹ��������Ѿ�����һ�����ע����Ϣ�ĵ����ʼ�������գ����û���յ�������������ԭ�򣬹�һ������յ��ˣ���";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/Message.jsp").forward(request, response);
		// ��֤���ݵĺϷ���(��װ��ShoppingItem�����еķ���)

		/*
		 * if (item.validate() != false) {// ���ݺ�����֤ͨ�� // д�����ݿ�Ĺ���� // int count
		 * = ShoppingItemDao.addItem(item); } else {//
		 * ��֤��ͨ��,��ԭ���������ת����ShoppingViewҳ�� request.setAttribute("ShoppingItem",
		 * item);
		 * request.getRequestDispatcher("/ShoppingView.jsp").forward(request,
		 * response); }
		 */
	}

	public void init() throws ServletException {
	}

}
