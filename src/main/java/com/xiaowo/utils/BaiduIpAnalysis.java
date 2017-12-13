package com.xiaowo.utils;

import com.utils.JsonUtils;
import com.utils.OkhttpUtil;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author answer
 *         2017/11/27
 */
public class BaiduIpAnalysis {
    private static final String URL = "http://api.map.baidu.com/location/ip";
    private static final String AK = "n1mGTnCWGFRA94q35ulIE4rT";

    /**
     * 百度ip分析
     *
     * @param ip
     * @return
     */
    public static String analysisIp(String ip) {
        String city = null;
        String requestUrl = URL + "?ak=" + AK + "&ip=" + ip;
        try {
            String json = OkhttpUtil.getRequest(requestUrl, 3);
            if (!StringUtils.isEmpty(json)) {
                Map map = JsonUtils.mapFormJSONStr(json);
//                System.out.println(map);
                Map<String, Object> cMap = (Map<String, Object>) map.get("content");
                if (cMap != null) {
                    Map<String, Object> contentMap = (Map<String, Object>) cMap.get("address_detail");
                    if (contentMap != null) {
                        city = (String) contentMap.get("city");
                        city = city.replace("市", "");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return city;
    }

    public static void main(String[] args) {
        //深圳 183.14.132.247
        //太原 218.26.7.131
        //武汉 59.172.75.112
        //东莞 125.93.75.177
        //黄冈 221.233.144.0
        String city = analysisIp("218.26.7.131");
        System.out.println(city);
    }
}
