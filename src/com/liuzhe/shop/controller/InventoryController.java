package com.liuzhe.shop.controller;

import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.pojo.Inventory;
import com.liuzhe.shop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/admin/addInventory")
    @ResponseBody
    public Map<String, String> addInventory(final Inventory inventory) {
        inventory.setState(0);
        inventory.setRemark("库存正常");
        final Map<String, String> map = new HashMap<>();
        final int result = this.inventoryService.insert(inventory);
        if (result != 0) {
            map.put("result", "ok");
        } else {
            map.put("result", "error");
        }
        return map;
    }

    @RequestMapping("/admin/getInventoryPageByPid")
    @ResponseBody()
    public PageInfo<Inventory> getInventoryByPid(final Integer pid, final Integer page, final Integer pageSize) {
        return this.inventoryService.getInventoryByPage(pid, page, pageSize);
    }

    @RequestMapping("/admin/getInventoryById")
    @ResponseBody()
    public Inventory getInventoryById(final Integer id) {
        return this.inventoryService.getInventoryById(id);
    }

    @RequestMapping("/admin/updateInventoryById")
    @ResponseBody()
    public String updateInventoryById(final Integer id, final Integer amount) {
        final int result = this.inventoryService.updateInventoryById(id, amount);
        if (result != 0) {
            return "ok";
        } else {
            return "error";
        }
    }

}
