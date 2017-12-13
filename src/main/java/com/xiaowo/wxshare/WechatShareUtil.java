package com.xiaowo.wxshare;

import com.utils.JsonUtils;
import com.utils.OkhttpUtil;
import com.xiaowo.utils.Properties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author answer
 *         2017/11/23
 *         微信分享
 */
@Component
public class WechatShareUtil {

    /**
     * 获取签名信息
     *
     * @return 返回签名等
     */
    public static Map<String, String> getWechatSign(HttpServletRequest request) throws UnsupportedEncodingException {
        Properties properties = new Properties(null);
        try {
            properties.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String appid = properties.getValue("wechat.appId");
        String appSecret = properties.getValue("wechat.secret");
        String urlTemplateGetAccessToken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
        String urlTemplateGetAccessTicket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

        //获取token
        String urlGetAccessToken = String.format(urlTemplateGetAccessToken, appid, appSecret);
        Map accessTokenMap = findResultMap(urlGetAccessToken);
        String accessToken = (String) accessTokenMap.get("access_token");


        //获取ticket
        String urlGetAccessTicket = String.format(urlTemplateGetAccessTicket, accessToken);
        Map urlGetAccessTicketMap = findResultMap(urlGetAccessTicket);
        String accessTicket = (String) urlGetAccessTicketMap.get("ticket");


        // 时间戳
        Long timeStamp = System.currentTimeMillis() / 1000;

        String url = request.getRequestURL().toString();

        //随机字串
        String noncestr = UUID.randomUUID().toString();

        //签名
        String signature = getSignature(noncestr, accessTicket, url, timeStamp);

        Map<String, String> result = new LinkedHashMap<>();
        result.put("appId", appid);
        result.put("timestamp", timeStamp.toString());
        result.put("nonceStr", noncestr);
        result.put("signature", signature);

        return result;
    }

    private static Map findResultMap(String url) {
        Map map = new LinkedHashMap<>();
        try {
            String json = OkhttpUtil.getRequest(url);
            if (!StringUtils.isEmpty(json)) {
                map = JsonUtils.mapFormJSONStr(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 生成签名
     *
     * @param nonceStr     随机字串
     * @param jsapi_ticket 票据
     * @param url
     * @param timestamp    时间戳
     * @return
     */
    private static String getSignature(String nonceStr, String jsapi_ticket, String url, Long timestamp) {
        String template = "jsapi_ticket=%s&noncestr=%s×tamp=%s&url=%s";
        String result = String.format(template, jsapi_ticket, nonceStr, timestamp, url);

        return org.apache.commons.codec.digest.DigestUtils.shaHex(result);
    }

}
