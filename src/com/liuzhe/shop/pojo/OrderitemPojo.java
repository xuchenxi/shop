package com.liuzhe.shop.pojo;

import java.util.Date;

/**
 * @author xuchenxi
 * @ClassName: OrderitemPojo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018-5-24 上午10:05:42
 */
public class OrderitemPojo extends Orderitem {

    //商品信息
    private String pname;
    private Double newPrice;
    private String image;

    //订单信息
    private Double total;
    private Date ordertime;
    private String state;
    private String number;

    //商品规格
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


    public Double getTotal() {
        return this.total;
    }

    public void setTotal(final Double total) {
        this.total = total;
    }

    public Date getOrdertime() {
        return this.ordertime;
    }

    public void setOrdertime(final Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getState() {
        return this.state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String number) {
        this.number = number;
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
