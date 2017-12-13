package com.xiaowo.controller;

import com.utils.JsonUtils;
import com.xiaowo.Content;
import com.xiaowo.FriendshipLink;
import com.xiaowo.Zone;
import com.xiaowo.service.CacheTestService;
import com.xiaowo.service.ContentService;
import com.xiaowo.service.FriendLinkService;
import com.xiaowo.service.ZoneService;
import com.xiaowo.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 */
@Controller
public class IndexController {
    @Resource
    private CacheTestService cacheTestService;
    @Resource
    private ContentService contentService;
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private ZoneService zoneService;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String index(Model model){
        long s1 = System.currentTimeMillis();
        //首页banner
        List<Content> banners = contentService.findFirstBannerByOnlyFlag(Constant.FIRSTBANNER);
        model.addAttribute("banners", banners);
        logger.info("banner花费的时间：" + (System.currentTimeMillis() - s1));


        //开发区域
        List<Zone> zones = zoneService.findAllZones();
        model.addAttribute("zones", zones);
        model.addAttribute("zonesJson", JsonUtils.objectToJson(zones));

        //友情链接
        List<FriendshipLink> friendshipLinks = friendLinkService.findFriendLinks();
        model.addAttribute("friendshipLinks", friendshipLinks);

        //头部导航定位
        model.addAttribute("flag", "index");
        return "home/index";
    }

    @RequestMapping("/cacheTest")
    @ResponseBody
    public String cacheTest(Integer id) {
        return cacheTestService.getCache(id);
    }

}
