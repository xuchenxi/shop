package com.liuzhe.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.mapper.ShopcartMapper;
import com.liuzhe.shop.pojo.Shopcart;
import com.liuzhe.shop.pojo.ShopcartPojo;
import com.liuzhe.shop.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopcartServiceImpl implements ShopcartService {

    @Autowired
    private ShopcartMapper shopcartMapper;

    @Override
    public void insert(final Shopcart shopcart) {
        this.shopcartMapper.insertSelective(shopcart);
    }

    @Override
    public List<ShopcartPojo> getCart(final Integer uid) {
        final List<ShopcartPojo> list = this.shopcartMapper.selectShopcartPojoByUid(uid);
        this.changeProductList(list);
        return list;
    }

    //分页
    @Override
    public PageInfo<ShopcartPojo> getCartByPage(final Integer uid, final int page, final int pageSize) {
        PageHelper.startPage(page, pageSize);
        final List<ShopcartPojo> list = this.shopcartMapper.selectShopcartPojoByUid(uid);
        this.changeProductList(list);
        return new PageInfo<ShopcartPojo>(list);
    }


    //封装 处理图片路径的问题 和商品名称的截取
    private void changeProductList(final List<ShopcartPojo> list) {
        //处理图片路径的问题
        for (final ShopcartPojo shopcartPojo : list) {
            final String image = shopcartPojo.getImage();
            final String[] split = image.split(",");//通过","将多张图片分隔开，保存到数组中
            shopcartPojo.setImage("/pic/" + split[0]);
            //当商品名称过长时，进行截取
//			if (shopcartPojo.getPname().length()>8) {
//				shopcartPojo.setPname(shopcartPojo.getPname().substring(0, 8)+"...");
//			}
        }
    }

    //update
    @Override
    public void Modify(final Shopcart shopcart) {
        this.shopcartMapper.updateByPrimaryKeySelective(shopcart);
    }

    //delete
    @Override
    public void delete(final Integer sid) {
        this.shopcartMapper.deleteByPrimaryKey(sid);
    }


}
