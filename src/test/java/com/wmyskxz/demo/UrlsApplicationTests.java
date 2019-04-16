package com.wmyskxz.demo;

import com.wmyskxz.demo.config.UrlConfig;
import com.wmyskxz.demo.module.entity.TblLink;
import com.wmyskxz.demo.web.service.LinkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlsApplicationTests {

    @Autowired LinkService linkService;

    @Test
    //使用Redis缓存对象，get()只会被调用一次
    public void testCache() {
        String longUrl;
        longUrl = linkService.get("123456");// 123456是提前存入数据库的shortCode代码
        longUrl = linkService.get("123456");
        longUrl = linkService.get("123456");
    }

}
