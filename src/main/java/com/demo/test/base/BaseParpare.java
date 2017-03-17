package com.demo.test.base;

import com.demo.utils.ExcelDataProvider;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Iterator;

public class BaseParpare {
	
	/**
	 * 测试数据提供者 - 方法
	 * */
	@DataProvider(name = "testData")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = null; // 模块的名字  为类名的(****_ ###) ****  作为excel的名字
		String caseNum = null; // 用例编号  ### 最为 excel中 sheet的名字
		String className = this.getClass().getName();
		int dotIndexNum = className.indexOf("."); // 取得第一个.的index
		int dotlastIndexOf = className.lastIndexOf(".");// 取得最后一个.的index
//		System.out.println(className);
		int underlineIndexNum = className.indexOf("_"); // 取得第一个_的index

		if (dotIndexNum > 0) {	
			moduleName = className.substring(dotlastIndexOf+1, underlineIndexNum); // 取到模块的名称
//			System.out.println(moduleName);
		}

		if (underlineIndexNum > 0) {
			caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
//			System.out.println(caseNum);
		}
		//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum);
	}

}
