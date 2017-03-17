package com.demo.base;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by GanCF on 2017/3/15.
 */
public class Common {

    /*
	 * 解析json
	 * eg: {"Code":10000,"Message":"成功","Result":[{"areaId":396,"areaName":"东胜区"},
	 * 			{"areaId":397,"areaName":"达拉特旗"},{"areaId":398,"areaName":"准格尔旗"},
	 *			 {"areaId":399,"areaName":"鄂托克前旗"},{"areaId":400,"areaName":"鄂托克旗"},
	 *			{"areaId":401,"areaName":"杭锦旗"},{"areaId":402,"areaName":"乌审旗"},
	 *			{"areaId":403,"areaName":"伊金霍洛旗"}]}
	 *getJsonValue:可获取Code，Message
	 *getJsonArrayValue:获取整个Result  json数组
	 *getJsonValueForJsonArray：获取Result中json的值 并指定第几个  getJsonValueForJsonArray(Result,areaId,1) 则返回的为 第二个areaId=397
	 */
    public static String getJsonValue(String JsonString, String JsonId) {
        String JsonValue = "";
        if (JsonString == null || JsonString.trim().length() < 1) {
            return null;
        }
        try {
            JSONObject obj1 = new JSONObject(JsonString);
            JsonValue = (String) obj1.getString(JsonId);
        } catch (JSONException e) {
            Assert.fail("缺少出参: "+JsonId);
//        	Reporter.log("缺少出参: "+JsonId);
            e.printStackTrace();
        }
        return JsonValue;
    }
    /*
     * 从响应信息 json 里面获取里面的json数组
     *
     */
    public static JSONArray getJsonArrayValue(String JsonString, String JsonId) {
        JSONArray JsonArrayValue =null;
        if (JsonString == null || JsonString.trim().length() < 1) {
            return null;
        }
        try {
            JSONObject obj2 = new JSONObject(JsonString);
            JsonArrayValue = (JSONArray) obj2.getJSONArray(JsonId);
        } catch (JSONException e) {
            Assert.fail("缺少出参: "+JsonId);
//        	Reporter.log("缺少出参: "+JsonId);
            e.printStackTrace();
        }
        return JsonArrayValue;
    }
    /*
     * 从json数组里面获取第几个的json
     *
     */
    public static String getJsonValueForJsonArray(JSONArray JsonArray, String JsonId,int index) {
        String JsonValue = "";
        if (JsonArray == null || JsonArray.length() < 1) {
            return null;
        }
        try {
            String JsonString=JsonArray.getString(index);
            JSONObject obj3 = new JSONObject(JsonString);
            JsonValue = (String) obj3.getString(JsonId);
        } catch (JSONException e) {
            Assert.fail("缺少出参: "+JsonId);
//        	Reporter.log("缺少出参: "+JsonId);
            e.printStackTrace();
        }
        return JsonValue;
    }

    /*
     *  提取 响应数据里面的key值
     *
     */
    public static ArrayList<String> getKeyValue(String JsonString){
        ArrayList<String> keyList = new ArrayList<String>();

        String key="";
//		int i=0;
        try {
            JSONObject obj= new JSONObject(JsonString);
            Iterator it = obj.keys();
            while (it.hasNext()) {
                key= (String)it.next().toString();
                keyList.add(key);
//	            System.out.print(keyList);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return keyList;

    }
    /*
     * jsonarray 里面获取key值
     */
    public static ArrayList<String> getKeyValueForJsonArray(JSONArray JsonArray,int index){
        ArrayList<String> keyList = new ArrayList<String>();

        String key="";
//		int i=0;
        try {
            String JsonString=JsonArray.getString(index);
            JSONObject obj= new JSONObject(JsonString);
            Iterator it = obj.keys();
            while (it.hasNext()) {
                key= (String)it.next().toString();
                keyList.add(key);
//	            System.out.print(keyList);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return keyList;

    }

}
