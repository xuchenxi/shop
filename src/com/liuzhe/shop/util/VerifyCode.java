package com.liuzhe.shop.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author 徐晨曦
 * @ClassName VerifyCode.java
 * @Description TODO
 * @createTime 2019年03月18日 22:59:00
 */
public class VerifyCode {
    private int w = 70;
    private int h = 35;
    private Random r = new Random();
    /**
     * {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"}
     */
    private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
    private Color bgColor = new Color(255, 255, 255);
    private String text;

    private Color randomColor() {
        final int red = this.r.nextInt(150);
        final int green = this.r.nextInt(150);
        final int blue = this.r.nextInt(150);
        return new Color(red, green, blue);
    }

    private Font randomFont() {
        final int index = this.r.nextInt(this.fontNames.length);
        final String fontName = this.fontNames[index];
        final int style = this.r.nextInt(4);
        final int size = this.r.nextInt(5) + 24;
        return new Font(fontName, style, size);
    }

    private void drawLine(final BufferedImage image) {
        final int num = 3;
        final Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            final int x1 = this.r.nextInt(this.w);
            final int y1 = this.r.nextInt(this.h);
            final int x2 = this.r.nextInt(this.w);
            final int y2 = this.r.nextInt(this.h);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    private char randomChar() {
        final int index = this.r.nextInt(this.codes.length());
        return this.codes.charAt(index);
    }

    private BufferedImage createImage() {
        final BufferedImage image = new BufferedImage(this.w, this.h, BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, this.w, this.h);
        return image;
    }

    public BufferedImage getImage() {
        final BufferedImage image = this.createImage();
        final Graphics2D g2 = (Graphics2D) image.getGraphics();
        final StringBuilder sb = new StringBuilder();
        // 向图片中画4个字符
        for (int i = 0; i < 4; i++) {
            final String s = this.randomChar() + "";
            sb.append(s);
            final float x = i * 1.0F * this.w / 4;
            g2.setFont(this.randomFont());
            g2.setColor(this.randomColor());
            g2.drawString(s, x, this.h - 5);
        }
        this.text = sb.toString();
        this.drawLine(image);
        return image;
    }

    public String getText() {
        return this.text;
    }

    public static void output(final BufferedImage image, final OutputStream out)
            throws IOException {
        ImageIO.write(image, "JPEG", out);
    }
}

