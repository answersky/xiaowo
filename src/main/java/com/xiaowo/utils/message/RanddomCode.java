package com.xiaowo.utils.message;

import java.util.Random;

/**
 * 随机生成6位数验证码
 * Created by WeiHong on 2017/6/23.
 */
public class RanddomCode {

    public static String getSixCode() {
        Random rad = new Random();
        String result = rad.nextInt(1000000) + "";
        if (result.length() != 6) {
            return getSixCode();
        }
        return result;
    }
}
