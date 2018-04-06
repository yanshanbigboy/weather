package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingItem implements Serializable {// �������ݶ���
	private String elem;// �ͻ�ѡȡ����������Ԫ��,�������£���ѹ��ʪ�ȣ���ˮ��������
	private String area;
	private String frenquency;
	private String name;
	private String company;
	private String phoneNum;
	private String email;
	private String addRequest;// �ͻ�����������

	// �洢У�鲻ͨ��ʱ���û��Ĵ�����ʾ��Ϣ
	private Map<String, String> errors = new HashMap<String, String>();

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

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public boolean validate() {

		boolean isOk = true;
		// private String name������Ϊ��
		if (this.name == null || this.name.trim().equals("")) {
			isOk = false;
			errors.put("name", "��������Ϊ�գ���");
		}
		// private String company������Ϊ��

		if (this.company == null || this.company.trim().equals("")) {
			isOk = false;
			errors.put("company", "��˾��ַ����Ϊ�գ���");
		}

		// private String phoneNum������Ϊ��
		if (this.phoneNum != null && !this.phoneNum.trim().equals("")) {
			if (this.phoneNum.length() != 11
					&& !this.phoneNum
							.matches("^((13[0-9])|(15[^4,\\D])|(	18[0,5-9]))\\d{8}$")) {
				isOk = false;
				errors.put("phoneNum", "������ֻ����벻�Ϸ���");
			}
		} else {
			isOk = false;
			errors.put("phoneNum", "�ֻ��Ų���Ϊ�գ�");
		}

		// private String email������Ϊ��
		if (this.email != null && !this.email.trim().equals("")) {
			if (!this.email
					.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
				isOk = false;
				errors.put("email", "����������ַ���Ϸ���");
			}
		} else {
			isOk = false;
			errors.put("email", "���䲻��Ϊ�գ�");
		}
		return isOk;
	}
}