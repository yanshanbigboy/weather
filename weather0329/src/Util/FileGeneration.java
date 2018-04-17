package Util;

import org.junit.Test;

public class FileGeneration {
	// 生成txt文件
	public static String generateHead(String[] elem) {
		String str = "";
		for (int i = 0; i < elem.length; i++) {
			str = str + elem[i] + "\t\t";
		}
		str = str + "\n";
		return str;
	}

	@Test
	public void Test() {
		String[] elem = { "beijing", "tianjin" };
		String str = FileGeneration.generateHead(elem);
		System.out.println("str:");
		System.out.println(str);
	}
}
