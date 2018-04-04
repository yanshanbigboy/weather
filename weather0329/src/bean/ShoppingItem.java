package bean;

import java.io.Serializable;

public class ShoppingItem implements Serializable {// �������ݶ���
	private String elem;// �ͻ�ѡȡ����������Ԫ��,�������£���ѹ��ʪ�ȣ���ˮ��������
	private User user;
	private String phoneNum;
	private String email;
	private String addRequest;// �ͻ�����������

	public ShoppingItem() {
		super();
	}

	public ShoppingItem(String elem, User user, String phoneNum, String email,
			String addRequest) {
		super();
		this.elem = elem;
		this.user = user;
		this.phoneNum = phoneNum;
		this.email = email;
		this.addRequest = addRequest;
	}

	public String getAddRequest() {
		return addRequest;
	}

	public void setAddRequest(String addRequest) {
		this.addRequest = addRequest;
	}

	public String getElem() {
		return elem;
	}

	public void setElem(String elem) {
		this.elem = elem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}