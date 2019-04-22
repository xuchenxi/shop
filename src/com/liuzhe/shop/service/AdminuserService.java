package com.liuzhe.shop.service;

import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.pojo.Adminuser;

import java.util.List;

/**
 * @author xuchenxi
 * @ClassName: AdminuserService
 * @Description: Adminuser服务接口
 * @date 2018-4-27 上午10:28:26
 */

public interface AdminuserService {
    //login 登录
    public Adminuser login(String username, String password);

    //获取adminlist
    public List<Adminuser> getAdminUserList();

    public List<Adminuser> selectAdminuserByTerm(Adminuser adminuser);

    public Adminuser getAdminuserById(Integer uid);

    public int adminModify(Adminuser adminuser);

    public int addAdmin(Adminuser adminuser);

    public int deleteAdmin(Integer uid);

    public PageInfo<Adminuser> getAdminListByPage(int page, int pageSize);
}
