package com.wmyskxz.demo.module.dao;

import com.wmyskxz.demo.module.entity.TblLink;
import com.wmyskxz.demo.module.entity.TblLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblLinkMapper {
    long countByExample(TblLinkExample example);

    int deleteByExample(TblLinkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblLink record);

    int insertSelective(TblLink record);

    List<TblLink> selectByExample(TblLinkExample example);

    TblLink selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblLink record, @Param("example") TblLinkExample example);

    int updateByExample(@Param("record") TblLink record, @Param("example") TblLinkExample example);

    int updateByPrimaryKeySelective(TblLink record);

    int updateByPrimaryKey(TblLink record);
}