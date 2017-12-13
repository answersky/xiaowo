package com.xiaowo.dao;

import com.xiaowo.Zone;

import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public interface ZoneDao {
    /**
     * 查询所有的地区
     *
     * @return
     */
    List<Zone> findZones();
}
