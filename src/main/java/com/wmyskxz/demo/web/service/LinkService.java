package com.wmyskxz.demo.web.service;

import com.github.pagehelper.Page;
import com.wmyskxz.demo.module.entity.TblLink;
import com.wmyskxz.demo.module.vo.LinkVo;

import java.util.List;

/**
 * 链接url相关service
 *
 * @auth:wmyskxz
 * @date:2019/04/16 - 15:09
 */
public interface LinkService {

    /**
     * 保存(转换)长链接
     *
     * @param longUrl
     * @return 成功返回短链接, 不成功则null
     */
    String save(String longUrl);

    /**
     * 保存自定义短链接
     *
     * @param longUrl
     * @param shortCode
     * @return 成功返回null，不成功则返回提示信息
     */
    String save(String longUrl, String shortCode);

    /**
     * 从短链接获取长链接
     *
     * @param shortCode
     * @return 短链接对应的长链接, 没有则返回null
     */
    String get(String shortCode);

    /**
     * 通过长链接找到相应数据
     *
     * @param longUrl
     * @return
     */
    TblLink findByLongUrl(String longUrl);

    /**
     * 判断短链接是否合法(是否已经存在)
     *
     * @param shortUrl
     * @return
     */
    Boolean isValid(String shortUrl);

    /**
     * 根据短链接增加访问量
     *
     * @param shortUrl
     */
    void addVisitByShortUrl(String shortUrl);


    /**
     * 返回数据库中的Link列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<LinkVo> list(int pageNum, int pageSize);

    /**
     * 统计总数
     *
     * @return
     */
    Long count();

}
