package com.liuzhe.shop.pojo;

public class ShopcartPojo extends Shopcart {
    private String pname;

    private Double newPrice;

    private String image;

    private String psize;//商品尺寸

    private String pcolor;//商品颜色


    public String getPname() {
        return this.pname;
    }

    public void setPname(final String pname) {
        this.pname = pname;
    }

    public Double getNewPrice() {
        return this.newPrice;
    }

    public void setNewPrice(final Double newPrice) {
        this.newPrice = newPrice;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getPsize() {
        return this.psize;
    }

    public void setPsize(final String psize) {
        this.psize = psize;
    }

    public String getPcolor() {
        return this.pcolor;
    }

    public void setPcolor(final String pcolor) {
        this.pcolor = pcolor;
    }

}
