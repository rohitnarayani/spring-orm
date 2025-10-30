package com.spring.jdbc.entities;

public class Customer {
    private String cid;
    private String cname;
    private String branch;

    public String getCid() {
        return cid;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public Customer() {
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}