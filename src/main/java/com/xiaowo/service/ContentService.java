package com.xiaowo.service;

import com.xiaowo.Content;

import java.util.List;

/**
 * @author answer
 *         2017/12/5
 */
public interface ContentService {

    /**
     * 根据唯一标识取数据
     *
     * @param flag
     * @param recommend
     * @param page
     * @return
     */
    List<Content> findContentByOnlyFlag(String flag, String recommend, Integer page);

    /**
     * 首页banner
     *
     * @param flag
     * @return
     */
    List<Content> findFirstBannerByOnlyFlag(String flag);

    List<Content> findFirstPartnerByOnlyFlag(String flag);

    /**
     * 根据id查询文章
     *
     * @param id
     * @return
     */
    Content findContentById(Integer id);

    /**
     * 品牌动态的banner
     *
     * @param flag
     * @return
     */
    Content findBrandBanner(String flag);

    /**
     * 查询某个栏目下的文章总页数
     *
     * @param flag
     * @return
     */
    Integer pages(String flag);

    /**
     * 上一篇文章
     *
     * @param categoryId
     * @param id
     * @return
     */
    Content preContent(Integer categoryId, Integer id);

    /**
     * 下一篇文章
     *
     * @param categoryId
     * @param id
     * @return
     */
    Content nextContent(Integer categoryId, Integer id);

    /**
     * 相关新闻
     *
     * @param categoryId
     * @return
     */
    List<Content> relativeContent(Integer categoryId);

    /**
     * 热门文章
     *
     * @return
     */
    List<Content> hotContent();
}
