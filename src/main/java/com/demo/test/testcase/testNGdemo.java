package com.demo.test.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by GanCF on 2017/3/21.
 */
public class testNGdemo {
    @BeforeClass
    public void setUp(){
        System.out.print("The test method is beforclass\n");
    }
    @Test
    public void test1(){
        System.out.print("The test method is test\n");
    }
    @AfterClass
    public void tearDown(){
        System.out.print("The test method is afterclass");
    }
}
