package com.liuzhe.shop.pojo;

public class Adminuser {
    private Integer uid;

    private String username;

    private String password;

    private String type;

    private Integer state;

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(final Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(final Integer state) {
        this.state = state;
    }
}