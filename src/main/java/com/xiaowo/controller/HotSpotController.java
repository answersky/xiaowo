package com.xiaowo.controller;

import com.utils.JsonUtils;
import com.xiaowo.Content;
import com.xiaowo.FriendshipLink;
import com.xiaowo.Zone;
import com.xiaowo.service.ContentService;
import com.xiaowo.service.ContentVisitorService;
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
 *         热门专区
 */
@Controller
public class HotSpotController {
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private ZoneService zoneService;
    @Resource
    private ContentService contentService;
    @Resource
    private ContentVisitorService contentVisitorService;

    /**
     * 专题活动
     *
     * @param model
     * @return
     */
    @RequestMapping("/hot_subject")
    public String hotSubject(Model model) {

        //共同信息
        commonInfo(model);
        textListInfo(model, Constant.HOTSUBJECT, 1, "hot_subject");

        return "hot/hot_subject_list";
    }

    @RequestMapping("/hot_subject/{currentPage}")
    public String hotSubject(Model model, @PathVariable Integer currentPage) {
        commonInfo(model);
        textListInfo(model, Constant.HOTSUBJECT, currentPage, "hot_subject");
        return "hot/subject_list_content";
    }

    @RequestMapping("{type}/detail/{id}")
    public String subjectDetail(Model model, @PathVariable String type, @PathVariable Integer id, Integer categoryId) {
        //记录文章点击的日志
        contentVisitorService.saveVisitorLog(id);
        Content text = contentService.findContentById(id);
        model.addAttribute("text", text);
        commonInfo(model);
        model.addAttribute("type", type);
        //上一篇
        Content preContent = contentService.preContent(categoryId, id);
        model.addAttribute("preContent", preContent);
        //下一篇
        Content nextContent = contentService.nextContent(categoryId, id);
        model.addAttribute("nextContent", nextContent);

        //相关文章
        List<Content> relativeContents = contentService.relativeContent(categoryId);
        model.addAttribute("relativeContents", relativeContents);

        //热门推荐
        List<Content> hotContents = contentService.hotContent();
        model.addAttribute("hotContents", hotContents);

        return "hot/detail";
    }


    /**
     * 装修攻略
     */
    @RequestMapping("/decorateStrategy")
    public String decorateStrategy(Model model) {
        commonInfo(model);
        textListInfo(model, Constant.HOTDECORATE, 1, "decorateStrategy");
        return "hot/news_list";
    }

    @RequestMapping("/decorateStrategy/{currentPage}")
    public String decorateStrategy(Model model, @PathVariable Integer currentPage) {
        commonInfo(model);
        textListInfo(model, Constant.HOTDECORATE, currentPage, "decorateStrategy");
        return "hot/list_content";
    }

    /**
     * 分期攻略
     */
    @RequestMapping("/divideStrategy")
    public String divideStrategy(Model model) {
        commonInfo(model);
        textListInfo(model, Constant.HOTDIVIDE, 1, "divideStrategy");
        return "hot/news_list";
    }

    @RequestMapping("/divideStrategy/{currentPage}")
    public String divideStrategy(Model model, @PathVariable Integer currentPage) {
        commonInfo(model);
        textListInfo(model, Constant.HOTDIVIDE, currentPage, "divideStrategy");
        return "hot/list_content";
    }

    /**
     * 新闻列表信息
     *
     * @param model
     * @param type
     * @param currentPage
     */
    private void textListInfo(Model model, String type, Integer currentPage, String pageUrl) {
        //总页数
        Integer pages = contentService.pages(type);
        model.addAttribute("pages", pages);

        //获取第一页的文章列表
        List<Content> texts = contentService.findContentByOnlyFlag(type, null, currentPage);
        model.addAttribute("texts", texts);
        model.addAttribute("currentPage", currentPage);
        //分页链接信息
        model.addAttribute("pageUrl", pageUrl);
    }

    /**
     * 头部，底部共用信息
     *
     * @param model
     */
    private void commonInfo(Model model) {
        //开发区域
        List<Zone> zones = zoneService.findAllZones();
        model.addAttribute("zones", zones);
        model.addAttribute("zonesJson", JsonUtils.objectToJson(zones));

        //友情链接
        List<FriendshipLink> friendshipLinks = friendLinkService.findFriendLinks();
        model.addAttribute("friendshipLinks", friendshipLinks);

        //头部导航定位
        model.addAttribute("flag", "index");
    }
}
