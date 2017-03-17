package com.demo.utils;

import com.demo.base.Common;
import com.demo.base.HttpRespones;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;

public class HttpAction {
	public static Logger logger = Logger.getLogger(HttpAction.class.getName());

	public static String httpResult = null, expect = null, Code = null;
	public static JSONArray Result = null;
	public static String method = "GET";
	public static HttpRespones httpResponse;

	/**
	 * @author GanCF
	 * @param Api
	 * @param Param
	 * @param expect
	 * 			String Api = data.get("Api");
	 *          JSONObject  Param = new JSONObject().put("Param", data.get("Param"));
	 *          String expect=data.get("expect");
	 */
	public static  void httpForExcel(String Api, JSONObject Param, String expect){
		try {
	
			httpResponse = new HttpRespones();

			Reporter.log("【正常用例】:获取" + Api + "成功");
			httpResponse.seturl("http://172.19.0.26/WSGW/rest?");
			httpResult = httpResponse.getHttpRespone(Api, Param, method);
			Reporter.log("请求地址: " + httpResponse.geturl());
			Reporter.log("返回结果: " + httpResult);
			Code = Common.getJsonValue(httpResult, "Code");
			Reporter.log("用例结果: resultCode=>expected: " + expect
					+ " ,actual: " + Code);
			Assert.assertEquals(Code, expect);
		} catch (IOException e) {
			Assert.fail("httpForExcel:IOException");
			e.printStackTrace();
		} 
	}

}
