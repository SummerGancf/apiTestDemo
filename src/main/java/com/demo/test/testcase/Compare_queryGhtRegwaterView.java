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
 * 
 * @author GanCF
 *
 */
public class Compare_queryGhtRegwaterView {
	private static Logger logger=Logger.getLogger(Compare_queryGhtRegwaterView.class);
	public String httpResult1= null,httpResult2= null;
	public static String method="GET";
	public static String url="http://10.0.1.2:8080/WSGW/rest?";
	public static String Api1="SolrRegwater.SolrService.queryGhtRegwaterAll";
	public static String Api2="SolrRegwater.SolrService.queryGhtRegwaterView";
	public static HttpRespones queryGhtRegwaterAll=new HttpRespones();
	public static HttpRespones queryGhtRegwaterView=new HttpRespones();
	JSONObject Param1=new JSONObject();
	JSONObject Param2=new JSONObject();
	/**
	 * 
	 * @author GanCF
	 *
	 */
	@Test(groups = { "BaseCase"})
	public void compare_queryGhtRegwaterAll_queryGhtRegwaterView() throws IOException{
		try {
			Param1.put("tag", 1);
			Param1.put("start", 0);
			Param1.put("limit", 10);
			Param1.put("ghthospitalid", 31);
			Param1.put("ghthosdeptid", 545);			
			Reporter.log("【正常用例】:");
			queryGhtRegwaterAll.seturl(url);
			httpResult1=queryGhtRegwaterAll.getHttpRespone(Api1,Param1,method);
			Reporter.log("请求1地址: "+queryGhtRegwaterAll.geturl());
	        Reporter.log("返回结果1: "+httpResult1);
	        Param2.put("tag", 1);
			Param2.put("start", 0);
			Param2.put("limit", 10);
			Param2.put("ghthospitalid", 31);
			Param2.put("ghthosdeptid", 545);
			queryGhtRegwaterView.seturl(url);
			httpResult2=queryGhtRegwaterView.getHttpRespone(Api2,Param2,method);
			Reporter.log("请求2地址: "+queryGhtRegwaterView.geturl());
	        Reporter.log("返回结果2: "+httpResult2);
	        Diff.JsonDiff(httpResult1,httpResult2);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
