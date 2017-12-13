package com.xiaowo.controller;

import com.utils.JsonUtils;
import com.xiaowo.Department;
import com.xiaowo.FriendshipLink;
import com.xiaowo.Recruit;
import com.xiaowo.Zone;
import com.xiaowo.service.FriendLinkService;
import com.xiaowo.service.RecruitService;
import com.xiaowo.service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
@Controller
public class JoinUsController {
    @Resource
    private RecruitService recruitService;
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private ZoneService zoneService;

    @RequestMapping("/joinUs")
    public String joinUs(Model model, Integer departmentId, Integer zoneId, String type) {
        List<Recruit> recruits = recruitService.findRecruits(departmentId, zoneId, type);
        model.addAttribute("recruits", recruits);
        List<Department> departments = recruitService.findAllDepartments();
        model.addAttribute("departments", departments);
        List<Zone> zones = recruitService.findAllZones();
        model.addAttribute("zones", zones);

        //开发区域
        model.addAttribute("zonesJson", JsonUtils.objectToJson(zones));

        //友情链接
        List<FriendshipLink> friendshipLinks = friendLinkService.findFriendLinks();
        model.addAttribute("friendshipLinks", friendshipLinks);

        model.addAttribute("departmentId", departmentId);
        model.addAttribute("zoneId", zoneId);
        model.addAttribute("type", type);

        //头部导航定位
        model.addAttribute("flag", "about_us");

        return "about/join_us";
    }
}
