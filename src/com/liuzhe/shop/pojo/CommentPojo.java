package com.liuzhe.shop.pojo;

/**
 * @author xuchenxi
 * @ClassName: CommentPojo
 * @Description: 商品评论
 * @date 2018-5-17 上午11:00:10
 */
public class CommentPojo extends Comment {
    private String username;


    private Integer count;//评论数目

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

}
