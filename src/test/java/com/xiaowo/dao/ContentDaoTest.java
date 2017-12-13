package com.xiaowo.dao;

import com.xiaowo.BaseTest;
import com.xiaowo.Content;
import com.xiaowo.utils.Constant;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author answer
 *         2017/12/5
 */
public class ContentDaoTest extends BaseTest {
    @Resource
    private ContentDao contentDao;

    @Test
    public void findCategoryIdByKeyword() throws Exception {
        Integer categoryId = contentDao.findCategoryIdByKeyword(Constant.FIRSTBANNER);
        System.out.println(categoryId);
    }

    @Test
    public void findFirstBannerByCategoryId() throws Exception {
        List<Content> list = contentDao.findFirstBannerByCategoryId(29);
        System.out.println(list);
    }

    @Test
    public void findFirstPartnerByCategoryId() throws Exception {
        List<Content> list = contentDao.findFirstPartnerByCategoryId(30);
        System.out.println(list);
    }
}