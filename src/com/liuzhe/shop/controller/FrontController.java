package com.liuzhe.shop.controller;

import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.pojo.*;
import com.liuzhe.shop.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuchenxi
 * @ClassName: FrontController
 * @Description: shop项目前台控制器
 * @date 2018-5-31 上午09:02:41
 */
@Controller
public class FrontController {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ShopcartService shopcartService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderitemService orderitemService;

    @Autowired
    private InventoryService inventoryService;

    private static Logger LOG = Logger.getLogger(FrontController.class);

    // 前台登录
    @RequestMapping("/checkUserLogin")
    @ResponseBody()
    public Map<String, String> checkUserLogin(final User user, final String checkcode,
                                              final HttpSession session) {
        final Map<String, String> map = new HashMap<>();

        final String vCode = (String) session.getAttribute("vCode");

        if (checkcode.equalsIgnoreCase(vCode)) {
            // 验证码正确 才验证用户名信息
            final User userResult = this.userService.checkLogin(user);
            if (userResult == null) {
                map.put("result", "error");
            } else {
                session.setAttribute("user", userResult);
                map.put("result", "ok");
            }
        } else {
            // 验证码错误
            map.put("result", "vcodeerror");
        }
        return map;
    }

    // 用户退出
    @RequestMapping("/exit")
    @ResponseBody()
    public Map<String, String> exit(final HttpSession session) {
        final Map<String, String> map = new HashMap<>();
        final User user = (User) session.getAttribute("user");
        if (user == null) {
            map.put("result", "error");
        } else {
            session.removeAttribute("user");
            map.put("result", "ok");
        }
        return map;
    }

    // 用户信息
    @RequestMapping("/userInfo")
    @ResponseBody()
    public User userInfo(final HttpSession session) {
        final User user = (User) session.getAttribute("user");
        return this.userService.findByUid(user.getUid());
    }

    // 用户信息修改
    @RequestMapping("/userInfoModify")
    @ResponseBody()
    public Map<String, String> userInfoModify(final User user, final HttpSession session) {
        final User user1 = (User) session.getAttribute("user");
        final Map<String, String> map = new HashMap<>();

        if (user1 != null && user != null) {
            user.setUid(user1.getUid());
            // 验证码正确 才进行注册
            final int result = this.userService.update(user);
            if (result != 0) {
                session.setAttribute("user", user);
                map.put("result", "ok");
            } else {
                map.put("result", "error");
            }
        } else {
            // 验证码错误
            map.put("result", "invalid");
        }
        return map;
    }

    // 用户注册
    @RequestMapping("/userRegister")
    @ResponseBody()
    public Map<String, String> register(final User user, final String checkcode,
                                        final HttpSession session) {
        final Map<String, String> map = new HashMap<>();

        final String vCode = (String) session.getAttribute("vCode");
        if (checkcode.equalsIgnoreCase(vCode)) {
            // 验证码正确 才进行注册
            final int result = this.userService.save(user);
            if (result != 0) {
                session.setAttribute("user", user);
                map.put("result", "ok");
            } else {
                map.put("result", "error");
            }
        } else {
            // 验证码错误
            map.put("result", "vcodeerror");
        }
        return map;
    }

    // 获取商品分类
    @SuppressWarnings("unchecked")
    @RequestMapping("getCategories")
    @ResponseBody()
    public List<Category> getCategories(final HttpSession session) {
        // 将商品分类保存在session
        List<Category> categoryList = (List<Category>) session
                .getAttribute("categoryList");
        if (categoryList == null || categoryList.isEmpty()) {
            categoryList = this.categoryService.getCategory();
            session.setAttribute("categoryList", categoryList);
        }
        return categoryList;
    }

    @RequestMapping("getProductPic")
    @ResponseBody()
    public PageInfo<Product> getProductPic() {
        return this.productService.getProductPic();
    }

    @RequestMapping("getNewProduct")
    @ResponseBody()
    public PageInfo<Product> getNewProduct() {
        return this.productService.getNewProduct();
    }

    @RequestMapping("getHotProduct")
    @ResponseBody()
    public PageInfo<Product> getHotProduct() {
        return this.productService.getHotProduct();
    }
    // test http://localhost/shop/getCateProduct?cid=1&page=1&pageSize=10

    @RequestMapping("getCateProduct")
    @ResponseBody()
    public PageInfo<Product> getCateProduct(final int cid, final int page, final int pageSize) {
        return this.productService.getProductByCid(cid, page, pageSize);
    }

    @RequestMapping("getProductsByName")
    @ResponseBody()
    public PageInfo<Product> getCateProduct(final String name, final int page, final int pageSize) {
        String content = "";
        try {
            content = URLDecoder.decode(name, "utf-8");    // 编码的问题
        } catch (final UnsupportedEncodingException e) {
            LOG.error("getProductsByName error ", e);
        }
        return this.productService.getProductByame(content, page, pageSize);
    }

    // test http://localhost/shop/getProductsByName?name=鞋&page=1&pageSize=10

    @RequestMapping("/getProductInfo")
    @ResponseBody()
    public ProductPojo getProductPojoByPid(final int pid) {
        return this.productService.getProductPojoByPid(pid);
    }

    // test http://localhost/shop/getProductInfo?pid=2

    @RequestMapping("/getProductComment")
    @ResponseBody()
    public List<CommentPojo> getCommentPojoByPid(final int pid) {
        return this.commentService.getCommentPojosByPid(pid);
    }

    @RequestMapping("/getCommentCount")
    @ResponseBody()
    public CommentPojo getCommentCount(final int pid) {
        return this.commentService.getCount(pid);
    }

    // test http://localhost/shop/getProductComment?pid=72

    // 加入购物车
    @RequestMapping("/addCart")
    @ResponseBody()
    public Map<String, String> addCart(final Shopcart shopcart, final HttpSession session) {
        final Map<String, String> map = new HashMap<String, String>();
        final User user = (User) session.getAttribute("user");
        if (user != null) {
            shopcart.setUid(user.getUid());// 获取当前用户的UID,将其保存到购物车
            this.shopcartService.insert(shopcart);
            map.put("result", "ok");// 成功将商品加入购物车
        } else {
            map.put("result", "error");// 未登录
        }
        return map;
    }

    // 查询购物车
    @RequestMapping("/getCart")
    @ResponseBody()
    public List<ShopcartPojo> getCart(final HttpSession session) {
        final User user = (User) session.getAttribute("user");
        return this.shopcartService.getCart(user.getUid());
    }

    // 通过分页查询购物车
    @RequestMapping("/getCartByPage")
    @ResponseBody()
    public PageInfo<ShopcartPojo> getCartByPage(final HttpSession session, final int page,
                                                final int pageSize) {
        final User user = (User) session.getAttribute("user");
        if (user != null) {
            return this.shopcartService.getCartByPage(user.getUid(), page, pageSize);
        } else {
            return null;
        }
    }

    // 查询购物车
    @RequestMapping("/changeShopcart")
    @ResponseBody()
    public String changeShopcart(final Shopcart shopcart, final HttpSession session) {
        final User user = (User) session.getAttribute("user");
        shopcart.setUid(user.getUid());
        this.shopcartService.Modify(shopcart);
        return "ok";
    }

    // 删除购物车
    @RequestMapping("/deleteShopcart")
    @ResponseBody()
    public String deleteShopcart(final Integer sid) {
        this.shopcartService.delete(sid);
        return "ok";
    }

    // 提交订单
    @RequestMapping("/submitOrder")
    @ResponseBody()
    public Map<String, String> submitOrder(final Double total, final HttpServletRequest request, final HttpSession session) {
        final Map<String, String> map = new HashMap<String, String>();
        final User user = (User) session.getAttribute("user");// 获取session中的用户信息
        final String[] ids = request.getParameterValues("cartIds[]");
        final Integer[] cartIds = new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            // 将String类型转换为Integer类型
            cartIds[i] = Integer.parseInt(ids[i]);
        }
        // 调用OrdersService方法
        final Integer oid = this.ordersService.insertOrders(user.getUid(), total, cartIds);
        map.put("result", oid + "");// 将订单的id返回
        return map;
    }

    // 通过分页查询订单详情
    @RequestMapping("/getOrderInfoByPage")
    @ResponseBody()
    public PageInfo<OrderitemPojo> getOrderInfoByPage(final Integer oid, final int page,
                                                      final int pageSize, final HttpSession session) {
        final User user = (User) session.getAttribute("user");
        if (user != null) {
            return this.orderitemService.getOrderitemByPage(oid, page, pageSize);
        } else {
            return null;
        }
    }

    // 付款
    @RequestMapping("/payOrders")
    @ResponseBody()
    public String payOrders(final Integer oid, final Double total) {
        this.ordersService.update(oid);
        return "ok";
    }

    // 通过分页查询订单详情[一条一条的]
    @RequestMapping("/getOrdersListByPage")
    @ResponseBody()
    public PageInfo<OrdersPojo> getOrdersListByPage(final int page, final int pageSize,
                                                    final HttpSession session) {
        final User user = (User) session.getAttribute("user");
        if (user != null) {
            return this.ordersService.getOrdersByPage(user.getUid(), page, pageSize);
        } else {
            return null;
        }
    }

    // 通过分页查询订单详情[分集合存储]
    @RequestMapping("/getOrdersListByUid")
    @ResponseBody()
    public PageInfo<List<OrderitemPojo>> getOrdersListByUid(final int page,
                                                            final int pageSize, final HttpSession session) {
        final User user = (User) session.getAttribute("user");
        if (user != null) {
            return this.ordersService.getOrdersByUid(user.getUid(), page, pageSize);
        } else {
            return null;
        }
    }

    // test http://localhost/shop/getOrdersListByUid?page=1&pageSize=5

    // 删除订单
    @RequestMapping("/deleteOrders")
    @ResponseBody()
    public String deleteOrders(final Integer oid) {
        this.ordersService.delete(oid);
        return "ok";
    }

    // 催单
    @RequestMapping("/remindOrders")
    @ResponseBody()
    public String remindOrders(final Integer oid) {
        this.ordersService.remind(oid);
        return "ok";
    }

    // 确认收货
    @RequestMapping("/receiveOrders")
    @ResponseBody()
    public String receiveOrders(final Integer oid) {
        this.ordersService.receive(oid);
        return "ok";
    }

    // 完成交易
    @RequestMapping("/completeOrders")
    @ResponseBody()
    public String completeOrders(final Integer oid) {
        // 更新订单状态
        this.ordersService.complete(oid);
        // 商品的销量更新
        this.ordersService.updateVolume(oid);
        return "ok";
    }

    // 获取评价项
    @RequestMapping("/getEvaluateitem")
    @ResponseBody()
    public OrderitemPojo getEvaluateitem(final int oid, final int pid) {
        return this.orderitemService.getOrderitemPojobyOidPid(oid, pid);
    }

    // 评价商品
    @RequestMapping("/evaluateOrders")
    @ResponseBody()
    public String evaluateOrders(final Integer pid, final String content, final HttpSession session) {
        final User user = (User) session.getAttribute("user");
        final Comment comment = new Comment();
        comment.setUid(user.getUid());
        comment.setPid(pid);
        comment.setContent(content);
        comment.setCreated(new Date());
        comment.setState(0);
        this.commentService.add(comment);
        return "ok";
    }

    // //2018-6-1

    /**
     * @return
     * @Title: getInventory
     * @Description: 获取商品的规格库存
     * @author xuchenxi
     * @date 2018年6月3日 下午6:40:45
     */
    @RequestMapping("getInventoryByPid")
    @ResponseBody()
    public List<Inventory> getInventoryByPid(final Integer pid) {
        return this.inventoryService.getInventoryList(pid);
    }

    @RequestMapping("getInventorySize")
    @ResponseBody()
    public List<Inventory> getInventorySize(final Integer pid) {
        return this.inventoryService.selectSize(pid);
    }

    @RequestMapping("getInventoryColor")
    @ResponseBody()
    public List<Inventory> getInventoryColor(final Integer pid) {
        return this.inventoryService.selectColor(pid);
    }

    // 直接购买 提交订单
    @RequestMapping("/addOrders")
    @ResponseBody()
    public Map<String, String> addOrders(final Double total, final HttpServletRequest request, final HttpSession session) {
        final Map<String, String> map = new HashMap<String, String>();
        final User user = (User) session.getAttribute("user");// 获取session中的用户信息
        if (user != null) {
            final int pid = Integer.parseInt(request.getParameter("pid"));
            final int count = Integer.parseInt(request.getParameter("count"));
            final int specid = Integer.parseInt(request.getParameter("specid"));
            final Integer oid = this.ordersService.insertOrdersByDirect(user.getUid(), pid, count, total, specid);
            map.put("result", oid + "");// 将订单的id返回
        } else {
            map.put("result", "error");// 未登录
        }
        return map;
    }

    //
    @RequestMapping("queryInventory")
    @ResponseBody()
    public Inventory queryInventory(final HttpServletRequest request) {
        final int pid = Integer.parseInt(request.getParameter("pid"));
        final String size = request.getParameter("size");
        final String color = request.getParameter("color");
        if (size == null || color == null) {
            return null;
        } else {
            return this.inventoryService.selectByTerm(pid, size, color);
        }
    }
}
