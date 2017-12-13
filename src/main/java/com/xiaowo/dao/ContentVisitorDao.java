package com.xiaowo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author answer
 *         2017/12/8
 */
public interface ContentVisitorDao {
    /**
     * 记录访问的日志
     *
     * @param id
     */
    void saveVisitorLog(Integer id);

    /**
     * 查询当月热门文章的id
     *
     * @param sTime
     * @param eTime
     * @return
     */
    List<Integer> findHotContentId(@Param("sTime") String sTime, @Param("eTime") String eTime);
}
