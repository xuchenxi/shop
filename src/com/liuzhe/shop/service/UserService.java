package com.liuzhe.shop.service;

import com.liuzhe.shop.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();

    public List<User> query(User user);

    public int save(User user);

    public void delete(User user);

    public int update(User user);

    public User findByUid(Integer uid);

    public User checkLogin(User user);

    // 条件查询
    public List<User> selectUserByTerm(User user);
}
