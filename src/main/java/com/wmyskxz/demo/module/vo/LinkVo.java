package com.wmyskxz.demo.module.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用于与前台交互的链接数据模型
 *
 * @auth:wmyskxz
 * @date:2019/04/16 - 21:14
 */
public class LinkVo implements Serializable {

    private static final long serialVersionUID = -1L;

    private String longUrl;// 长链接地址
    private String shortUrl;// 短链接地址
    private Integer visitSize;// 访问量
    private Date createTime;// 创建时间

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Integer getVisitSize() {
        return visitSize;
    }

    public void setVisitSize(Integer visitSize) {
        this.visitSize = visitSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
