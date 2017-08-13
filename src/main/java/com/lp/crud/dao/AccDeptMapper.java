package com.lp.crud.dao;

import com.lp.crud.bean.AccDept;
import com.lp.crud.bean.AccDeptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccDeptMapper {
    int countByExample(AccDeptExample example);

    int deleteByExample(AccDeptExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccDept record);

    int insertSelective(AccDept record);

    List<AccDept> selectByExample(AccDeptExample example);

    AccDept selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccDept record, @Param("example") AccDeptExample example);

    int updateByExample(@Param("record") AccDept record, @Param("example") AccDeptExample example);

    int updateByPrimaryKeySelective(AccDept record);

    int updateByPrimaryKey(AccDept record);
}