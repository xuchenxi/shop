package com.liuzhe.shop.controller;

import com.liuzhe.shop.pojo.Category;
import com.liuzhe.shop.service.CategoryService;
import com.liuzhe.shop.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    //Ajax请求是.htm请求.SpringMVC不会将数据转换为JSON数据
    @RequestMapping("/admin/getCategories")
    @ResponseBody()
    public List<Category> getCategories() {
        return this.categoryService.getCategory();
    }

    @RequestMapping("/admin/categoryList")
    public ModelAndView categoryList() throws MyException {
        final List<Category> list = this.categoryService.getCategory();
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList", list);
        modelAndView.setViewName("category_list");
        return modelAndView;
    }

    //添加商品分类
    @RequestMapping("/admin/addCategory")
    @ResponseBody
    public String add(final Category category) {
        final int result = this.categoryService.addCategory(category);
        if (result != 0) {
            return "1";
        } else {
            return "0";
        }
    }

    //添加商品分类
    @RequestMapping("/admin/delCategory")
    @ResponseBody
    public String delete(final Integer cid) {
        final int result = this.categoryService.delCategory(cid);
        if (result != 0) {
            return "1";
        } else {
            return "0";
        }
    }

}
