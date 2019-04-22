package com.liuzhe.shop.pojo;

public class User {
    private Integer uid;

    private String username;

    private String password;

    private String name;

    private String email;

    private String phone;

    private String addr;

    private Integer state;

    private String code;

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

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(final String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(final Integer state) {
        this.state = state;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code == null ? null : code.trim();
    }
}