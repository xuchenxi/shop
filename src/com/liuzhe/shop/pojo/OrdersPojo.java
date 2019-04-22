package com.liuzhe.shop.pojo;

/**
 * @author xuchenxi
 * @ClassName: OrdersPojo
 * @Description: 订单详细
 * @date 2018年5月24日 下午5:15:49
 */
public class OrdersPojo extends Orders {
    private Integer count; // 订单项中商品的数量

    private Double subtotal; // 订单项中的总价

    private Integer pid;

    private String pname; // 商品名

    private Double newPrice; // 商品价格

    private Double oldPrice;

    private String image; // 商品图片

    public Integer getCount() {
        return this.count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(final Double subtotal) {
        this.subtotal = subtotal;
    }

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
        this.pname = pname;
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
        this.image = image;
    }

}
