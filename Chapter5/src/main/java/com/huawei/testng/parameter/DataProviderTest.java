package com.huawei.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name ,int age){
        System.out.println("name=" + name + "age=" + age);
    }

    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhangsan",10},
                {"lisi",20}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void Test1(String name ,int age){
        System.out.println("Test1 method name= "+name+"age="+age);
    }

    @Test(dataProvider = "methodData")
    public void Test2(String name ,int age){
        System.out.println("Test2 method name= "+name+"age="+age);
    }

    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result=null;
        if(method.getName().equals("Test1")){
            result = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",40}
            };

        }else if(method.getName().equals("Test2")){
          result = new Object[][]{
                  {"wangwu",15},
                  {"zhaoliu",45}
          };
        }
        return result;
    }
}
