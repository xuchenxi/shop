package com.liuzhe.shop.mapper;

import com.liuzhe.shop.pojo.Adminuser;
import com.liuzhe.shop.pojo.AdminuserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminuserMapper {
    int countByExample(AdminuserExample example);

    int deleteByExample(AdminuserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(Adminuser record);

    int insertSelective(Adminuser record);

    List<Adminuser> selectByExample(AdminuserExample example);

    Adminuser selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") Adminuser record, @Param("example") AdminuserExample example);

    int updateByExample(@Param("record") Adminuser record, @Param("example") AdminuserExample example);

    int updateByPrimaryKeySelective(Adminuser record);

    int updateByPrimaryKey(Adminuser record);

    // 逆向工程  end
    //自定义    
    Adminuser selectByUsername(String username, String password);
}