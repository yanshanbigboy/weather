package Util;

import junit.framework.Assert;

import org.junit.Test;

public class ServletUtil {
	/**
	 * ��String����ת����Ϊ�ַ�����ԭ�����е�ÿ��Ԫ����","����,����Ϊ���򷵻�null.
	 * 
	 * @param arr
	 * @return
	 */
	public static String revert(String[] arr) {
		String str = "";
		if (arr == null) {
			return null;
		} else {
			int length = arr.length;
			// ǰlength-1�������ж��ţ����һ�����±�Ϊlength-1��Ԫ��û�ж���
			for (int i = 0; i < length - 1; i++) {
				str = str + arr[i] + ",";
			}
			str += arr[length - 1];
			return str;
		}
	}

	@Test
	// ����revert()����
	public void testRevert() {
		String strarr[] = { "beijing", "tianjin" };
		String strtest = ServletUtil.revert(strarr);
		Assert.assertEquals("beijing,tianjin", strtest);
	}

	// ������ʡ��ת���ɶ�Ӧ�ı���
	public static String ProRevert(String pre) {
		if (pre.equals("����"))
			return "beijing";
		if (pre.equals("����"))
			return "anhui";
		if (pre.equals("����"))
			return "chongqing";
		if (pre.equals("����"))
			return "fujian";
		if (pre.equals("����"))
			return "gansu";
		if (pre.equals("�㶫"))
			return "guangdong";
		if (pre.equals("����"))
			return "guangxi";
		if (pre.equals("����"))
			return "guizhou";
		if (pre.equals("����"))
			return "hainan";
		if (pre.equals("����"))
			return "hubei";
		if (pre.equals("����"))
			return "hunan";
		if (pre.equals("����"))
			return "jiangsu";
		if (pre.equals("����"))
			return "jiangxi";
		if (pre.equals("����"))
			return "jilin";
		if (pre.equals("����"))
			return "liaoning";
		if (pre.equals("���ɹ�"))
			return "neimenggu";
		if (pre.equals("����"))
			return "ningxia";
		if (pre.equals("�ຣ"))
			return "qinghai";
		if (pre.equals("ɽ��"))
			return "shandong";
		if (pre.equals("�Ϻ�"))
			return "shanghai";
		if (pre.equals("ɽ��"))
			return "shanxi";
		if (pre.equals("����"))
			return "shanxixi";
		if (pre.equals("�Ĵ�"))
			return "sichuan";
		if (pre.equals("���"))
			return "tianjin";
		if (pre.equals("����"))
			return "xizang";
		if (pre.equals("�½�"))
			return "xinjiang";
		if (pre.equals("����"))
			return "yunnan";
		if (pre.equals("�㽭"))
			return "zhejiang";
		if (pre.equals("������"))
			return "heilongjiang";
		return null;
	}
}