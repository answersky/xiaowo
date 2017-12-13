package com.xiaowo.controller;

import com.utils.JsonUtils;
import com.xiaowo.FriendshipLink;
import com.xiaowo.Zone;
import com.xiaowo.service.FriendLinkService;
import com.xiaowo.service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/12/7
 */
@Controller
public class BrandBgController {
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private ZoneService zoneService;

    @RequestMapping("/brand_bg")
    public String brandBackground(Model model) {
        //开发区域
        List<Zone> zones = zoneService.findAllZones();
        model.addAttribute("zones", zones);
        model.addAttribute("zonesJson", JsonUtils.objectToJson(zones));

        //友情链接
        List<FriendshipLink> friendshipLinks = friendLinkService.findFriendLinks();
        model.addAttribute("friendshipLinks", friendshipLinks);

        //头部导航定位
        model.addAttribute("flag", "about_us");
        return "about/brand_bg";
    }
}
