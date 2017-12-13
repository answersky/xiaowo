package com.xiaowo.service.impl;

import com.xiaowo.Zone;
import com.xiaowo.dao.ZoneDao;
import com.xiaowo.service.ZoneService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/12/5
 */
@Service
public class ZoneServiceImpl implements ZoneService {
    @Resource
    private ZoneDao zoneDao;

    @Override
    @Cacheable(value = "baseCache", key = "'citys'")
    public List<Zone> findAllZones() {
        return zoneDao.findZones();
    }
}
