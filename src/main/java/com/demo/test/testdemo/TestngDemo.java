package com.demo.test.testdemo;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.*;

/**
 * Created by GanCF on 2017/3/21.
 */
public class TestngDemo {

    @BeforeClass
    public void beforeclass(){
        System.out.print("this is beforeclass\n");
    }
    @BeforeMethod
    public void beforemethod(){
        System.out.print("this is beforemeteod\n");
    }
    @Test
    public void test1(){
        System.out.print("this is test1\n");
    }
    @Test
    public void test2(){
        System.out.print("this is test2\n");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.print("this is aftermethod\n");
    }
    @AfterClass
    public void afterclass(){
        System.out.print("this is aftercalss\n");
    }
}
