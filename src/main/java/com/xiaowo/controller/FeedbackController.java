package com.xiaowo.controller;

import com.utils.JsonUtils;
import com.xiaowo.FriendshipLink;
import com.xiaowo.Zone;
import com.xiaowo.service.FeedBackService;
import com.xiaowo.service.FriendLinkService;
import com.xiaowo.service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/11/23
 */
@Controller
public class FeedbackController {
    @Resource
    private FeedBackService feedBackService;
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private ZoneService zoneService;

    @RequestMapping("/feedback")
    public String feedback(Model model) {
        //开发区域
        List<Zone> zones = zoneService.findAllZones();
        model.addAttribute("zones", zones);
        model.addAttribute("zonesJson", JsonUtils.objectToJson(zones));

        //友情链接
        List<FriendshipLink> friendshipLinks = friendLinkService.findFriendLinks();
        model.addAttribute("friendshipLinks", friendshipLinks);

        //头部导航定位
        model.addAttribute("flag", "index");

        return "help/feedback";
    }

    @RequestMapping("/saveFeedback")
    @ResponseBody
    public Integer saveFeedback(String content, String tel) {
        feedBackService.saveFeedback(content, tel);
        return 1;
    }
}
