package com.xiaowo.service;

/**
 * @author answer
 *         2017/11/27
 */
public interface ApplyService {
    /**
     * 申请录入
     *
     * @param username
     * @param tel
     * @param city
     * @param channel
     * @param source
     * @return
     */
    String apply(String username, String tel, String city, String channel, String resource, String source);

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
    void updateVisitorCount(Integer visitorCount, String resource);

    /**
     * 插入页面访问记录
     *
     * @param resource
     */
    void saveVisitorCount(String resource);
}
