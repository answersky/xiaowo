package com.xiaowo.dao;

import com.xiaowo.FriendshipLink;

import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public interface FriendshipLinkDao {
    /**
     * 查询发布的友情链接
     *
     * @return
     */
    List<FriendshipLink> findFriendshipLinks();

    /**
     * 根据id查询友情链接
     *
     * @param id
     * @return
     */
    FriendshipLink findFriendshipLinkById(Integer id);
}
