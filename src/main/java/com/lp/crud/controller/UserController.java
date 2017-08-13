package com.lp.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lp.crud.bean.AccUser;
import com.lp.crud.bean.Msg;
import com.lp.crud.service.AccUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 26685 on 2017/5/19.
 */
@Controller
public class UserController {

    @Autowired
    private AccUserService accUserService;


    @RequestMapping(value = "/listPage")
    public String list(){
        return "user-list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Msg listData(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo, Model model){
        PageHelper.startPage(pageNo,2);
        List<AccUser> userList=accUserService.selectByExampleWithDept(null);
        PageInfo<AccUser> pageInfo=new PageInfo<AccUser>(userList,3);
        Msg msg = Msg.success().addResultData("pageInfo",pageInfo);
        return msg;
    }

    @PostMapping(value = "saveuser")
    @ResponseBody
    public Msg saveUser(AccUser accUser){
        int result=accUserService.saveUser(accUser);
        if(result>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
