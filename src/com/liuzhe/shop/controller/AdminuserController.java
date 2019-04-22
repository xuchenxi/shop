package com.liuzhe.shop.controller;

import com.github.pagehelper.PageInfo;
import com.liuzhe.shop.pojo.Adminuser;
import com.liuzhe.shop.service.AdminuserService;
import com.liuzhe.shop.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 知识点【@RequestMapping】 //使用RequestMapping注解 在类名前添加统一路径
 * 配置@RequestMapping时可省略后缀(.htm),注意访问的时候不能省略
 */
@Controller
@RequestMapping("/admin")
public class AdminuserController {
    @Autowired
    private AdminuserService adminuserService;

    /**
     * 后台登录
     * xuchenxi
     * @param adminuser
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(final Adminuser adminuser, final HttpSession session) {
        final Adminuser admin = this.adminuserService.login(adminuser.getUsername(), adminuser.getPassword());
        if (admin != null) {
            session.setAttribute("adminuser", admin);
            return "index";
        }
        return "login";
    }


    /**
     * 根据用户名和管理员类型进行迷糊查询
     *
     * @param adminuser
     * @return
     */
    @RequestMapping("/selectAdminuserByTerm")
    public ModelAndView selectAdminuserByTerm(final Adminuser adminuser) {
        final List<Adminuser> list = this.adminuserService.selectAdminuserByTerm(adminuser);
        final ModelAndView modelAndView = new ModelAndView();
        if (list == null || list.isEmpty()) {
            modelAndView.addObject("msg", "没有查询结果,请更换查询条件!");
        } else {
            modelAndView.addObject("adminlist", list);
        }
        modelAndView.setViewName("admin_list");
        return modelAndView;
    }

    @RequestMapping("/adminlist")
    public ModelAndView adminlist() throws MyException {
        // 模拟异常 之 未知异常
        final List<Adminuser> list = this.adminuserService.getAdminUserList();
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("adminlist", list);
        modelAndView.setViewName("admin_list");
        return modelAndView;
    }

    // 通过分页查询管理员列表
    @RequestMapping("/adminListByPage")
    @ResponseBody()
    public PageInfo<Adminuser> adminListByPage(final int page, final int pageSize) {
        return this.adminuserService.getAdminListByPage(page, pageSize);
    }

    // 使用RESTful风格
    @RequestMapping("/adminEdit/{uid}")
    public ModelAndView adminEdit(@PathVariable() final Integer uid) {
        // 访问services
        final Adminuser admin = this.adminuserService.getAdminuserById(uid);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin", admin);
        modelAndView.setViewName("/admin/edit_admin");
        return modelAndView;
    }

    // 修改
    @RequestMapping("adminModify")
    public String adminModify(final Adminuser adminuser) {
        // 访问services
        this.adminuserService.adminModify(adminuser);
        // 重定向页面
        return "redirect:/admin/adminlist";
    }

    // 添加
    @RequestMapping("/addAdmin")
    public String addAdmin(final Adminuser adminuser) {
        // 访问services

        this.adminuserService.addAdmin(adminuser);

        // 重定向页面
        return "redirect:adminlist";
    }

    // 删除

    // @ResponseBody() 注解
    @RequestMapping("/deleteAdmin")
    @ResponseBody()
    public String deleteAdmin(final Integer uid) {

        this.adminuserService.deleteAdmin(uid);
        return "ok";
    }

    // @ResponseBody() 注解
    @RequestMapping("/batchDel")
    @ResponseBody()
    public String batchDelAdmin(@RequestParam(value = "uIds[]") final Integer[] uIds) {
        for (int i = 0; i < uIds.length; i++) {
            this.adminuserService.deleteAdmin(uIds[i]);
        }
        return "ok";
    }

}
