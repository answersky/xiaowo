package com.xiaowo.dao;

import com.xiaowo.Tag;

/**
 * @author answer
 *         2017/11/3
 */
public interface TagDao {


    /**
     * 根据id查询标签
     *
     * @param i
     * @return
     */
    Tag findTagById(Integer i);
}
