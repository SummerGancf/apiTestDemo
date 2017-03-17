package com.demo.base;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;

/**
 * Created by GanCF on 2017/3/15.
 */
public class Diff {

    private static Logger logger = Logger.getLogger(Diff.class);
    /*
     * @author GanCF
     * @param 响应数据 1 相应数据 2
     */
    public static void JsonDiff(String JsonString1,String JsonString2){
        ArrayList<String> key=Common.getKeyValue(JsonString1);
        logger.info("Diff  -  key  -  value1  -  value2");
        Reporter.log("<---测试结果--->");
        Reporter.log("比较响应数据  - 参数  -  请求1参数值  -  请求1参数值");
        Reporter.log("Diff  -  key  -  value1  -  value2");
        for(String tmp:key){
//			System.out.println(tmp+"\n");
            String JsonId1=Common.getJsonValue(JsonString1, tmp);
            String JsonId2=Common.getJsonValue(JsonString2, tmp);

            //判断是否为jsonarray
            if(JsonId1.subSequence(0, 1).equals("[")){
                System.out.println("---------------------");
                JSONArray JsonArray1=Common.getJsonArrayValue(JsonString1, tmp);
                JSONArray JsonArray2=Common.getJsonArrayValue(JsonString2, tmp);
//				System.out.print(JsonArray1.length());
                //循环比较数组中的每个json
                for(int i=0;i<JsonArray1.length();i++){
                    ArrayList<String> key1=Common.getKeyValueForJsonArray(JsonArray1,i);
                    for(String tmp1:key1){
                        System.out.println(tmp1+"\n" );
                        String JsonId1_1=Common.getJsonValueForJsonArray(JsonArray1, tmp1,i);
                        String JsonId2_1=Common.getJsonValueForJsonArray(JsonArray2, tmp1,i);
                        Reporter.log("assert - "+tmp1 +" - "+JsonId1_1 +" - "+JsonId2_1);
                        Assert.assertEquals(JsonId1_1,JsonId2_1);
                    }
                }
            }else{
                Reporter.log("assert - "+tmp +" - "+JsonId1 +" - "+JsonId2);
                Assert.assertEquals(JsonId1,JsonId2);
            }
        }
    }

}
