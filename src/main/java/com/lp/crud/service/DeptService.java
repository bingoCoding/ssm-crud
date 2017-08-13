package com.lp.crud.service;

import com.lp.crud.bean.AccDept;
import com.lp.crud.bean.AccDeptExample;

import java.util.List;

/**
 * Created by 26685 on 2017/5/31.
 */
public interface DeptService {
    List<AccDept> getDepts(AccDeptExample o);
}
