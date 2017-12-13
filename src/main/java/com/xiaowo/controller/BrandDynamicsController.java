package com.xiaowo.controller;

import com.utils.JsonUtils;
import com.xiaowo.Content;
import com.xiaowo.FriendshipLink;
import com.xiaowo.Zone;
import com.xiaowo.service.ContentService;
import com.xiaowo.service.FriendLinkService;
import com.xiaowo.service.ZoneService;
import com.xiaowo.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/12/7
 */
@Controller
public class BrandDynamicsController {
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private ZoneService zoneService;
    @Resource
    private ContentService contentService;

    @RequestMapping("/brand_dynamics")
    public String brandDynamics(Model model) {

        //品牌动态的banner
        Content content = contentService.findBrandBanner(Constant.ABOUTUSBANNER);
        model.addAttribute("brandBanner", content);

        //总页数
        Integer pages = contentService.pages(Constant.ABOUTUSTEXT);
        model.addAttribute("pages", pages);

        //获取第一页的文章列表
        List<Content> brandTexts = contentService.findContentByOnlyFlag(Constant.ABOUTUSTEXT, null, 1);
        model.addAttribute("brandTexts", brandTexts);
        model.addAttribute("currentPage", 1);


        //开发区域
        List<Zone> zones = zoneService.findAllZones();
        model.addAttribute("zones", zones);
        model.addAttribute("zonesJson", JsonUtils.objectToJson(zones));

        //友情链接
        List<FriendshipLink> friendshipLinks = friendLinkService.findFriendLinks();
        model.addAttribute("friendshipLinks", friendshipLinks);

        //头部导航定位
        model.addAttribute("flag", "about_us");
        return "about/brand_dynamics";
    }

    @RequestMapping("/findBrandByCurrentPage/{currentPage}")
    public String findBrandByCurrentPage(Model model, @PathVariable Integer currentPage) {
        //总页数
        Integer pages = contentService.pages(Constant.ABOUTUSTEXT);
        model.addAttribute("pages", pages);

        //获取第一页的文章列表
        List<Content> brandTexts = contentService.findContentByOnlyFlag(Constant.ABOUTUSTEXT, null, currentPage);
        model.addAttribute("brandTexts", brandTexts);
        model.addAttribute("currentPage", currentPage);
        return "about/brand_text_list";
    }
}
