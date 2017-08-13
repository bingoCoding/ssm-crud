package com.lp.crud.service;

import com.lp.crud.bean.AccUser;
import com.lp.crud.bean.AccUserExample;

import java.util.List;

/**
 * Created by 26685 on 2017/5/19.
 */
public interface AccUserService {

    List<AccUser> selectByExampleWithDept(AccUserExample o);

    int saveUser(AccUser accUser);
}
