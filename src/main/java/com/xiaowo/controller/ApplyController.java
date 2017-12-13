package com.xiaowo.controller;

import com.xiaowo.SmsEntity;
import com.xiaowo.service.ApplyService;
import com.xiaowo.service.IRedisService;
import com.xiaowo.utils.Properties;
import com.xiaowo.utils.message.RanddomCode;
import com.xiaowo.utils.message.SmsApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author answer
 *         2017/11/27
 */
@Controller
public class ApplyController {
    @Resource
    private ApplyService applyService;
    @Resource
    private IRedisService redisService;

    @RequestMapping("/apply")
    @ResponseBody
    public String apply(HttpServletRequest request, String username, String tel, String city, String channel, String resource, String source) {
        String message = applyService.apply(username, tel, city, channel, resource, source);

        return message;
    }

    @RequestMapping("/sendCode")
    @ResponseBody
    public Map sendCode(String phone) {
        Properties properties = new Properties(null);
        try {
            properties.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> resultMap = new HashMap<>(1);
        resultMap.put("state", "error");
        byte[] bytes = redisService.get("SMSCODE" + phone);
        if (bytes == null || bytes.length == 0) {
            //6位数验证码
            String sixCode = RanddomCode.getSixCode();
            SmsApi smsApi = new SmsApi();
            SmsEntity sms = new SmsEntity(properties.getValue("sms.appID"), phone, "36573", new String[]{sixCode});
            smsApi.sendCode(sms);
            redisService.set("SMSCODE" + phone, sixCode, 2 * 60);
            resultMap.put("state", "success");
        }
        return resultMap;
    }

    @RequestMapping("/validateSmsCode")
    @ResponseBody
    public Map validateSmsCode(String phone, String code) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("state", "error");
        if (phone == null || code == null) {
            resultMap.put("msg", "参数错误");
        } else {
            byte[] bytes = redisService.get("SMSCODE" + phone);
            if (bytes != null && bytes.length > 0) {
                try {
                    String relPhone = new String(bytes, "UTF-8");
                    if (relPhone.equals(code)) {
                        resultMap.put("state", "success");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultMap;
    }
}
