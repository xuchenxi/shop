package com.liuzhe.shop.pojo;

import java.util.Date;

public class Comment {
    private Integer comid;

    private String content;

    private Date created;

    private Integer pid;

    private Integer uid;

    private Integer state;

    public Integer getComid() {
        return this.comid;
    }

    public void setComid(final Integer comid) {
        this.comid = comid;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(final Date created) {
        this.created = created;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(final Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(final Integer uid) {
        this.uid = uid;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(final Integer state) {
        this.state = state;
    }
}