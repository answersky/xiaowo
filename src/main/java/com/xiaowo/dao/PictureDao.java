package com.xiaowo.dao;


import com.xiaowo.Picture;

/**
 * @author answer
 *         2017/11/3
 */
public interface PictureDao {

    /**
     * 根据id查询图片
     *
     * @param id
     * @return
     */
    Picture findPictureById(Integer id);

}
