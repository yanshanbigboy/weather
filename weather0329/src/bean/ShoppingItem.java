package bean;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ShoppingItem implements Serializable {// 购物内容对象
	private String elem;// 客户选取的天气数据元素,包涵气温，气压，湿度，降水量，风速
	private String area;// 客户选取的地区，陕西(shanxixi)
	private String frequency;// 频次
	private String name;
	private String company;
	private String phoneNum;
	private String email;
	private String addRequest;// 客户的其他需求
	// 存储错误提示用的Map,key为错误类型，value为错误提示
	private Map<String, String> errors = new HashMap<String, String>();

	public ShoppingItem() {
		super();
	}

	public ShoppingItem(String elem, String area, String frequency,
			String name, String company, String phoneNum, String email,
			String addRequest) {
		super();
		this.elem = elem;
		this.area = area;
		this.frequency = frequency;
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

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
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

	/**
	 * 校验ShoppingItem对象的数据是否合法
	 * 
	 * @return
	 */
	public boolean validate() {
		// 设置标志初始为true
		boolean isOk = true;

		// private String elem不可以为空
		if (this.elem == null || this.elem.trim().equals("")) {
			isOk = false;
			errors.put("elem", "数据元素不能为空！！");
		}

		// private String area不可以为空
		if (this.area == null || this.area.trim().equals("")) {
			isOk = false;
			errors.put("area", "地区不能为空！！");
		}

		// private String frequency不可以为空
		if (this.frequency == null || this.frequency.trim().equals("")) {
			isOk = false;
			errors.put("frequency", "频次不能为空！！");
		}

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

		// private String addRequest可以为空,但是数据库该字段为varchar(255),因此要限制输入的汉字的字符数
		try {
			if ((this.addRequest.getBytes("utf-8").length) > 255) {
				errors.put("addRequest", "输入的其他需求过长！");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			errors.put("addRequest", "输入的其他需求有错误，请联系管理员");
		}

		return isOk;
	}
}