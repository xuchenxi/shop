package com.liuzhe.shop.service;

import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.pojo.Shopcart;
import com.liuzhe.shop.pojo.ShopcartPojo;

import java.util.List;

public interface ShopcartService {
    public void insert(Shopcart shopcart);

    public List<ShopcartPojo> getCart(Integer uid);

    //分页显示购物车
    public PageInfo<ShopcartPojo> getCartByPage(Integer uid, int page, int pageSize);

    public void Modify(Shopcart shopcart);

    public void delete(Integer sid);
}
