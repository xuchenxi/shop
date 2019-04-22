package com.liuzhe.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.mapper.AdminuserMapper;
import com.liuzhe.shop.pojo.Adminuser;
import com.liuzhe.shop.pojo.AdminuserExample;
import com.liuzhe.shop.pojo.AdminuserExample.Criteria;
import com.liuzhe.shop.service.AdminuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminuserServiceImpl implements AdminuserService {

    @Autowired
    private AdminuserMapper adminuserMapper;

    // 登录后台
    @Override
    public Adminuser login(final String username, final String password) {
        final AdminuserExample adminuserExample = new AdminuserExample();
        final Criteria criteria = adminuserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        final List<Adminuser> adminusers = this.adminuserMapper
                .selectByExample(adminuserExample);
        if (adminusers.size() == 0) {
            return null;
        }
        return adminusers.get(0);
    }

    // 管理员列表
    @Override
    public List<Adminuser> getAdminUserList() {
        final AdminuserExample example = new AdminuserExample();
        final List<Adminuser> list = this.adminuserMapper.selectByExample(example);
        return list;
    }

    // 条件查询
    @Override
    public List<Adminuser> selectAdminuserByTerm(final Adminuser adminuser) {
        final AdminuserExample example = new AdminuserExample();
        final Criteria adminuserCriteria = example.createCriteria();
        if (adminuser.getUsername() != null
                && !"".equals(adminuser.getUsername())) {
            adminuserCriteria.andUsernameLike("%" + adminuser.getUsername()
                    + "%");
        }
        if ("1".equals(adminuser.getType()) || "2".equals(adminuser.getType())) {
            adminuserCriteria.andTypeLike(adminuser.getType());
        }
        final List<Adminuser> list = this.adminuserMapper.selectByExample(example);
        return list;
    }

    // 根据id查询adminuser
    @Override
    public Adminuser getAdminuserById(final Integer uid) {
        return this.adminuserMapper.selectByPrimaryKey(uid);
    }

    // 修改adminuser的信息
    @Override
    public int adminModify(final Adminuser adminuser) {
        final int updateByPrimaryKey = this.adminuserMapper
                .updateByPrimaryKeySelective(adminuser);
        return updateByPrimaryKey;
    }

    // 添加 adminuser
    @Override
    public int addAdmin(final Adminuser adminuser) {
        adminuser.setState(0);
        final int insertSelective = this.adminuserMapper.insertSelective(adminuser);
        return insertSelective;
    }

    @Override
    public int deleteAdmin(final Integer uid) {
        final int deleteByPrimaryKey = this.adminuserMapper.deleteByPrimaryKey(uid);
        return deleteByPrimaryKey;
    }

    @Override
    public PageInfo<Adminuser> getAdminListByPage(final int page, final int pageSize) {
        // 获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(page, pageSize);
        final AdminuserExample adminuserExample = new AdminuserExample();
        final List<Adminuser> list = this.adminuserMapper
                .selectByExample(adminuserExample);

        // 分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
        final PageInfo<Adminuser> pageInfo = new PageInfo<Adminuser>(list);
        return pageInfo;
    }

}
