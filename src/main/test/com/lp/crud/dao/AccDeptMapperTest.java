package com.lp.crud.dao;

import com.lp.crud.bean.AccDept;
import com.lp.crud.bean.AccUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 26685 on 2017/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccDeptMapperTest {

    @Autowired
    private AccDeptMapper accDeptMapper;

    @Autowired
    private SqlSession sqlSession;
    /**
     * 插入记录
     */
    @Test
    public void insertDept(){
        accDeptMapper.insertSelective(new AccDept("A",Long.valueOf(0),"0000"));
    }

    /**
     * 批量插入记录
     * 1.在application中配置批量插入bean sqlSession
     *
     */
    @Test
    public void batchInsertDept(){
        AccDeptMapper accDeptMapper=sqlSession.getMapper(AccDeptMapper.class);
        int var=65;
        for (int i=0;i<5;i++){
            accDeptMapper.insertSelective(new AccDept(""+((char)(++var)),Long.valueOf(1),"000"+i));
        }
    }
    @Test
    public void batchInsertUser(){
        AccUserMapper ccUserMapper=sqlSession.getMapper(AccUserMapper.class);
        String [] names={"张三","里斯","王五","赵六","田七"};
        Long [] deptId={(long)1,(long)2,(long)2,(long)3,(long)3};
        for (int i=0;i<5;i++){
            ccUserMapper.insertSelective(new AccUser(names[i],"admin",deptId[i]));
        }
    }
}
