package com.xiaowo.service;

import com.xiaowo.Department;
import com.xiaowo.Recruit;
import com.xiaowo.Zone;

import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public interface RecruitService {
    /**
     * 查询部门
     *
     * @return
     */
    List<Department> findAllDepartments();

    /**
     * 查询地区
     *
     * @return
     */
    List<Zone> findAllZones();

    /**
     * 查询招聘信息
     *
     * @param departmentId
     * @param zoneId
     * @param type
     * @return
     */
    List<Recruit> findRecruits(Integer departmentId, Integer zoneId, String type);
}
