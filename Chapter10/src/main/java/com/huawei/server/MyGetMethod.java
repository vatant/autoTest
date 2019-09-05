package com.huawei.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyGetMethod {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(){
        return "get";
    }
}

