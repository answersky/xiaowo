package com.xiaowo.service;

import com.xiaowo.Zone;

import java.util.List;

/**
 * @author answer
 *         2017/12/5
 */
public interface ZoneService {
    /**
     * 获取所有的区域
     *
     * @return
     */
    List<Zone> findAllZones();
}
