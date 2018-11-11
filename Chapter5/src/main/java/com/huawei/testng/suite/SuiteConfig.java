package com.huawei.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite run");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite run");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("suitebeforetest");
    }

    @AfterTest
    public void aftertest(){
        System.out.println(" suiteaftertest");
    }

}
