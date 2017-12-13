package com.xiaowo.dao;


import com.xiaowo.Text;

/**
 * @author answer
 *         2017/11/3
 */
public interface TextDao {

    /**
     * 根据id查询文章
     *
     * @param id
     * @return
     */
    Text findTextById(Integer id);

}
