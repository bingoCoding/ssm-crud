package com.lp.crud.controller;

import com.github.pagehelper.PageInfo;
import com.lp.crud.bean.AccUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by 26685 on 2017/5/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class ControllerTest {
    //虚拟http请求
    MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;

    @Before
    public void initMockMvc(){
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void listTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/list").param("pageNo", "1")).andReturn();
        PageInfo<AccUser> pageInfo = (PageInfo)mvcResult.getRequest().getAttribute("pageInfo");
        System.out.println("page:"+pageInfo.getList().size());
        for (int i=0;i<pageInfo.getList().size();i++){
            System.out.println("name="+pageInfo.getList().get(i).getName());
            System.out.println("name="+pageInfo.getList().get(i).getPassword());
            System.out.println("name="+pageInfo.getList().get(i).getDomain().getLable());
        }
    }

}
