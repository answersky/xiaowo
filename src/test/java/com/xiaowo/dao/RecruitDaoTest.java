package com.xiaowo.dao;

import com.xiaowo.BaseTest;
import com.xiaowo.Recruit;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public class RecruitDaoTest extends BaseTest {
    @Resource
    private RecruitDao recruitDao;

    @Test
    public void findBydepartIdAndZoneId() throws Exception {
        List<Recruit> recruits = recruitDao.findBydepartIdAndZoneId(1, 1, "1");
        System.out.println(recruits);

        List<Recruit> recruitList = recruitDao.findBydepartIdAndZoneId(null, null, null);
        System.out.println(recruitList);
    }

}