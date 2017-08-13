package com.lp.crud.controller;

import com.lp.crud.bean.AccDept;
import com.lp.crud.bean.Msg;
import com.lp.crud.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 26685 on 2017/5/31.
 */
@Controller
public class DeptController {

    @Resource
    private DeptService deptService;

    @RequestMapping(value = "/depts")
    @ResponseBody
    public Msg getDepts(){
        List<AccDept> deptList=deptService.getDepts(null);
        return Msg.success().addResultData("depts",deptList);
    }
}
