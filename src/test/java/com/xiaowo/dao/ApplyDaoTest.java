package com.xiaowo.dao;

import com.xiaowo.ApplyLog;
import com.xiaowo.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author answer
 *         2017/11/27
 */
public class ApplyDaoTest extends BaseTest {
    @Resource
    private ApplyDao applyDao;

    @Test
    public void saveApplyLog() throws Exception {
        ApplyLog applyLog = new ApplyLog();
        applyLog.setUsername("answer");
        applyLog.setTel("18576435726");
        applyLog.setChannel("7");
        applyLog.setResource("officialSite");
        applyDao.saveApplyLog(applyLog);
    }

    @Test
    public void saveCount() throws Exception {
        applyDao.saveCount("officialSite");
    }

    @Test
    public void findCountByResource() throws Exception {
        Integer count = applyDao.findCountByResource("officialSit");
        System.out.println(count);
    }

    @Test
    public void updateCount() throws Exception {
        applyDao.updateCount(2, "officialSite");
    }

}