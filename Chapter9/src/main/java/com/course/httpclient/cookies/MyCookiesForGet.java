package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.cookie.Cookie;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        HttpGet get =new HttpGet(this.url+bundle.getString("test.url"));
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);


        CookieStore store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies name=" + name +
            "cookies value=" + value );
        }

        HttpPost post = new HttpPost(this.url);
        StringEntity entity= new StringEntity(param.toSring())
        post.setEntity();


    }
}
