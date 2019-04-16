package com.wmyskxz.demo;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 地址测试
 *
 * @auth:wmyskxz
 * @date:2019/04/16 - 17:09
 */
public class UrlTester {
    @Test
    public void tester() {
        String urlStr = "http://localhost/r/123456?a=b";

        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println(url.getHost());  // localhost
        System.out.println(url.getAuthority());  // localhost
        System.out.println(url.getPath().substring(3));  // 123456
        System.out.println(url.getQuery());  // a=b
    }
}
