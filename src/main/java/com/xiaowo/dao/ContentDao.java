package com.xiaowo.dao;

import com.xiaowo.Content;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author answer
 *         2017/12/5
 */
public interface ContentDao {
    /**
     * 根据关键字查询目录id
     *
     * @param keyword
     * @return
     */
    Integer findCategoryIdByKeyword(String keyword);

    /**
     * 首页的banner
     *
     * @param categoryId
     * @param recommend
     * @param page
     * @return
     */
    List<Content> findContentByCategoryId(@Param("categoryId") Integer categoryId, @Param("recommend") String recommend, @Param("page") Integer page);

    /**
     * 查询文章
     *
     * @param categoryId
     * @return
     */
    List<Content> findFirstBannerByCategoryId(Integer categoryId);

    /**
     * 首页合作伙伴
     *
     * @param categoryId
     * @return
     */
    List<Content> findFirstPartnerByCategoryId(Integer categoryId);

    /**
     * 根据id 查询文章
     *
     * @param id
     * @return
     */
    Content findContentById(Integer id);

    /**
     * 总数
     *
     * @param categoryId
     * @return
     */
    Integer count(Integer categoryId);

    /**
     * 查询品牌动态下的banner
     *
     * @param categoryId
     * @return
     */
    Content findBrandBanner(Integer categoryId);

    /**
     * 上一篇文章
     *
     * @param categoryId
     * @param id
     * @return
     */
    Content preContent(@Param("categoryId") Integer categoryId, @Param("id") Integer id);

    /**
     * 下一篇文章
     *
     * @param categoryId
     * @param id
     * @return
     */
    Content nextContent(@Param("categoryId") Integer categoryId, @Param("id") Integer id);

    /**
     * 相关新闻
     *
     * @param categoryId
     * @return
     */
    List<Content> relativeContent(@Param("categoryId") Integer categoryId);

    /**
     * 热门文章
     *
     * @param ids
     * @return
     */
    List<Content> hotContent(@Param("ids") List<Integer> ids);
}
