package com.wmyskxz.demo.module.entity;

import java.util.Date;

public class TblLink {
    private Long id;

    private String longUrl;

    private String shortUrl;

    private Date createTime;

    private Date updateTime;

    private String type;

    private Integer visitSize;

    public TblLink(Long id, String longUrl, String shortUrl, Date createTime, Date updateTime, String type, Integer visitSize) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.type = type;
        this.visitSize = visitSize;
    }

    public TblLink() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl == null ? null : longUrl.trim();
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl == null ? null : shortUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getVisitSize() {
        return visitSize;
    }

    public void setVisitSize(Integer visitSize) {
        this.visitSize = visitSize;
    }
}