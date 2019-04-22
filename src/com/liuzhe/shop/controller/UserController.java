package com.liuzhe.shop.controller;

import com.liuzhe.shop.pojo.User;
import com.liuzhe.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/admin/userlist")
    public ModelAndView adminlist() {

        final List<User> userList = this.userService.getUserList();

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user_list");
        return modelAndView;
    }

    // 有条件的查询user
    @RequestMapping("/admin/selectUserByTerm")
    public ModelAndView selectUserByTerm(final User user) {
        final List<User> userList = this.userService.selectUserByTerm(user);
        final ModelAndView modelAndView = new ModelAndView();
        if (userList == null || userList.isEmpty()) {
            modelAndView.addObject("msg", "没有查询结果,请更换查询条件!");
        } else {
            modelAndView.addObject("userList", userList);
        }
        modelAndView.setViewName("user_list");
        return modelAndView;
    }

}
