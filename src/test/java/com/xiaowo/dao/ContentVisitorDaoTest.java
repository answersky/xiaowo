package com.xiaowo.dao;

import com.xiaowo.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author answer
 *         2017/12/8
 */
public class ContentVisitorDaoTest extends BaseTest {
    @Resource
    private ContentVisitorDao contentVisitorDao;

    @Test
    public void findHotContentId() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(sdf.format(c.getTime()));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        System.out.println(sdf.format(calendar.getTime()));

        List<Integer> ids = contentVisitorDao.findHotContentId("2017-12-01", "2018-01-01");
        System.out.println(ids);
    }

}