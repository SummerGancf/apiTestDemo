package com.demo.test.testdemo;

import com.demo.base.HttpRespones;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by GanCF on 2017/3/21.
 */
public class TestQuery {

    @Test
    public void test_Query_Succ(){
        String url = "http://localhost:8080/projectAll/query";
        String result = "";
        try {
            HttpRespones httpRespones = new HttpRespones();
            result = httpRespones.getHttpRespone(url);
            System.out.print(result);
            Assert.assertEquals(result,"[{\"date\":1486656000000,\"projectid\":9,\"projectname\":\"myttel\"},{\"date\":1482940800000,\"projectid\":8,\"projectname\":\"SearchMgmt\"},{\"date\":1478620800000,\"projectid\":7,\"projectname\":\"gh\"},{\"date\":1478620800000,\"projectid\":6,\"projectname\":\"account\"},{\"date\":1478620800000,\"projectid\":5,\"projectname\":\"TradeMgmt\"},{\"date\":1478620800000,\"projectid\":4,\"projectname\":\"MsgGW\"},{\"date\":1478620800000,\"projectid\":3,\"projectname\":\"myt\"},{\"date\":1478620800000,\"projectid\":2,\"projectname\":\"UserMgmt\"},{\"date\":1478448000000,\"projectid\":1,\"projectname\":\"baseinfo\"}]");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void test_Query_Fail(){
        String url = "http://localhost:8080/projectAll/query";
        String result = "";
        try {
            HttpRespones httpRespones = new HttpRespones();
            result = httpRespones.getHttpRespone(url);
            System.out.print(result);
            Assert.assertEquals(result,"[{\"date\":1486656000001,\"projectid\":9,\"projectname\":\"myttel\"},{\"date\":1482940800000,\"projectid\":8,\"projectname\":\"SearchMgmt\"},{\"date\":1478620800000,\"projectid\":7,\"projectname\":\"gh\"},{\"date\":1478620800000,\"projectid\":6,\"projectname\":\"account\"},{\"date\":1478620800000,\"projectid\":5,\"projectname\":\"TradeMgmt\"},{\"date\":1478620800000,\"projectid\":4,\"projectname\":\"MsgGW\"},{\"date\":1478620800000,\"projectid\":3,\"projectname\":\"myt\"},{\"date\":1478620800000,\"projectid\":2,\"projectname\":\"UserMgmt\"},{\"date\":1478448000000,\"projectid\":1,\"projectname\":\"baseinfo\"}]");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
