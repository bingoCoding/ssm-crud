package com.lp.crud.dao;

import com.lp.crud.bean.AccUser;
import com.lp.crud.bean.AccUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccUserMapper {
    int countByExample(AccUserExample example);

    int deleteByExample(AccUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccUser record);

    int insertSelective(AccUser record);

    List<AccUser> selectByExample(AccUserExample example);
    List<AccUser> selectByExampleWithDept(AccUserExample example);

    AccUser selectByPrimaryKey(Long id);
    AccUser selectByPrimaryKeyWithDept(Long id);

    int updateByExampleSelective(@Param("record") AccUser record, @Param("example") AccUserExample example);

    int updateByExample(@Param("record") AccUser record, @Param("example") AccUserExample example);

    int updateByPrimaryKeySelective(AccUser record);

    int updateByPrimaryKey(AccUser record);
}