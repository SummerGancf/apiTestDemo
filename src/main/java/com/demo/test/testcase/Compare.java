package com.demo.test.testcase;

import com.demo.base.Diff;
import com.demo.base.HttpRespones;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;

/**
 * @author GanCF
 */
public class Compare {
	private static Logger logger=Logger.getLogger(Compare.class);
	public String httpResult1= null,httpResult2= null;
	public static String method="GET";
	public static String url="http://service.yihu.com:8085/WSGW/rest?";
	public static String Api="baseinfo.CommonApi.getAreaByCity";
	public static HttpRespones getAreaByCity=new HttpRespones();
	JSONObject Param1=new JSONObject();
	JSONObject Param2=new JSONObject();
	/**
	 * @author GanCF
	 */
	@Test(groups = { "BaseCase"})
	public void compare_getAreaByCity_Succ() throws IOException{
		try {
			Param1.put("cityId", 32);
			Reporter.log("【正常用例】:");
			httpResult1=getAreaByCity.getHttpRespone(Api,Param1,method);
			Reporter.log("请求1地址: "+getAreaByCity.geturl());
	        Reporter.log("返回结果1: "+httpResult1);
	        Param2.put("cityId", 32);
			httpResult2=getAreaByCity.getHttpRespone(Api,Param2,method);
			Reporter.log("请求2地址: "+getAreaByCity.geturl());
	        Reporter.log("返回结果2: "+httpResult2);
	        Diff.JsonDiff(httpResult1,httpResult2);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author GanCF
	 */
	@Test(groups = { "BaseCase"})
	public void compare_getAreaByCity_Fail() throws IOException{
		try {
			Param1.put("cityId", 32);
			Reporter.log("【正常用例】:");
			httpResult1=getAreaByCity.getHttpRespone(Api,Param1,method);
			Reporter.log("请求1地址: "+getAreaByCity.geturl());
	        Reporter.log("返回结果1: "+httpResult1);
	        Param2.put("cityId", 31);
			httpResult2=getAreaByCity.getHttpRespone(Api,Param2,method);
			Reporter.log("请求2地址: "+getAreaByCity.geturl());
	        Reporter.log("返回结果2: "+httpResult2);
	        Diff.JsonDiff(httpResult1,httpResult2);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
