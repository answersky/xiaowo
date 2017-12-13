package com.xiaowo.utils;

import org.springframework.util.StringUtils;

/**
 * @author answer
 *         2017/12/4
 *         外部链接字典
 */
public class SourceAnalysis {
    /**
     * 今日头条
     */
    private static final String TOUTIAO = "toutiao";
    /**
     * 百度
     */
    private static final String BAIDU = "baidu";
    /**
     * 搜狗
     */
    private static final String SOUGOU = "sogou";
    /**
     * 360
     */
    private static final String SITE360 = "360.";
    /**
     * 58
     */
    private static final String SITE58 = "58.";


    public static void main(String[] args) {
        String url = "";
    }

    public static String analysisUrl(String url) {
        String resource = "";
        if (StringUtils.isEmpty(url)) {
            //官网
            resource = "website";
        } else {
            if (url.toLowerCase().contains(BAIDU.toLowerCase())) {
                resource = "baidu";
            }
            if (url.toLowerCase().contains(SOUGOU.toLowerCase())) {
                resource = "sogou";
            }
            if (url.toLowerCase().contains(SITE360.toLowerCase())) {
                resource = "360";
            }
            if (url.toLowerCase().contains(SITE58.toLowerCase())) {
                resource = "58";
            }
        }
        return resource;
    }
}
