package com.liuzhe.shop.pojo;

public class Inventory {
    private Integer id;

    private Integer pid;

    private String psize;

    private String pcolor;

    private Integer amount;

    private String remark;

    private Integer state;

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(final Integer pid) {
        this.pid = pid;
    }

    public String getPsize() {
        return this.psize;
    }

    public void setPsize(final String psize) {
        this.psize = psize == null ? null : psize.trim();
    }

    public String getPcolor() {
        return this.pcolor;
    }

    public void setPcolor(final String pcolor) {
        this.pcolor = pcolor == null ? null : pcolor.trim();
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(final String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(final Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Inventory [id=" + this.id + ", pid=" + this.pid + ", psize=" + this.psize
                + ", pcolor=" + this.pcolor + ", amount=" + this.amount + ", remark="
                + this.remark + ", state=" + this.state + "]";
    }

}