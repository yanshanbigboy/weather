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

}