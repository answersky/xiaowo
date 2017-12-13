package com.xiaowo.controller.land;

import com.xiaowo.service.ApplyService;
import com.xiaowo.utils.SourceAnalysis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author answer
 *         2017/11/23
 *         着陆页
 */
@Controller
public class LandPageController {
    @Resource
    private ApplyService applyService;

    /**
     * 着陆页请求规则 page参数必须是着陆页的名称
     *
     * @param page
     * @return
     */
    @RequestMapping("/land/{page}")
    public String landPage(@PathVariable String page, HttpServletRequest request, Model model) {
        String sourceUrl = RefererFind.findReferer(request);
        //根据来源链接分析来源是百度、360、搜狗。。。
        String source = SourceAnalysis.analysisUrl(sourceUrl);
        model.addAttribute("source", source);

        recordVisitor(page);

        return "land/" + page;
    }

    /**
     * 旧版着陆页 迁移到新版保证旧版的链接能继续使用
     *
     * @return
     */
    @RequestMapping("/land*")
    public String oldLandPage(HttpServletRequest request) {
        //获取请求地址
        StringBuffer url = request.getRequestURL();
        String page = url.substring(url.indexOf("land"));

        recordVisitor(page);

        return "land/" + page;
    }

    private void recordVisitor(String page) {
        //查询该页面的记录
        Integer count = applyService.findVisitorCountByResource(page);
        if (count == null) {
            applyService.saveVisitorCount(page);
        } else {
            count = count + 1;
            applyService.updateVisitorCount(count, page);
        }
    }
}
