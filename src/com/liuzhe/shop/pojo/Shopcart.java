package com.liuzhe.shop.pojo;

public class Shopcart {
    private Integer sid;

    private Integer pid;

    private Integer count;

    private Integer uid;

    private Double subtotal;

    private Integer specid;//商品规格

    public Integer getSid() {
        return this.sid;
    }

    public void setSid(final Integer sid) {
        this.sid = sid;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(final Integer pid) {
        this.pid = pid;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(final Integer uid) {
        this.uid = uid;
    }

    public Double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(final Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getSpecid() {
        return this.specid;
    }

    public void setSpecid(final Integer specid) {
        this.specid = specid;
    }
}