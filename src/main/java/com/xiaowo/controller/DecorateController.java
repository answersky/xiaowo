package com.xiaowo.controller;

import com.utils.JsonUtils;
import com.xiaowo.FriendshipLink;
import com.xiaowo.Problem;
import com.xiaowo.Zone;
import com.xiaowo.service.FriendLinkService;
import com.xiaowo.service.ProblemService;
import com.xiaowo.service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/12/6
 */
@Controller
public class DecorateController {
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private ZoneService zoneService;
    @Resource
    private ProblemService problemService;

    @RequestMapping("/decorate")
    public String decorate(Model model) {
        //开发区域
        List<Zone> zones = zoneService.findAllZones();
        model.addAttribute("zones", zones);
        model.addAttribute("zonesJson", JsonUtils.objectToJson(zones));

        //友情链接
        List<FriendshipLink> friendshipLinks = friendLinkService.findFriendLinks();
        model.addAttribute("friendshipLinks", friendshipLinks);

        //常见问题
        List<Problem> problems = problemService.findProblems();
        model.addAttribute("problems", problems);

        //头部导航定位
        model.addAttribute("flag", "decorate");

        return "decorate/decorate";
    }
}
