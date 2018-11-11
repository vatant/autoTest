package com.huawei.testng;

import org.testng.annotations.*;

public class basicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("testcase1");
    }

    @Test
    public void testCase2(){
        System.out.println("testcase2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是测试方法之后运行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在类运行之前运行的方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是类运行之后运行的方法");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Beforesuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
}
