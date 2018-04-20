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
		String strElem = StringUtil.revert(elem);
		String strArea = StringUtil.revert(area);
		String strFrequency = StringUtil.revert(frequency);
		// 生成ShoppingItem对象
		ShoppingItem item = new ShoppingItem(strElem, strArea, strFrequency,
				name, company, phone, email, other);

		// 验证数据的合法性(封装在ShoppingItem对象中的方法)
		if (item.validate() != false) {

			// 先判断频次
			if (strFrequency.equals("eachMonth")) {
				// 数据合理，验证通过 写入数据库的购物表
				ShoppingItemDao itemDao = new ShoppingItemDao();
				int count = itemDao.addItem(item);
				// 将收到的用户需求查询数据库(本来应该有逻辑业务层，判断用户需求，这里就不在另开一层了)
				// 生成导出查询结果的xls文件地址
				String fileAddress = "E://"
						+ Integer.toString((itemDao.getMaxId() + 1)) + ".xls";
				// 按要求查询各地数据表并生成地址
				WeatherDao.priProWeaByElem(area, strElem, fileAddress);
				// 给用户的邮箱发送邮件，并携带有该生成的xls文件的附件
				SendMail send = new SendMail(item, fileAddress);
				send.start();
				// 发送成功
				String message = "恭喜您，购买成功，我们已经将您所需要的数据以邮件的形式发送到您的邮箱中，请查收。如果没有收到，可能是网络原因，请耐心等待。";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/pattern/Message.jsp").forward(
						request, response);
			} else if (strFrequency.equals("eachYear")) {
				// 数据合理，验证通过 写入数据库的购物表
				ShoppingItemDao itemDao = new ShoppingItemDao();
				int count = itemDao.addItem(item);
				// 生成导出查询结果的xls文件地址
				String fileAddress = "E://"
						+ Integer.toString((itemDao.getMaxId() + 1)) + ".xls";
				// 按要求查询avg_year表并生成地址
				WeatherDao.printAvgYearWeather(strElem, area, fileAddress);
				// 给用户的邮箱发送邮件，并携带有该生成的xls文件的附件
				SendMail send = new SendMail(item, fileAddress);
				send.start();
				// 发送成功
				String message = "恭喜您，注册成功，我们已经发了一封带了注册信息的电子邮件，请查收，如果没有收到，可能是网络原因，过一会儿就收到了！！";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/pattern/Message.jsp").forward(
						request, response);
			} else {// 多选，既有eachMonth又有eachYear，则重复执行eachMonth和eachYear
				ShoppingItem item1 = item;
				item.setFrequency("eachMonth");
				item1.setFrequency("eachYear");
				System.out.println("item.fre==" + item.getFrequency());
				System.out.println("item1.fre==" + item1.getFrequency());
				// 数据合理，验证通过 写入数据库的购物表
				ShoppingItemDao itemDao = new ShoppingItemDao();
				itemDao.addItem(item);
				// 生成导出查询结果的xls文件地址
				String fileAddress = "E://"
						+ Integer.toString((itemDao.getMaxId() + 1)) + ".xls";
				// 按要求查询各地数据表并生成地址
				WeatherDao.priProWeaByElem(area, strElem, fileAddress);
				System.out.println("fileAddress ==" + fileAddress);
				try {
					// 给用户的邮箱发送邮件，并携带有该生成的xls文件的附件
					SendMail send = new SendMail(item, fileAddress);
					send.start();
					SendMail.sleep(4000);
					send.join();
					// 验证通过 写入数据库的购物表
					itemDao.addItem(item1);
					// 生成导出查询结果的xls文件地址
					String fileAddress1 = "E://"
							+ Integer.toString((itemDao.getMaxId() + 1))
							+ ".xls";
					System.out.println("fileAddress1==" + fileAddress1);
					// 按要求查询avg_year表并生成地址
					WeatherDao.printAvgYearWeather(strElem, area, fileAddress1);
					// 给用户的邮箱发送邮件，并携带有该生成的xls文件的附件
					SendMail send1 = new SendMail(item, fileAddress1);
					send1.start();

					// 发送成功
					String message = "恭喜您，注册成功，我们已经发了一封带了注册信息的电子邮件，请查收，如果没有收到，可能是网络原因，过一会儿就收到了！！";
					request.setAttribute("message", message);
					request.getRequestDispatcher("/pattern/Message.jsp")
							.forward(request, response);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			// 验证不通过,将原对象的数据转发回ShoppingView页面
			request.setAttribute("ShoppingItem", item);
			request.getRequestDispatcher("/ShoppingView.jsp").forward(request,
					response);
		}
	}

	public void init() throws ServletException {
	}

}
