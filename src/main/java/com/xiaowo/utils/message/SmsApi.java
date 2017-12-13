package com.xiaowo.utils.message;


import com.xiaowo.SmsEntity;
import com.xiaowo.utils.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by WeiHong on 2017/6/23.
 */
public class SmsApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsApi.class);

    public void sendCode(SmsEntity sms) {

        HashMap<String, Object> result = new HashMap<>();
        CCPRestSDK restAPI = new CCPRestSDK();
        // 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883.
        Properties properties = new Properties(null);
        try {
            properties.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        restAPI.init(properties.getValue("sms.serverIP"), properties.getValue("sms.serverPort"));
        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
        restAPI.setAccount(properties.getValue("sms.accountSid"), properties.getValue("sms.accountToken"));
        // 请使用管理控制台中已创建应用的APPID。
        restAPI.setAppId(sms.getAppId());
        try {
            result = restAPI.sendTemplateSMS(sms.getTo(), sms.getTemplateId(), sms.getDatas());
        } catch (Exception e) {
            LOGGER.error("发送短信验证码给手机号：{} 失败。", sms.getTo());
        }
        //System.out.println("SDKTestGetSubAccounts result=" + result);
        if (result != null && "000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                LOGGER.info(key + " = " + object);
            }
        } else {
            //异常返回输出错误码和错误信息
            LOGGER.info("发送验证码错误!");
        }

    }


}
