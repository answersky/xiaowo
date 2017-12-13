package com.xiaowo.dao;

import com.xiaowo.ApplyLog;
import org.apache.ibatis.annotations.Param;

/**
 * @author answer
 *         2017/11/27
 */
public interface ApplyDao {
    /**
     * 保存申请日志
     *
     * @param applyLog
     */
    void saveApplyLog(ApplyLog applyLog);

    /**
     * 申请统计
     *
     * @param resource
     */
    void saveCount(@Param("resource") String resource);

    /**
     * 插入页面访问记录
     *
     * @param resource
     */
    void saveVisitorCount(@Param("resource") String resource);

    /**
     * 根据来源页面查询申请的总数
     *
     * @param resource
     * @return
     */
    Integer findCountByResource(String resource);

    /**
     * 更新统计
     *
     * @param count
     * @param resource
     */
    void updateCount(@Param("count") Integer count, @Param("resource") String resource);

    /**
     * 查询访问次数
     *
     * @param resource
     * @return
     */
    Integer findVisitorCountByResource(String resource);

    /**
     * 更新统计
     *
     * @param visitorCount
     * @param resource
     */
    void updateVisitorCount(@Param("visitorCount") Integer visitorCount, @Param("resource") String resource);

}
