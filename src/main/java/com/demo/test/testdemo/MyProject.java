package com.demo.test.testdemo;

import com.demo.base.HttpRespones;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by GanCF on 2017/3/21.
 */
public class MyProject {
    @BeforeClass
    public void setUp(){
        System.out.print("this is setup\n");
    }
    @Test
    public void test_query_projectall_succ(){

        String url = "http://192.168.40.1:8080/projectAll/query";
        HttpRespones httpRespones = new HttpRespones();
        String result = null;
        try{
            result = httpRespones.getHttpRespone(url);
            System.out.print(result);
            Assert.assertEquals(result,"[{\"date\":1486656000000,\"projectid\":9,\"projectname\":\"myttel\"},{\"date\":1482940800000,\"projectid\":8,\"projectname\":\"SearchMgmt\"},{\"date\":1478620800000,\"projectid\":7,\"projectname\":\"gh\"},{\"date\":1478620800000,\"projectid\":6,\"projectname\":\"account\"},{\"date\":1478620800000,\"projectid\":5,\"projectname\":\"TradeMgmt\"},{\"date\":1478620800000,\"projectid\":4,\"projectname\":\"MsgGW\"},{\"date\":1478620800000,\"projectid\":3,\"projectname\":\"myt\"},{\"date\":1478620800000,\"projectid\":2,\"projectname\":\"UserMgmt\"},{\"date\":1478448000000,\"projectid\":1,\"projectname\":\"baseinfo\"}]");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void test_query_projectall_fail(){

        String url = "http://192.168.40.1:8080/projectAll/query";
        HttpRespones httpRespones = new HttpRespones();
        String result = null;
        try{
            result = httpRespones.getHttpRespone(url);
            System.out.print(result);
            Assert.assertEquals(result,"[{\"date\":14866560000001,\"projectid\":9,\"projectname\":\"myttel\"},{\"date\":1482940800000,\"projectid\":8,\"projectname\":\"SearchMgmt\"},{\"date\":1478620800000,\"projectid\":7,\"projectname\":\"gh\"},{\"date\":1478620800000,\"projectid\":6,\"projectname\":\"account\"},{\"date\":1478620800000,\"projectid\":5,\"projectname\":\"TradeMgmt\"},{\"date\":1478620800000,\"projectid\":4,\"projectname\":\"MsgGW\"},{\"date\":1478620800000,\"projectid\":3,\"projectname\":\"myt\"},{\"date\":1478620800000,\"projectid\":2,\"projectname\":\"UserMgmt\"},{\"date\":1478448000000,\"projectid\":1,\"projectname\":\"baseinfo\"}]");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
