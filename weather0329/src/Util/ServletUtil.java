package Util;

import junit.framework.Assert;

import org.junit.Test;

public class ServletUtil {
	/**
	 * 将String数组转换成为字符串，原数组中的每个元素用","连接,数组为空则返回null.
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
			// 前length-1个后面有逗号，最后一个即下标为length-1的元素没有逗号
			for (int i = 0; i < length - 1; i++) {
				str = str + arr[i] + ",";
			}
			str += arr[length - 1];
			return str;
		}
	}

	@Test
	// 测试revert()方法
	public void testRevert() {
		String strarr[] = { "beijing", "tianjin" };
		String strtest = ServletUtil.revert(strarr);
		Assert.assertEquals("beijing,tianjin", strtest);
	}

}