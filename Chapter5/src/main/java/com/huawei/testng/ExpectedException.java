package com.huawei.testng;

import org.testng.annotations.Test;

public class ExpectedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeException(){

        System.out.println("This is an exception");
        throw new RuntimeException();
    }
}
