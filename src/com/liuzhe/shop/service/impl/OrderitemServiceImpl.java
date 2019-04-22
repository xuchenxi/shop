package com.liuzhe.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.mapper.OrderitemMapper;
import com.liuzhe.shop.pojo.OrderitemPojo;
import com.liuzhe.shop.service.OrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderitemServiceImpl implements OrderitemService {

    @Autowired
    private OrderitemMapper orderitemMapper;

    @Override
    public PageInfo<OrderitemPojo> getOrderitemByPage(final Integer oid, final int page, final int pageSize) {
        PageHelper.startPage(page, pageSize);
        final List<OrderitemPojo> list = this.orderitemMapper.selectOrderitemPojoByOid(oid);
        this.changeProductList(list);
        return new PageInfo<OrderitemPojo>(list);
    }


    //封装 处理图片路径的问题 和商品名称的截取
    private void changeProductList(final List<OrderitemPojo> list) {
        //处理图片路径的问题
        for (final OrderitemPojo orderitemPojo : list) {
            final String image = orderitemPojo.getImage();
            final String[] split = image.split(",");//通过","将多张图片分隔开，保存到数组中
            orderitemPojo.setImage("/pic/" + split[0]);
            //当商品名称过长时，进行截取
//			if (shopcartPojo.getPname().length()>8) {
//				shopcartPojo.setPname(shopcartPojo.getPname().substring(0, 8)+"...");
//			}
        }
    }


    //评价订单项
    @Override
    public OrderitemPojo getOrderitemPojobyOidPid(final Integer oid, final Integer pid) {
        final List<OrderitemPojo> orderitemPojoList = this.orderitemMapper.selectOrderitemPojoByOidPid(oid, pid);
        final OrderitemPojo orderitemPojo = orderitemPojoList.get(0);
        final String image = orderitemPojo.getImage();
        final String[] split = image.split(",");//通过","将多张图片分隔开，保存到数组中
        orderitemPojo.setImage("/pic/" + split[0]);
        return orderitemPojo;
    }
}
