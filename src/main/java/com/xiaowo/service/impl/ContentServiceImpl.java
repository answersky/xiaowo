package com.xiaowo.service.impl;

import com.utils.JsonUtils;
import com.xiaowo.Content;
import com.xiaowo.Tag;
import com.xiaowo.dao.*;
import com.xiaowo.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author answer
 *         2017/12/5
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Resource
    private ContentDao contentDao;
    @Resource
    private TagDao tagDao;
    @Resource
    private PictureDao pictureDao;
    @Resource
    private TextDao textDao;
    @Resource
    private ContentVisitorDao contentVisitorDao;

    private static final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);

    /**
     * 获取更新的内容
     *
     * @param flag
     * @return
     */
    @Override
    public List<Content> findContentByOnlyFlag(String flag, String recommend, Integer page) {
        long s1 = System.currentTimeMillis();
        Integer categoryId = findCategoryIdByKeyword(flag);
        logger.info("查询分类花费的时间：" + (System.currentTimeMillis() - s1));
        long s2 = System.currentTimeMillis();
        //分页
        page = (page - 1) * 10;
        List<Content> contents = contentDao.findContentByCategoryId(categoryId, recommend, page);
        logger.info("查询banner花费的时间：" + (System.currentTimeMillis() - s2));
        long s4 = System.currentTimeMillis();
        formatContent(contents);
        logger.info("format花费的时间：" + (System.currentTimeMillis() - s4));
        return contents;
    }

    /**
     * 首页banner
     *
     * @param flag
     * @return
     */
    @Override
    public List<Content> findFirstBannerByOnlyFlag(String flag) {
        long s1 = System.currentTimeMillis();
        Integer categoryId = findCategoryIdByKeyword(flag);
        logger.info("查询分类花费的时间：" + (System.currentTimeMillis() - s1));
        long s2 = System.currentTimeMillis();
        List<Content> contents = contentDao.findFirstBannerByCategoryId(categoryId);
        logger.info("查询banner花费的时间：" + (System.currentTimeMillis() - s2));
        long s4 = System.currentTimeMillis();
        formatContent(contents);
        logger.info("format花费的时间：" + (System.currentTimeMillis() - s4));
        return contents;
    }

    @Override
    public List<Content> findFirstPartnerByOnlyFlag(String flag) {
        Integer categoryId = findCategoryIdByKeyword(flag);
        return contentDao.findFirstPartnerByCategoryId(categoryId);
    }

    @Override
    public Content findContentById(Integer id) {
        Content content = contentDao.findContentById(id);
        format(content);
        return content;
    }

    /**
     * 品牌动态banner
     *
     * @param flag
     * @return
     */
    @Override
    public Content findBrandBanner(String flag) {
        Integer categoryId = findCategoryIdByKeyword(flag);
        Content content = contentDao.findBrandBanner(categoryId);
        format(content);
        return content;
    }

    /**
     * 计算总页数
     *
     * @param flag
     * @return
     */
    @Override
    @Cacheable(value = "baseCache", key = "'pages'+#flag")
    public Integer pages(String flag) {
        Integer categoryId = findCategoryIdByKeyword(flag);
        Integer count = contentDao.count(categoryId);
        Integer pages = (count + 10 - 1) / 10;
        return pages;
    }

    @Override
    public Content preContent(Integer categoryId, Integer id) {
        return contentDao.preContent(categoryId, id);
    }

    @Override
    public Content nextContent(Integer categoryId, Integer id) {
        return contentDao.nextContent(categoryId, id);
    }

    @Override
    public List<Content> relativeContent(Integer categoryId) {
        return contentDao.relativeContent(categoryId);
    }

    @Override
    public List<Content> hotContent() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        String sTime = sdf.format(c.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        String eTime = sdf.format(calendar.getTime());
        List<Integer> ids = contentVisitorDao.findHotContentId(sTime, eTime);
        if (ids != null && ids.size() > 0) {
            List<Content> list = contentDao.hotContent(ids);
            return list;
        }
        return null;
    }

    /**
     * 此处可做缓存优化(根据flag来做key）
     *
     * @param flag
     * @return
     */
    @Cacheable(value = "baseCache", key = "'cache'+#flag")
    public Integer findCategoryIdByKeyword(String flag) {
        return contentDao.findCategoryIdByKeyword(flag);
    }

    private void formatContent(List<Content> contents) {
        if (contents != null && contents.size() > 0) {
            for (Content content : contents) {
                format(content);
            }
        }
    }

    private void format(Content content) {
        if (content == null) {
            return;
        }
        //标签
        String tags = content.getTags();
        if (tags != null) {
            String tagStr = "";
            List tagList = JsonUtils.listFormJSONStr(tags);
            for (int i = 0; i < tagList.size(); i++) {
                Integer tagId = (Integer) tagList.get(i);
                Tag tag = tagDao.findTagById(tagId);
                if (i == 0) {
                    tagStr = tag.getTag();
                } else {
                    tagStr = tagStr + "," + tag.getTag();
                }
            }
            content.setTags(tagStr);
        }

       /* //图片
        Integer picId = content.getPicId();
        if (picId != null) {
            Picture picture = pictureDao.findPictureById(picId);
            content.setPicture(picture);
        }

        //文章
        Integer textId = content.getTextId();
        if (textId != null) {
            Text text = textDao.findTextById(textId);
            content.setText(text);
        }*/
    }
}
