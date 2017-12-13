package com.xiaowo.service.impl;

import com.xiaowo.Department;
import com.xiaowo.Recruit;
import com.xiaowo.Zone;
import com.xiaowo.dao.DepartmentDao;
import com.xiaowo.dao.RecruitDao;
import com.xiaowo.dao.ZoneDao;
import com.xiaowo.service.RecruitService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private DepartmentDao departmentDao;
    @Resource
    private ZoneDao zoneDao;
    @Resource
    private RecruitDao recruitDao;

    @Override
    public List<Department> findAllDepartments() {
        return departmentDao.findDepartments();
    }

    @Override
    @Cacheable(value = "baseCache", key = "'cityList'")
    public List<Zone> findAllZones() {
        return zoneDao.findZones();
    }

    @Override
    public List<Recruit> findRecruits(Integer departmentId, Integer zoneId, String type) {
        return recruitDao.findBydepartIdAndZoneId(departmentId, zoneId, type);
    }
}
