package com.liuzhe.shop.pojo;

import java.util.Date;

public class Product {
    private Integer pid;

    private String pname;

    private Double newPrice;

    private Double oldPrice;

    private String image;

    private Integer isHot;

    private Date pdate;

    private Integer cid;

    private Integer state;

    private Integer total;

    private Integer volume;

    private Integer isPic;

    private String pdesc;

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(final Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return this.pname;
    }

    public void setPname(final String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getNewPrice() {
        return this.newPrice;
    }

    public void setNewPrice(final Double newPrice) {
        this.newPrice = newPrice;
    }

    public Double getOldPrice() {
        return this.oldPrice;
    }

    public void setOldPrice(final Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(final String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getIsHot() {
        return this.isHot;
    }

    public void setIsHot(final Integer isHot) {
        this.isHot = isHot;
    }

    public Date getPdate() {
        return this.pdate;
    }

    public void setPdate(final Date pdate) {
        this.pdate = pdate;
    }

    public Integer getCid() {
        return this.cid;
    }

    public void setCid(final Integer cid) {
        this.cid = cid;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(final Integer state) {
        this.state = state;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(final Integer total) {
        this.total = total;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public void setVolume(final Integer volume) {
        this.volume = volume;
    }

    public Integer getIsPic() {
        return this.isPic;
    }

    public void setIsPic(final Integer isPic) {
        this.isPic = isPic;
    }

    public String getPdesc() {
        return this.pdesc;
    }

    public void setPdesc(final String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }
}