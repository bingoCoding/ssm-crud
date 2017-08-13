package com.lp.crud.service.impl;

import com.lp.crud.bean.AccUser;
import com.lp.crud.bean.AccUserExample;
import com.lp.crud.dao.AccUserMapper;
import com.lp.crud.service.AccUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 26685 on 2017/5/19.
 */
@Service(value = "accUserService")
public class AccUserServiceImpl implements AccUserService {
    @Autowired
    private AccUserMapper accUserMapper;

    public List<AccUser> selectByExampleWithDept(AccUserExample o){
        return accUserMapper.selectByExampleWithDept(null);
    }

    public int saveUser(AccUser accUser) {
        return accUserMapper.insertSelective(accUser);
    }

}
