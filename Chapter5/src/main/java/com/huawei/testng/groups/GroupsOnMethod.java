package com.huawei.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("server group test1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("server group test2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("server client test3");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("server client test4");
    }

    @BeforeGroups("client")
    public void beforeGroupOnserver(){
        System.out.println("method before group test");
    }

    @AfterGroups("client")
    public void afterGroupOnserver(){
        System.out.println("method After group test");
    }
}
