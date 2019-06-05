package com.liuzhe.shop.service;

import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.pojo.Product;
import com.liuzhe.shop.pojo.ProductPojo;

/**
 * @author xuchenxi
 * @ClassName: ProductService
 * @Description: 商品 product
 * @date 2018-5-3 上午09:22:32
 */
public interface ProductService {
    //获取商品列表 byPage
    public PageInfo<Product> ListProductsByPage(int page, int pageSize);

    //添加商品
    public int insertProduct(Product product);

    //删除商品
    public int deleteProduct(Integer pid);
    
    //编辑商品
    public int updateProduct(Product product);

    //通过id查询product
    public Product getProductByPid(Integer pid);

    //获取商品图片-用于轮播
    public PageInfo<Product> getProductPic();

    //获取最新商品 分页集合
    public PageInfo<Product> getNewProduct();

    //获取热门商品 分页集合
    public PageInfo<Product> getHotProduct();

    //通过商品分类获取
    public PageInfo<Product> getProductByCid(int cid, int page, int pageSize);

    //通过商品名获取
    public PageInfo<Product> getProductByame(String name, int page, int pageSize);

    //查询商品详情
    ProductPojo getProductPojoByPid(Integer pid);

}
