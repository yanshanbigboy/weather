package Util;

import junit.framework.Assert;

import org.junit.Test;

public class StringUtil {
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
		String strtest = StringUtil.revert(strarr);
		Assert.assertEquals("beijing,tianjin", strtest);
	}

	// 将汉字省份转换成对应的表名
	public static String ProRevert(String pre) {
		if (pre.equals("北京"))
			return "beijing";
		if (pre.equals("河北"))
			return "hebei";
		if (pre.equals("安徽"))
			return "anhui";
		if (pre.equals("重庆"))
			return "chongqing";
		if (pre.equals("福建"))
			return "fujian";
		if (pre.equals("甘肃"))
			return "gansu";
		if (pre.equals("广东"))
			return "guangdong";
		if (pre.equals("广西"))
			return "guangxi";
		if (pre.equals("贵州"))
			return "guizhou";
		if (pre.equals("海南"))
			return "hainan";
		if (pre.equals("湖北"))
			return "hubei";
		if (pre.equals("湖南"))
			return "hunan";
		if (pre.equals("江苏"))
			return "jiangsu";
		if (pre.equals("江西"))
			return "jiangxi";
		if (pre.equals("吉林"))
			return "jilin";
		if (pre.equals("辽宁"))
			return "liaoning";
		if (pre.equals("内蒙古"))
			return "neimenggu";
		if (pre.equals("宁夏"))
			return "ningxia";
		if (pre.equals("青海"))
			return "qinghai";
		if (pre.equals("山东"))
			return "shandong";
		if (pre.equals("上海"))
			return "shanghai";
		if (pre.equals("山西"))
			return "shanxi";
		if (pre.equals("陕西"))
			return "shanxixi";
		if (pre.equals("四川"))
			return "sichuan";
		if (pre.equals("天津"))
			return "tianjin";
		if (pre.equals("西藏"))
			return "xizang";
		if (pre.equals("新疆"))
			return "xinjiang";
		if (pre.equals("云南"))
			return "yunnan";
		if (pre.equals("浙江"))
			return "zhejiang";
		if (pre.equals("黑龙江"))
			return "heilongjiang";
		if (pre.equals("河南"))
			return "henan";
		return null;
	}

	public static String ProReRevert(String pre) {
		if (pre.equals("heilongjiang"))
			return "黑龙江";
		if (pre.equals("zhejiang"))
			return "浙江";
		if (pre.equals("yunnan"))
			return "云南";
		if (pre.equals("xinjiang"))
			return "新疆";
		if (pre.equals("xizang"))
			return "西藏";
		if (pre.equals("tianjin"))
			return "天津";
		if (pre.equals("sichuan"))
			return "四川";
		if (pre.equals("shanxixi"))
			return "陕西";
		if (pre.equals("shanxi"))
			return "山西";
		if (pre.equals("shanghai"))
			return "上海";
		if (pre.equals("shandong"))
			return "山东";
		if (pre.equals("qinghai"))
			return "青海";
		if (pre.equals("ningxia"))
			return "宁夏";
		if (pre.equals("neimenggu"))
			return "内蒙古";
		if (pre.equals("liaoning"))
			return "辽宁";
		if (pre.equals("jilin"))
			return "吉林";
		if (pre.equals("jiangxi"))
			return "江西";
		if (pre.equals("jiangsu"))
			return "江苏";
		if (pre.equals("hunan"))
			return "湖南";
		if (pre.equals("hubei"))
			return "湖北";
		if (pre.equals("guizhou"))
			return "贵州";
		if (pre.equals("guangxi"))
			return "广西";
		if (pre.equals("guangdong"))
			return "广东";
		if (pre.equals("gansu"))
			return "甘肃";
		if (pre.equals("fujian"))
			return "福建";
		if (pre.equals("chongqing"))
			return "重庆";
		if (pre.equals("anhui"))
			return "安徽";
		if (pre.equals("beijing"))
			return "北京";
		if (pre.equals("hebei"))
			return "河北";
		if (pre.equals("hainan"))
			return "海南";
		if (pre.equals("henan"))
			return "河南";
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