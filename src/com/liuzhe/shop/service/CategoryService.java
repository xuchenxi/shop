package com.liuzhe.shop.service;

import com.liuzhe.shop.pojo.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getCategory();

    public int addCategory(Category category);


    public int delCategory(Integer cid);
}
