package com.xiaowo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author answer
 *         2017/12/12
 *         微信引导页
 */
@Controller
public class WebchatGuideController {

    @RequestMapping("/webchatGuide")
    public String webchatGuide(Model model) {
        return "webchat/webchat_guide";
    }
}
