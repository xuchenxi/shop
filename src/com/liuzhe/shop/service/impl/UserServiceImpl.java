package com.liuzhe.shop.service.impl;

import com.liuzhe.shop.mapper.UserMapper;
import com.liuzhe.shop.pojo.User;
import com.liuzhe.shop.pojo.UserExample;
import com.liuzhe.shop.pojo.UserExample.Criteria;
import com.liuzhe.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenxi
 * @ClassName: UserServiceImpl
 * @Description: User的DAO
 * @date 2018-4-26 上午08:18:34
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    // 获取用户列表
    @Override
    public List<User> getUserList() {
        final UserExample userExample = new UserExample();
        final List<User> userList = this.userMapper.selectByExample(userExample);
        return userList;
    }

    @Override
    public int save(final User user) {
        user.setState(0);
        final int restult = this.userMapper.insert(user);
        return restult;
    }

    @Override
    public void delete(final User user) {
        this.userMapper.deleteByPrimaryKey(user.getUid());
    }

    @Override
    public int update(final User user) {
        return this.userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> findAll() {
        final UserExample example = new UserExample();
        example.createCriteria().andUsernameLike("a");
        final List<User> list = this.userMapper.selectByExample(example);
        return list;
    }

    @Override
    public User findByUid(final Integer uid) {
        return this.userMapper.selectByPrimaryKey(uid);
    }

    // 查询 模糊匹配like
    @Override
    public List<User> query(final User user) {

        // userMapper.selectByExample();
        return null;
    }

    // 用户登录
    @Override
    public User checkLogin(final User user) {
        final UserExample example = new UserExample();
        final Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());

        final List<User> userList = this.userMapper.selectByExample(example);
        if (userList != null && userList.size() != 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    // 条件查询
    @Override
    public List<User> selectUserByTerm(final User user) {
        final UserExample userExample = new UserExample();
        final Criteria userCriteria = userExample.createCriteria();
        if (user.getUid() != null && !"".equals(user.getUid())) {
            userCriteria.andUidEqualTo(user.getUid());
        }
        if (user.getUsername() != null && !"".equals(user.getUsername())) {
            userCriteria.andUsernameLike("%" + user.getUsername() + "%");
        }
        final List<User> list = this.userMapper.selectByExample(userExample);
        return list;
    }

}
