package com.lp.crud.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 26685 on 2017/5/31.
 */
public class Msg {
    private Integer code;
    private String message;
    private Map<String,Object> result=new HashMap();

    public static Msg success(){
        Msg msg = new Msg();
        msg.setCode(100);
        msg.setMessage("请求成功");
        return msg;
    }

    public static Msg fail(){
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMessage("请求失败");
        return msg;
    }

    public Msg addResultData(String key,Object value){
        this.result.put(key,value);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
