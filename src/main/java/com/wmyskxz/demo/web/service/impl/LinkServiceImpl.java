package com.wmyskxz.demo.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wmyskxz.demo.config.UrlConfig;
import com.wmyskxz.demo.module.dao.TblLinkMapper;
import com.wmyskxz.demo.module.entity.TblLink;
import com.wmyskxz.demo.module.entity.TblLinkExample;
import com.wmyskxz.demo.module.vo.LinkVo;
import com.wmyskxz.demo.util.ConstCode;
import com.wmyskxz.demo.util.ShortUrlGenerator;
import com.wmyskxz.demo.web.service.LinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkService实现类
 *
 * @auth:wmyskxz
 * @date:2019/04/16 - 15:13
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Resource TblLinkMapper linkMapper;

    @Override
    @Transactional// 开启事务
    public String save(String longUrl) {
        TblLink link = findByLongUrl(longUrl);
        if (link != null) {
            // 如果数据库中已经存在相应的数据
            return link.getShortUrl();
        } else {
            // 数据库中不存在对应的数据
            link = new TblLink();
            link.setLongUrl(longUrl);
            link.setShortUrl(UrlConfig.BASE_SHORT_URL + ShortUrlGenerator.gererateShortUrl(longUrl));
            linkMapper.insertSelective(link);// 其他字段使用数据库默认值
        }
        return link.getShortUrl();
    }

    @Override
    @Transactional// 开启事务
    public String save(String longUrl, String shortCode) {

        if (!isValid(UrlConfig.BASE_SHORT_URL + shortCode)) {
            // shortUrl已经存在则直接返回提示信息
            return "短链代码已经存在!";
        }   // end if

        TblLink link = new TblLink();
        link.setLongUrl(longUrl);
        link.setShortUrl(UrlConfig.BASE_SHORT_URL + shortCode);// 前端保证shortUrl的合法性
        link.setType(ConstCode.LINK_CUSTOM_TYPE);
        linkMapper.insertSelective(link);// 其他字段使用数据库默认值
        return null;
    }

    @Override
    @Transactional// 开启事务
    @Cacheable(value = "link", key = "'short2long_'+#shortCode")
    public String get(String shortCode) {
        TblLinkExample linkExample = new TblLinkExample();
        linkExample.or().andShortUrlEqualTo(UrlConfig.BASE_SHORT_URL + shortCode);
        List<TblLink> resultList = linkMapper.selectByExample(linkExample);
        if (resultList.isEmpty()) {
            // 如果没有数据则null
            return null;
        }   // end if
        return resultList.get(0).getLongUrl();// 可能存在多条数据,返回第一条,简单去重
    }

    @Override
    @Transactional// 开启事务
    @Cacheable(value = "link", key = "'link_'+#longUrl")
    public TblLink findByLongUrl(String longUrl) {
        TblLinkExample linkExample = new TblLinkExample();
        linkExample.or().andLongUrlEqualTo(longUrl);
        List<TblLink> linkList = linkMapper.selectByExample(linkExample);
        if (linkList.isEmpty()) {
            return null;
        }
        return linkList.get(0);
    }

    @Override
    @Transactional// 开启事务
    public Boolean isValid(String shortUrl) {
        TblLinkExample linkExample = new TblLinkExample();
        linkExample.or().andShortUrlEqualTo(shortUrl);
        return linkMapper.selectByExample(linkExample).isEmpty();
    }

    @Override
    @Transactional// 开启事务
    public void addVisitByShortUrl(String shortUrl) {
        // 能访问该方法说明shortUrl已存在
        TblLinkExample linkExample = new TblLinkExample();
        linkExample.or().andShortUrlEqualTo(shortUrl);
        TblLink link = linkMapper.selectByExample(linkExample).get(0);
        link.setVisitSize(link.getVisitSize() + 1);
        linkMapper.updateByPrimaryKeySelective(link);// 其他字段跟随数据库自动更新
    }

    @Override
    @Transactional// 开启事务
    public List<LinkVo> list(int pageNum, int pageSize) {
        List<LinkVo> resultList = new LinkedList<>();

        TblLinkExample linkExample = new TblLinkExample();
        linkExample.or();// 无条件查询即查询所有
        PageHelper.startPage(pageNum, pageSize);// 只对下一行查询有效
        List<TblLink> linkList = linkMapper.selectByExample(linkExample);

        // 拼接数据
        LinkVo linkVo;
        for (TblLink link : linkList) {
            linkVo = new LinkVo();
            BeanUtils.copyProperties(link, linkVo);
            resultList.add(linkVo);
        }   // end for

        return resultList;
    }

    @Override
    @Transactional// 开启事务
    public Long count() {
        TblLinkExample linkExample = new TblLinkExample();
        linkExample.or();// 无条件查询即查询所有
        return linkMapper.countByExample(linkExample);
    }
}
