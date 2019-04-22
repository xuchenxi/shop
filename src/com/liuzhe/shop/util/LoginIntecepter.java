package com.liuzhe.shop.util;

import com.liuzhe.shop.pojo.Adminuser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginIntecepter implements HandlerInterceptor {

    @Override
    public void afterCompletion(final HttpServletRequest arg0,
                                final HttpServletResponse arg1, final Object arg2, final Exception arg3)
            throws Exception {
        //完成之后执行
//		System.out.println("完成之后执行： afterCompletion ");
    }

    @Override
    public void postHandle(final HttpServletRequest arg0, final HttpServletResponse arg1,
                           final Object arg2, final ModelAndView arg3) throws Exception {
        //处理完毕之后执行
//		System.out.println("处理完毕之后执行:  postHandle");
    }


    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object obj) throws Exception {
        //处理之前执行
//		System.out.println("处理之前执行: preHandle");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");


        //1.判断session里有没有保存用户  2.判断uri路径
        final HttpSession session = request.getSession();

        final Adminuser admin = (Adminuser) session.getAttribute("adminuser");

        final String uri = request.getRequestURI();

        if (uri.endsWith("login.jsp") || uri.endsWith("login") || uri.endsWith(".jpg") || uri.endsWith("css") || uri.endsWith("js")) {
            //访问登录页面时，直接访问
            return true;
        } else if (admin != null) {
            //用户已经登录了，session中有用户的信息，可以访问admin/下的内容
            return true;
        } else {
            //其他情况，不允许访问/admin/下的内容  跳转到登录页面
//			System.out.println("--拦截--");
            final PrintWriter out = response.getWriter();
            out.print("<script>alert('您还未登录！请先完成登录后再操作！！');</script>");
            response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
//			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
        return false;
    }

}
