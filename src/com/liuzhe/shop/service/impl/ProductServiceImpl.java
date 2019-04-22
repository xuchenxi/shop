package com.liuzhe.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.mapper.ProductMapper;
import com.liuzhe.shop.pojo.Product;
import com.liuzhe.shop.pojo.ProductExample;
import com.liuzhe.shop.pojo.ProductExample.Criteria;
import com.liuzhe.shop.pojo.ProductPojo;
import com.liuzhe.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    //insertProduct
    @Override
    public int insertProduct(final Product product) {
        final int result = this.productMapper.insertSelective(product);
        return result;
    }

    //查询所有product 列表 byPage
    @Override
    public PageInfo<Product> ListProductsByPage(final int page, final int pageSize) {
        PageHelper.startPage(page, pageSize);

        final ProductExample productExample = new ProductExample();
        productExample.createCriteria().andStateEqualTo(0);//查询未删除的
        productExample.setOrderByClause("pid desc");//通过pid desc降序查询
        final List<Product> list = this.productMapper.selectByExample(productExample);

        //保存分页对象
        final PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }


    @Override
    public PageInfo<Product> getProductPic() {
        PageHelper.startPage(1, 4);
        final ProductExample productExample = new ProductExample();
        final Criteria criteria = productExample.createCriteria();
        criteria.andIsPicEqualTo(1);//查询是轮播图片的商品
        criteria.andStateEqualTo(0);//未删除的
        productExample.setOrderByClause("pid desc");//通过pid desc降序查询
        final List<Product> list = this.productMapper.selectByExample(productExample);
        //处理图片路径的问题
        this.changeProductList(list);
        //保存分页对象
        final PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Product> getHotProduct() {
        PageHelper.startPage(1, 11);
        final ProductExample productExample = new ProductExample();
        final Criteria criteria = productExample.createCriteria();
        criteria.andIsHotEqualTo(1);//查询是热门商品的商品
        criteria.andStateEqualTo(0);//未删除的
        productExample.setOrderByClause("pid desc");//通过pid desc降序查询
        final List<Product> list = this.productMapper.selectByExample(productExample);
        //处理图片路径的问题
        this.changeProductList(list);
        //保存分页对象
        final PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Product> getNewProduct() {
        PageHelper.startPage(1, 11);
        final ProductExample productExample = new ProductExample();
        final Criteria criteria = productExample.createCriteria();
        criteria.andStateEqualTo(0);//未删除的
        productExample.setOrderByClause("pid desc");//通过pid desc降序查询
        final List<Product> list = this.productMapper.selectByExample(productExample);
        //处理图片路径的问题
        this.changeProductList(list);
        //保存分页对象
        final PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

    //获取商品分类的list
    @Override
    public PageInfo<Product> getProductByCid(final int cid, final int page, final int pageSize) {
        PageHelper.startPage(page, pageSize);
        final ProductExample productExample = new ProductExample();
        final Criteria criteria = productExample.createCriteria();
        criteria.andCidEqualTo(cid);  //根据category分类查询
        criteria.andStateEqualTo(0);//未删除的
        productExample.setOrderByClause("pid desc");//通过pid desc降序查询
        final List<Product> list = this.productMapper.selectByExample(productExample);
        //处理图片路径的问题
        this.changeProductList(list);
        //保存分页对象
        final PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

    //获取商品名查询
    @Override
    public PageInfo<Product> getProductByame(final String name, final int page, final int pageSize) {
        PageHelper.startPage(page, pageSize);

        final ProductExample productExample = new ProductExample();
        final Criteria criteria = productExample.createCriteria();
        criteria.andPnameLike("%" + name + "%");//根据pname进行模糊查询
        criteria.andStateEqualTo(0);//未删除的
        productExample.setOrderByClause("pid desc");//通过pid desc降序查询
        final List<Product> list = this.productMapper.selectByExample(productExample);
        //处理图片路径的问题
        this.changeProductList(list);
        //保存分页对象
        final PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

    //通过商品的pid查询商品的详细信息，包括商品图片、名称、评论等
    @Override
    public ProductPojo getProductPojoByPid(final Integer pid) {
        return this.productMapper.selectProductPojoByPid(pid);
    }

    //封装 处理图片路径的问题 和商品名称的截取
    private void changeProductList(final List<Product> list) {
        //处理图片路径的问题
        for (final Product product : list) {
            final String image = product.getImage();
            final String[] split = image.split(",");//通过","将多张图片分隔开，保存到数组中
            product.setImage("/pic/" + split[0]);
            //当商品名称过长时，进行截取
            if (product.getPname().length() > 8) {
                product.setPname(product.getPname().substring(0, 8) + "...");
            }
        }
    }

    @Override
    public int deleteProduct(final Integer pid) {
        final Product product = this.productMapper.selectByPrimaryKey(pid);
        product.setState(1);
        return this.productMapper.updateByPrimaryKey(product);
    }

    @Override
    public Product getProductByPid(final Integer pid) {
        return this.productMapper.selectByPrimaryKey(pid);
    }
}
