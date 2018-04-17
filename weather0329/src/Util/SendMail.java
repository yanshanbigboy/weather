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

public class SendMail extends Thread {// �����ʼ���һ����ʱ���£�������һ���߳��෢���ʼ�
	private String from = "vyumin@163.com";// ���ڸ��û������ʼ�������
	private String username = "vyumin";// ������û���

	private String password = "200271400";// ���������

	private ShoppingItem item;

	public SendMail(ShoppingItem item) {
		this.item = item;
	}

	public ShoppingItem getItem() {
		return item;
	}

	public void setItem(ShoppingItem item) {
		this.item = item;
	}

	public void run() {
		try {

			// ����
			Session session = Session.getDefaultInstance(new Properties());

			// �ʼ�
			MimeMessage msg = new MimeMessage(session);
			// ��������
			msg.setSubject("ɽ���ƾ���ѧ���������������������");
			// �����ˣ�ע�����ĵĴ���
			msg.setFrom(new InternetAddress("\""
					+ MimeUtility.encodeText("ɽ���ƾ���ѧ�������������")
					+ "\"<vyumin@163.com>"));

			// �����ʼ���MINE��Ϣ��
			MimeMultipart msgMultipart = new MimeMultipart("mixed");// ��ϵ���Ϲ�ϵ
			// �����ʼ���MINE��Ϣ��
			msg.setContent(msgMultipart);

			// ����1
			MimeBodyPart attch1 = new MimeBodyPart();
			// ����2
			// MimeBodyPart attch2 = new MimeBodyPart();
			// ��������
			MimeBodyPart content = new MimeBodyPart();

			// �����ݣ�����1������2���뵽 MINE��Ϣ����
			msgMultipart.addBodyPart(attch1);
			// msgMultipart.addBodyPart(attch2);
			msgMultipart.addBodyPart(content);

			// ���ļ�����ӵ�����1��
			// ����Դ
			DataSource ds1 = new FileDataSource(new File("C:/demo/demo.txt"));
			// ���ݴ�����
			DataHandler dh1 = new DataHandler(ds1);
			// ���õ�һ������������
			attch1.setDataHandler(dh1);
			// ���õ�һ���������ļ���
			attch1.setFileName("file1.txt");

			// ���ļ�����ӵ�����2��
			// DataSource ds2 = new FileDataSource(new File(
			// "C:/Users/H__D/Desktop/2.txt"));
			// DataHandler dh2 = new DataHandler(ds2);
			// attch2.setDataHandler(dh2);
			// attch2.setFileName(MimeUtility.encodeText("�ļ�2.jpg"));

			// ���ģ�ͼƬ�����ֲ��֣�
			MimeMultipart bodyMultipart = new MimeMultipart("related");
			// ��������Ϊ����
			content.setContent(bodyMultipart);

			// html���벿��
			MimeBodyPart htmlPart = new MimeBodyPart();
			// html��Ƕ�׵�ͼƬ����
			// MimeBodyPart imgPart = new MimeBodyPart();

			// �������ͼƬ��html����
			bodyMultipart.addBodyPart(htmlPart);
			// bodyMultipart.addBodyPart(imgPart);

			// ���ļ�����ӵ�ͼƬ��
			// DataSource imgds = new FileDataSource(new File(
			// "C:/Users/H__D/Desktop/logo.png"));
			// DataHandler imgdh = new DataHandler(imgds);
			// imgPart.setDataHandler(imgdh);
			// ˵��html�е�img��ǩ��src�����õ��Ǵ�ͼƬ
			// imgPart.setHeader("Content-Location",
			// "http://sunteam.cc/logo.jsg");

			// html����
			htmlPart.setContent(
					"<span style='color:red'>��л������ɽ���ƾ���ѧ������������ĵ��������ݣ�������Ҫ��ֱ����������ϵ��</span>",
					"text/html;charset=utf-8");

			// �����ļ��ʼ�
			msg.saveChanges();

			// ���
			OutputStream os = new FileOutputStream("C:/demo/demo.eml");
			msg.writeTo(os);
			os.close();

			// ���Զ���
			Properties properties = new Properties();
			// ����debug���� ����ӡ��Ϣ
			properties.setProperty("mail.debug", "true");
			// ���ͷ�������Ҫ�����֤
			properties.setProperty("mail.smtp.auth", "true");
			// ���ͷ������˿ڣ����Բ����ã�Ĭ����25
			properties.setProperty("mail.smtp.port", "25");
			// �����ʼ�Э������
			properties.setProperty("mail.transport.protocol", "smtp");
			// �����ʼ�������������
			properties.setProperty("mail.host", "smtp.163.com");
			// ������Ϣ
			session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// ��session�������˻���Ϣ��Transport�����ʼ�ʱ��ʹ��,�������˻�������Ȩ���룬��������������
					return new PasswordAuthentication(username, "18746ajq13");
				}
			});

			// ��ȡ�����ʼ�
			Message message = new MimeMessage(session, new FileInputStream(
					new File("C:/demo/demo.eml")));

			// �����ʼ�
			Transport.send(message, InternetAddress.parse(item.getEmail()));

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
