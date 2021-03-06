package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import bean.ShoppingItem;

public class SendMail extends Thread {// 发送邮件是一件耗时的事，因此设计一个线程类发送邮件
	private String from = "vyumin@163.com";// 用于给用户发送邮件的邮箱
	private ShoppingItem item;
	private String fileAddress;
	private int price;
	private String picPath;

	public SendMail(ShoppingItem item, String fileAddress, int price,
			String picPath) {
		super();
		this.item = item;
		this.fileAddress = fileAddress;
		this.price = price;
		this.picPath = picPath;
	}

	public ShoppingItem getItem() {
		return item;
	}

	public void setItem(ShoppingItem item) {
		this.item = item;
	}

	public void run() {
		try {

			// 环境
			Session session = Session.getDefaultInstance(new Properties());

			// 邮件
			MimeMessage msg = new MimeMessage(session);
			// 设置主题
			msg.setSubject("山东财经大学气象大数据中心气象数据");
			// 发件人，注意中文的处理
			msg.setFrom(new InternetAddress("\""
					+ MimeUtility.encodeText("山东财经大学气象大数据中心")
					+ "\"<vyumin@163.com>"));
			msg.addRecipients(Message.RecipientType.CC,
					InternetAddress.parse(item.getEmail()));
			// 整封邮件的MINE消息体
			MimeMultipart msgMultipart = new MimeMultipart("mixed");// 混合的组合关系
			// 设置邮件的MINE消息体
			msg.setContent(msgMultipart);

			// 附件1
			MimeBodyPart attch1 = new MimeBodyPart();
			// 附件2
			// MimeBodyPart attch2 = new MimeBodyPart();
			// 正文内容
			MimeBodyPart content = new MimeBodyPart();

			// 把内容，附件1，附件2加入到 MINE消息体中
			msgMultipart.addBodyPart(attch1);
			// msgMultipart.addBodyPart(attch2);
			msgMultipart.addBodyPart(content);

			// 把文件，添加到附件1中
			// 数据源
			DataSource ds1 = new FileDataSource(new File(fileAddress));
			// 数据处理器
			DataHandler dh1 = new DataHandler(ds1);
			// 设置第一个附件的数据
			attch1.setDataHandler(dh1);
			// 设置第一个附件的文件名
			attch1.setFileName("data.xls");

			// 把文件，添加到附件2中
			// DataSource ds2 = new FileDataSource(new File(
			// "C:/Users/H__D/Desktop/2.txt"));
			// DataHandler dh2 = new DataHandler(ds2);
			// attch2.setDataHandler(dh2);
			// attch2.setFileName(MimeUtility.encodeText("文件2.jpg"));

			// 正文（图片和文字部分）
			MimeMultipart bodyMultipart = new MimeMultipart("related");
			// 设置内容为正文
			content.setContent(bodyMultipart);

			// html代码部分
			MimeBodyPart htmlPart = new MimeBodyPart();
			// html中嵌套的图片部分
			MimeBodyPart imgPart = new MimeBodyPart();

			// 正文添加图片和html代码
			bodyMultipart.addBodyPart(htmlPart);
			bodyMultipart.addBodyPart(imgPart);

			// 把文件，添加到图片中
			DataSource imgds = new FileDataSource(new File(picPath));
			DataHandler imgdh = new DataHandler(imgds);
			imgPart.setDataHandler(imgdh);
			// 说明html中的img标签的src，引用的是此图片
			imgPart.setHeader("Content-Location",
					"http://localhost:8080/weather0328/pay.jpg");

			// html代码
			htmlPart.setContent(
					"<span style='color:red'>您所订购的数据共计"
							+ price
							+ "元，请直接扫描屏幕上的二维码支付。感谢您购买山东财经大学气象大数据中心的气象数据，如有其他需要请直接与我们联系。</span><img src=\"http://localhost:8080/weather0328/pay.jpg\">",
					"text/html;charset=utf-8");

			// 生成文件邮件
			msg.saveChanges();

			// 输出
			OutputStream os = new FileOutputStream("E:/demo/demo.eml");
			msg.writeTo(os);
			os.close();

			// 属性对象
			Properties properties = new Properties();
			// 开启debug调试 ，打印信息
			properties.setProperty("mail.debug", "true");
			// 发送服务器需要身份验证
			properties.setProperty("mail.smtp.auth", "true");
			// 发送服务器端口，可以不设置，默认是25
			properties.setProperty("mail.smtp.port", "25");
			// 发送邮件协议名称
			properties.setProperty("mail.transport.protocol", "smtp");
			// 设置邮件服务器主机名
			properties.setProperty("mail.host", "smtp.163.com");
			// 环境信息
			session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// 在session中设置账户信息，Transport发送邮件时会使用,这里是账户名和授权密码，而不是邮箱密码
					return new PasswordAuthentication(from, "18746ajq13");
				}
			});

			// 读取本地邮件
			Message message = new MimeMessage(session, new FileInputStream(
					new File("E:/demo/demo.eml")));

			// 发送邮件
			Transport.send(message, message.getAllRecipients());
			// Transport transport = session.getTransport("smtp");
			// transport.send(msg, msg.getAllRecipients());
			// transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
