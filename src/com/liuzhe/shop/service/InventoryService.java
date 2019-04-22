package com.liuzhe.shop.service;

import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.pojo.Inventory;

import java.util.List;

/**
 * @author xuchenxi
 * @ClassName: InventoryService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年6月3日 下午5:37:07
 */
public interface InventoryService {
    public int insert(Inventory inventory);

    //前台页面获取商品的规格
    public List<Inventory> getInventoryList(Integer pid);

    public PageInfo<Inventory> getInventoryByPage(Integer pid, int page, int pageSize);

    public List<Inventory> selectSize(Integer pid);

    public List<Inventory> selectColor(Integer pid);

    public Inventory selectByTerm(Integer pid, String size, String color);


    public Inventory getInventoryById(Integer id);

    public int updateInventoryById(Integer id, Integer amount);
}
