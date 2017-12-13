package com.xiaowo.controller.h5;

import com.xiaowo.wxshare.WechatShareUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author answer
 *         2017/11/23
 */
@Controller
public class FirstH5Controller {
    private static final Logger logger = LoggerFactory.getLogger(FirstH5Controller.class);

    @RequestMapping("/h5")
    public String h5(HttpServletRequest request) {
        try {
            Map<String, String> map = WechatShareUtil.getWechatSign(request);
            logger.info("result:" + map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "h5/index";
    }
}
