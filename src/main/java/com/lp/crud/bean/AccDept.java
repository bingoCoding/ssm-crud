package com.lp.crud.bean;

public class AccDept {
    private Long id;

    private String lable;

    private Long pid;

    private String deptNo;

    public AccDept(String lable, Long pid, String deptNo) {
        this.lable = lable;
        this.pid = pid;
        this.deptNo = deptNo;
    }

    public AccDept() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable == null ? null : lable.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo == null ? null : deptNo.trim();
    }
}