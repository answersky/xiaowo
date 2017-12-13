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
import java.util.Map;

/**
 * @author answer
 *         2017/11/27
 */
@Controller
public class HelpCenterController {
    @Resource
    private ProblemService problemService;
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private ZoneService zoneService;

    @RequestMapping("/problems")
    public String problems(Model model) {
        Map<String, List<Problem>> problems = problemService.problems();
        model.addAttribute("problems", problems);

        //开发区域
        List<Zone> zones = zoneService.findAllZones();
        model.addAttribute("zones", zones);
        model.addAttribute("zonesJson", JsonUtils.objectToJson(zones));

        //友情链接
        List<FriendshipLink> friendshipLinks = friendLinkService.findFriendLinks();
        model.addAttribute("friendshipLinks", friendshipLinks);

        //头部导航定位
        model.addAttribute("flag", "problems");

        return "help/help_center";
    }

}
