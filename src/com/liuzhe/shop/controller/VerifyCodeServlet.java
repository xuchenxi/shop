package com.liuzhe.shop.controller;

import com.liuzhe.shop.util.VerifyCode;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class VerifyCodeServlet extends HttpServlet {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4658217297311232156L;

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException {
        final VerifyCode vc = new VerifyCode();
        //获取一次性验证码图片
        final BufferedImage image = vc.getImage();
        //把图片写到指定流中
        VerifyCode.output(image, response.getOutputStream());
        // 把文本保存到session中，为LoginServlet验证做准备
        request.getSession().setAttribute("vCode", vc.getText());
    }

}
