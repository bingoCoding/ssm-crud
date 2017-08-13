package com.lp.crud.bean;

public class AccUser {
    private Long id;

    private String name;

    private String password;

    private Long domainId;

    private AccDept domain;

    public AccUser(String name, String password, Long domainId) {
        this.name = name;
        this.password = password;
        this.domainId = domainId;
    }

    public AccUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public AccDept getDomain() {
        return domain;
    }

    public void setDomain(AccDept domain) {
        this.domain = domain;
    }
}