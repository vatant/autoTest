package com.huawei.testng;

import org.testng.annotations.Test;

public class TimeoutTest {
    @Test(timeOut = 3000)//单位为毫秒，目标在300毫秒内完成
    public void test() throws InterruptedException{
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void test1() throws InterruptedException{
        Thread.sleep(3000);
    }
}
