package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpClientConnectionOperator;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MycookiesForPost {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.url");
        String testurl = this.url+uri;

        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        this.store = client.getCookieStore();
        List<Cookie> cookieList= store.getCookies();

        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies name = " + name
            + "; cookies value =" + value);
        }

    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod(){
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = this.url + uri;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(testUrl);

        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age",18);

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setParams(entity);

        String result;
        client.setCookieStore(this.store);

        HttpResponse response = client.execute(post);

        result = EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println(result);

        JSONObject resultJson = new JSONObject(result);

        String success = (String) resultJson.get("huhansan");
        String status = (String) resultJson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }


}
