package com.lp.crud.dao;

import com.lp.crud.bean.AccRole;
import com.lp.crud.bean.AccRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccRoleMapper {
    int countByExample(AccRoleExample example);

    int deleteByExample(AccRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccRole record);

    int insertSelective(AccRole record);

    List<AccRole> selectByExample(AccRoleExample example);

    AccRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccRole record, @Param("example") AccRoleExample example);

    int updateByExample(@Param("record") AccRole record, @Param("example") AccRoleExample example);

    int updateByPrimaryKeySelective(AccRole record);

    int updateByPrimaryKey(AccRole record);
}