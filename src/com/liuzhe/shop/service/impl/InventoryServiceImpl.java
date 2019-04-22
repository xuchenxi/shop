package com.liuzhe.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.mapper.InventoryMapper;
import com.liuzhe.shop.pojo.Inventory;
import com.liuzhe.shop.pojo.InventoryExample;
import com.liuzhe.shop.pojo.InventoryExample.Criteria;
import com.liuzhe.shop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;


    @Override
    public int insert(final Inventory inventory) {
        return this.inventoryMapper.insertSelective(inventory);
    }


    @Override
    public List<Inventory> getInventoryList(final Integer pid) {
        final InventoryExample inventoryExample = new InventoryExample();
        inventoryExample.createCriteria().andPidEqualTo(pid);//查询pid的规格信息
        final List<Inventory> inventoryList = this.inventoryMapper.selectByExample(inventoryExample);
        return inventoryList;
    }

    //根据具体商品的规格查询商品对应的库存
    @Override
    public Inventory selectByTerm(final Integer pid, final String size, final String color) {
        final InventoryExample inventoryExample = new InventoryExample();
        final Criteria createCriteria = inventoryExample.createCriteria();
        createCriteria.andPidEqualTo(pid);
        createCriteria.andPsizeEqualTo(size);
        createCriteria.andPcolorEqualTo(color);
        final List<Inventory> inventoryList = this.inventoryMapper.selectByExample(inventoryExample);
        if (inventoryList.size() != 0) {
            return inventoryList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Inventory> selectSize(final Integer pid) {
        return this.inventoryMapper.selectInventoryBySize(pid);
    }

    @Override
    public List<Inventory> selectColor(final Integer pid) {
        return this.inventoryMapper.selectInventoryByColor(pid);
    }


    //分页
    @Override
    public PageInfo<Inventory> getInventoryByPage(final Integer pid, final int page, final int pageSize) {
        PageHelper.startPage(page, pageSize);

        final InventoryExample inventoryExample = new InventoryExample();
        inventoryExample.createCriteria().andPidEqualTo(pid);//查询pid的规格信息
        final List<Inventory> list = this.inventoryMapper.selectByExample(inventoryExample);

        //保存分页对象
        final PageInfo<Inventory> pageInfo = new PageInfo<Inventory>(list);
        return pageInfo;
    }

    @Override
    public Inventory getInventoryById(final Integer id) {
        return this.inventoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateInventoryById(final Integer id, final Integer amount) {
        final Inventory inventory = this.inventoryMapper.selectByPrimaryKey(id);
        inventory.setAmount(amount);
        final int result = this.inventoryMapper.updateByPrimaryKey(inventory);
        return result;
    }

}
