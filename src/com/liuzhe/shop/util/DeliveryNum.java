package com.liuzhe.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author xuchenxi
 * @ClassName: DeliveryNum
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018-5-30 上午09:10:27
 */
public class DeliveryNum {

    public static String getDeliveryNum() {
        final SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        final Date date = new Date();
        final String str = simpleDateFormat.format(date);
        final Random random = new Random();

        final int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return "liuzhe" + str + rannum;// 当前时间
    }
}