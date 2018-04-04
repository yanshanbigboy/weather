package bean;

import java.io.Serializable;

public class ShoppingItem implements Serializable {// �������ݶ���
	private String elem;// �ͻ�ѡȡ����������Ԫ��,�������£���ѹ��ʪ�ȣ���ˮ��������
	private String area;
	private String frenquency;
	private String name;
	private String company;
	private String phoneNum;
	private String email;
	private String addRequest;// �ͻ�����������

	public ShoppingItem() {
		super();
	}

	public ShoppingItem(String elem, String area, String frenquency,
			String name, String company, String phoneNum, String email,
			String addRequest) {
		super();
		this.elem = elem;
		this.area = area;
		this.frenquency = frenquency;
		this.name = name;
		this.company = company;
		this.phoneNum = phoneNum;
		this.email = email;
		this.addRequest = addRequest;
	}

	public String getElem() {
		return elem;
	}

	public void setElem(String elem[]) {

	}

	public void setElem(String elem) {
		this.elem = elem;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFrenquency() {
		return frenquency;
	}

	public void setFrenquency(String frenquency) {
		this.frenquency = frenquency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getAddRequest() {
		return addRequest;
	}

	public void setAddRequest(String addRequest) {
		this.addRequest = addRequest;
	}

}