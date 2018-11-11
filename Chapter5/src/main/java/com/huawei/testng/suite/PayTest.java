package com.huawei.testng.suite;

import org.testng.annotations.*;

public class PayTest {

    @Test
    public void paysuccess(){
        System.out.println("paysuccess !");
    }

    @Test
    public void paysuccess2(){
        System.out.println("paysuccess2 !");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("pay beforetest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("pay aftertest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在类运行之前运行的方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是类运行之后运行的方法");
    }
}
