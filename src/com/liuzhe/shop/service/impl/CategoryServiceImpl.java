package com.liuzhe.shop.service.impl;

import com.liuzhe.shop.mapper.CategoryMapper;
import com.liuzhe.shop.pojo.Category;
import com.liuzhe.shop.pojo.CategoryExample;
import com.liuzhe.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategory() {
        final CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andStateEqualTo(0);
        final List<Category> categoryList = this.categoryMapper.selectByExample(categoryExample);
        return categoryList;
    }

    @Override
    public int addCategory(final Category category) {
        category.setState(0);
        final int result = this.categoryMapper.insertSelective(category);
        return result;
    }

    @Override
    public int delCategory(final Integer cid) {
        final Category category = this.categoryMapper.selectByPrimaryKey(cid);
        category.setState(1);
        final int result = this.categoryMapper.updateByPrimaryKeySelective(category);
        return result;
    }

}
