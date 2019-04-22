package com.liuzhe.shop.pojo;

import java.io.Serializable;

public class Category implements Serializable {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer cid;

    private String cname;

    private Integer state;

    public Integer getCid() {
        return this.cid;
    }

    public void setCid(final Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(final String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(final Integer state) {
        this.state = state;
    }
}