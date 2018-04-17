package Util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import bean.ShoppingItem;

public class SendMail extends Thread {// �����ʼ���һ����ʱ���£�������һ���߳��෢���ʼ�
	private String from = "vyumin@163.com";// ���ڸ��û������ʼ�������
	private String username = "vyumin";// ������û���

	private String password = "200271400";// ���������
	private String host = "smtp.163.com";// 163����smtp�������ĵ�ַ

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

			// ȷ������λ��
			Properties prop = new Properties();
			// ��ȡ163����smtp�������ĵ�ַ
			prop.setProperty("mail.host", host);
			prop.setProperty("mail.transport.protocol", "smtp");
			// �Ƿ����Ȩ����֤
			prop.setProperty("mail.smtp.auth", "true");

			// 0.2ȷ��Ȩ�ޣ��˺ź����룩
			Authenticator authenticator = new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					// ��д�Լ���163����ĵ�¼�ʺź���Ȩ���룬��Ȩ����Ļ�ȡ���ں������н��⡣
					// return new PasswordAuthentication("vyumin@163.com",
					// "��Ȩ��");
					return new PasswordAuthentication("vyumin@163.com",
							"18746ajq13");
				}
			};

			// 1 �������
			/**
			 * props������������Ϣ�Ķ���Properties���� ���������������ַ�������Ƿ����Ȩ����֤(�ʺ�������֤)��
			 * 
			 * authenticator��ȷ��Ȩ��(�ʺź�����)
			 * 
			 * ���Ծ�Ҫ�����湹������������
			 */

			Session session = Session.getDefaultInstance(prop, authenticator);
			// 2 ������Ϣ
			Message message = new MimeMessage(session);
			// 2.1 ������ xxx@163.com �����Լ��������ַ����������
			message.setFrom(new InternetAddress("vyumin@163.com"));
			/**
			 * 2.2 �ռ��� ��һ�������� RecipientType.TO �����ռ��� RecipientType.CC ����
			 * RecipientType.BCC ���� ����AҪ��B���ʼ�������A�����б�Ҫ��Ҫ��CҲ���������ݣ����ڸ�B���ʼ�ʱ��
			 * ���ʼ����ݳ��͸�C����ôCҲ�ܿ����������ˣ�����BҲ��֪��A��C���͹��÷��ʼ�
			 * ������ǰ���(����)��C�Ļ�����ôB�Ͳ�֪��A��C���͹��÷��ʼ��� �ڶ�������
			 * �ռ��˵ĵ�ַ��������һ��Address[]������װ���ͻ��߰����˵���������������Ⱥ������������ͬ����������ģ�Ҳ�����ǲ�ͬ��
			 * �������Ƿ��͸����ǵ�qq����
			 */

			message.setRecipient(RecipientType.TO,
					new InternetAddress(item.getEmail()));
			// 2.3 ���⣨���⣩
			message.setSubject("ɽ���ƾ���ѧ�������������");
			// 2.4 ����
			String str = "Deer "
					+ item.getName()
					+ "�� <br/>"
					+ "It is an great honor to receive your data purchasing intention.Please inform us if there is any mistake in the form you fill in��<br/>"
					+ "����Ԫ�أ�" + item.getElem() + "<br/>������" + item.getArea();
			// ���ñ��룬��ֹ���͵������������롣
			message.setContent(str, "text/html;charset=UTF-8");

			// 3������Ϣ
			Transport.send(message);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	// ����ѡӢ�ı�����ת���ɶ�Ӧ����������

}
