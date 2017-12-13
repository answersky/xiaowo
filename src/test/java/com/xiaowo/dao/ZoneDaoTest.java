package com.xiaowo.dao;

import com.xiaowo.BaseTest;
import com.xiaowo.Zone;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public class ZoneDaoTest extends BaseTest {
    @Resource
    private ZoneDao zoneDao;

    @Test
    public void findZones() throws Exception {
        List<Zone> zones = zoneDao.findZones();
        System.out.println(zones);
    }

}