package com.xiaowo.dao;

import com.xiaowo.Recruit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public interface RecruitDao {

    /**
     * 条件筛选
     *
     * @param departmentId
     * @param zoneId
     * @param type
     * @return
     */
    List<Recruit> findBydepartIdAndZoneId(@Param("departmentId") Integer departmentId, @Param("zoneId") Integer zoneId, @Param("type") String type);
}
