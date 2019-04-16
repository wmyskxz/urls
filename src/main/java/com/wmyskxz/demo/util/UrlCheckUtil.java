package com.wmyskxz.demo.util;

import com.wmyskxz.demo.config.UrlConfig;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网址检查合法性工具
 *
 * @auth:wmyskxz
 * @date:2019/04/16 - 16:57
 */
public class UrlCheckUtil {
    /**
     * 简单判断是否为有效的长链：
     * 1.不以http://或https://开头的地址为非法
     *
     * @param url
     * @return
     */
    public static Boolean isValidLongUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            return false;
        }

        return true;
    }

    /**
     * 简单判断是否为有效的短链：
     * 1.不以UrlConfig中定义的BASE_URL开头的地址为非法
     * 2.这里简单的认为地址(scheme/authority/path/query/fragment)中path有6位的就为短链
     *
     * @param shortUrl
     * @return
     */
    public static Boolean isValidShortUrl(String shortUrl) {
        if (!shortUrl.startsWith(UrlConfig.BASE_SHORT_URL)) {
            return false;
        }   // end if

        URL url = null;
        try {
            url = new URL(shortUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // path因为要去掉一个'/r/'字符,所以这里需要做substring处理
        if (url.getPath().substring(3).length() != 6) {
            return false;
        }   // end if

        return true;
    }
}
