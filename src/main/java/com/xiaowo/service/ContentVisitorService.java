package com.xiaowo.service;

/**
 * @author answer
 *         2017/12/8
 */
public interface ContentVisitorService {
    /**
     * 记录访问的日志
     *
     * @param id
     */
    void saveVisitorLog(Integer id);
}
