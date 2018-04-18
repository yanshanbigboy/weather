package Util;

import junit.framework.Assert;

import org.junit.Test;

public class StringUtil {
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
		String strtest = StringUtil.revert(strarr);
		Assert.assertEquals("beijing,tianjin", strtest);
	}

	// ������ʡ��ת���ɶ�Ӧ�ı���
	public static String ProRevert(String pre) {
		if (pre.equals("����"))
			return "beijing";
		if (pre.equals("�ӱ�"))
			return "hebei";
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
		if (pre.equals("����"))
			return "henan";
		return null;
	}

	public static String ProReRevert(String pre) {
		if (pre.equals("heilongjiang"))
			return "������";
		if (pre.equals("zhejiang"))
			return "�㽭";
		if (pre.equals("yunnan"))
			return "����";
		if (pre.equals("xinjiang"))
			return "�½�";
		if (pre.equals("xizang"))
			return "����";
		if (pre.equals("tianjin"))
			return "���";
		if (pre.equals("sichuan"))
			return "�Ĵ�";
		if (pre.equals("shanxixi"))
			return "����";
		if (pre.equals("shanxi"))
			return "ɽ��";
		if (pre.equals("shanghai"))
			return "�Ϻ�";
		if (pre.equals("shandong"))
			return "ɽ��";
		if (pre.equals("qinghai"))
			return "�ຣ";
		if (pre.equals("ningxia"))
			return "����";
		if (pre.equals("neimenggu"))
			return "���ɹ�";
		if (pre.equals("liaoning"))
			return "����";
		if (pre.equals("jilin"))
			return "����";
		if (pre.equals("jiangxi"))
			return "����";
		if (pre.equals("jiangsu"))
			return "����";
		if (pre.equals("hunan"))
			return "����";
		if (pre.equals("hubei"))
			return "����";
		if (pre.equals("guizhou"))
			return "����";
		if (pre.equals("guangxi"))
			return "����";
		if (pre.equals("guangdong"))
			return "�㶫";
		if (pre.equals("gansu"))
			return "����";
		if (pre.equals("fujian"))
			return "����";
		if (pre.equals("chongqing"))
			return "����";
		if (pre.equals("anhui"))
			return "����";
		if (pre.equals("beijing"))
			return "����";
		if (pre.equals("hebei"))
			return "�ӱ�";
		if (pre.equals("hainan"))
			return "����";
		if (pre.equals("henan"))
			return "����";
		return null;
	}

	public static String revertProChi(String[] area) {
		String str = "";
		for (int i = 0; i < area.length - 1; i++) {
			str = str + "province='" + ProReRevert(area[i]) + "' or ";
		}
		str = str + "province='" + ProReRevert(area[area.length - 1]) + "'";
		return str;
	}

	@Test
	public void test() {
		String[] area = { "beijing", "tianjin" };
		String str = revertProChi(area);
		System.out.println("result==" + str);
	}
}