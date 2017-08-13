package com.lp.crud.service.impl;

import com.lp.crud.bean.AccDept;
import com.lp.crud.bean.AccDeptExample;
import com.lp.crud.dao.AccDeptMapper;
import com.lp.crud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 26685 on 2017/5/31.
 */
@Service(value = "deptService")
public class DeptServiceImpl implements DeptService {

    @Resource
    private AccDeptMapper accDeptMapper;

    public List<AccDept> getDepts(AccDeptExample o) {
        return accDeptMapper.selectByExample(null);
    }
}
