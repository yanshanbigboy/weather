package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingItem implements Serializable {// 购物内容对象
	private String elem;// 客户选取的天气数据元素,包涵气温，气压，湿度，降水量，风速
	private String area;
	private String frenquency;
	private String name;
	private String company;
	private String phoneNum;
	private String email;
	private String addRequest;// 客户的其他需求

	// 存储校验不通过时给用户的错误提示信息
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
		// private String name不可以为空
		if (this.name == null || this.name.trim().equals("")) {
			isOk = false;
			errors.put("name", "姓名不能为空！！");
		}
		// private String company不可以为空

		if (this.company == null || this.company.trim().equals("")) {
			isOk = false;
			errors.put("company", "公司地址不能为空！！");
		}

		// private String phoneNum不可以为空
		if (this.phoneNum != null && !this.phoneNum.trim().equals("")) {
			if (this.phoneNum.length() != 11
					&& !this.phoneNum
							.matches("^((13[0-9])|(15[^4,\\D])|(	18[0,5-9]))\\d{8}$")) {
				isOk = false;
				errors.put("phoneNum", "输入的手机号码不合法！");
			}
		} else {
			isOk = false;
			errors.put("phoneNum", "手机号不能为空！");
		}

		// private String email不可以为空
		if (this.email != null && !this.email.trim().equals("")) {
			if (!this.email
					.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
				isOk = false;
				errors.put("email", "输入的邮箱地址不合法！");
			}
		} else {
			isOk = false;
			errors.put("email", "邮箱不能为空！");
		}
		return isOk;
	}
}