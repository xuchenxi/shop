package com.liuzhe.shop.controller;

import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.pojo.Product;
import com.liuzhe.shop.service.ProductService;
import com.liuzhe.shop.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping("/admin/listProduct")
    @ResponseBody
    public PageInfo<Product> listProduct(final int page, final int pageSize) {
        return this.productService.ListProductsByPage(page, pageSize);
    }

    //有条件的查询user

    @RequestMapping("/admin/addProduct")
    @ResponseBody
    public String addProduct(final Product product, @RequestParam("imageFile") final MultipartFile[] files) {
        //从客户端接收文件的时候，文件单独处理
        CommonUtils.uploadFiles(product, files);
        //设置商品的其他属性
        product.setPdate(new Date());
        product.setVolume(0);
        product.setState(0);//初始为未删除的
        final int result = this.productService.insertProduct(product);
        if (result != 0) {
            return "1";
        } else {
            return "0";
        }
    }

    @RequestMapping("/admin/delProduct")
    @ResponseBody
    public String delProduct(final int pid) {
        final int result = this.productService.deleteProduct(pid);
        if (result != 0) {
            return "ok";
        } else {
            return "error";
        }
    }

    @RequestMapping("/admin/getProductByPid")
    @ResponseBody
    public Product getProductByPid(final Integer pid) {
        return this.productService.getProductByPid(pid);
    }

    @RequestMapping("/admin/editProduct")
    @ResponseBody
    public String editProduct(final Product product, @RequestParam("imageFile") final MultipartFile[] files) {
        //从客户端接收文件的时候，文件单独处理
        CommonUtils.uploadFiles(product, files);
        //设置商品的其他属性
        product.setPdate(new Date());
        product.setVolume(0);
        product.setState(0);//初始为未删除的
        final int result = this.productService.updateProduct(product);
        if (result != 0) {
            return "1";
        } else {
            return "0";
        }
    }

    // 有条件的查询user
    @RequestMapping("/admin/selectProductByTerm")
    public ModelAndView selectProductByTerm(final Product product) {
        final List<Product> productList = this.productService.selectProductByTerm(product);
        final ModelAndView modelAndView = new ModelAndView();
        if (productList == null || productList.isEmpty()) {
            modelAndView.addObject("msg", "没有查询结果,请更换查询条件!");
        } else {
            modelAndView.addObject("productList", productList);
        }
        modelAndView.setViewName("product_list");
        return modelAndView;
    }
}
