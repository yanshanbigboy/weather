package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.SendMail;
import Util.StringUtil;
import bean.ShoppingItem;
import dao.ShoppingItemDao;
import dao.WeatherDao;

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
		String strElem = StringUtil.revert(elem);
		String strArea = StringUtil.revert(area);
		String strFrequency = StringUtil.revert(frequency);
		// ����ShoppingItem����
		ShoppingItem item = new ShoppingItem(strElem, strArea, strFrequency,
				name, company, phone, email, other);

		// ��֤���ݵĺϷ���(��װ��ShoppingItem�����еķ���)
		if (item.validate() != false) {

			// ���ж�Ƶ��
			if (strFrequency.equals("eachMonth")) {
				// ���ݺ�����֤ͨ�� д�����ݿ�Ĺ����
				ShoppingItemDao itemDao = new ShoppingItemDao();
				int count = itemDao.addItem(item);
				// ���յ����û������ѯ���ݿ�(����Ӧ�����߼�ҵ��㣬�ж��û���������Ͳ�����һ����)
				// ���ɵ�����ѯ�����xls�ļ���ַ
				String fileAddress = "E://"
						+ Integer.toString((itemDao.getMaxId() + 1)) + ".xls";
				// ��Ҫ���ѯ�������ݱ����ɵ�ַ
				WeatherDao.priProWeaByElem(area, strElem, fileAddress);
				// ���û������䷢���ʼ�����Я���и����ɵ�xls�ļ��ĸ���
				SendMail send = new SendMail(item, fileAddress);
				send.start();
				// ���ͳɹ�
				String message = "��ϲ��������ɹ��������Ѿ���������Ҫ���������ʼ�����ʽ���͵����������У�����ա����û���յ�������������ԭ�������ĵȴ���";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/pattern/Message.jsp").forward(
						request, response);
			} else if (strFrequency.equals("eachYear")) {
				// ���ݺ�����֤ͨ�� д�����ݿ�Ĺ����
				ShoppingItemDao itemDao = new ShoppingItemDao();
				int count = itemDao.addItem(item);
				// ���ɵ�����ѯ�����xls�ļ���ַ
				String fileAddress = "E://"
						+ Integer.toString((itemDao.getMaxId() + 1)) + ".xls";
				// ��Ҫ���ѯavg_year�����ɵ�ַ
				WeatherDao.printAvgYearWeather(strElem, area, fileAddress);
				// ���û������䷢���ʼ�����Я���и����ɵ�xls�ļ��ĸ���
				SendMail send = new SendMail(item, fileAddress);
				send.start();
				// ���ͳɹ�
				String message = "��ϲ����ע��ɹ��������Ѿ�����һ�����ע����Ϣ�ĵ����ʼ�������գ����û���յ�������������ԭ�򣬹�һ������յ��ˣ���";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/pattern/Message.jsp").forward(
						request, response);
			} else {// ��ѡ������eachMonth����eachYear�����ظ�ִ��eachMonth��eachYear
				ShoppingItem item1 = item;
				item.setFrequency("eachMonth");
				item1.setFrequency("eachYear");
				System.out.println("item.fre==" + item.getFrequency());
				System.out.println("item1.fre==" + item1.getFrequency());
				// ���ݺ�����֤ͨ�� д�����ݿ�Ĺ����
				ShoppingItemDao itemDao = new ShoppingItemDao();
				itemDao.addItem(item);
				// ���ɵ�����ѯ�����xls�ļ���ַ
				String fileAddress = "E://"
						+ Integer.toString((itemDao.getMaxId() + 1)) + ".xls";
				// ��Ҫ���ѯ�������ݱ����ɵ�ַ
				WeatherDao.priProWeaByElem(area, strElem, fileAddress);
				System.out.println("fileAddress ==" + fileAddress);
				try {
					// ���û������䷢���ʼ�����Я���и����ɵ�xls�ļ��ĸ���
					SendMail send = new SendMail(item, fileAddress);
					send.start();
					SendMail.sleep(4000);
					send.join();
					// ��֤ͨ�� д�����ݿ�Ĺ����
					itemDao.addItem(item1);
					// ���ɵ�����ѯ�����xls�ļ���ַ
					String fileAddress1 = "E://"
							+ Integer.toString((itemDao.getMaxId() + 1))
							+ ".xls";
					System.out.println("fileAddress1==" + fileAddress1);
					// ��Ҫ���ѯavg_year�����ɵ�ַ
					WeatherDao.printAvgYearWeather(strElem, area, fileAddress1);
					// ���û������䷢���ʼ�����Я���и����ɵ�xls�ļ��ĸ���
					SendMail send1 = new SendMail(item, fileAddress1);
					send1.start();

					// ���ͳɹ�
					String message = "��ϲ����ע��ɹ��������Ѿ�����һ�����ע����Ϣ�ĵ����ʼ�������գ����û���յ�������������ԭ�򣬹�һ������յ��ˣ���";
					request.setAttribute("message", message);
					request.getRequestDispatcher("/pattern/Message.jsp")
							.forward(request, response);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			// ��֤��ͨ��,��ԭ���������ת����ShoppingViewҳ��
			request.setAttribute("ShoppingItem", item);
			request.getRequestDispatcher("/ShoppingView.jsp").forward(request,
					response);
		}
	}

	public void init() throws ServletException {
	}

}
