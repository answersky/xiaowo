package com.xiaowo.service;

import com.xiaowo.FriendshipLink;

import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public interface FriendLinkService {
    /**
     * 友情链接
     *
     * @return
     */
    List<FriendshipLink> findFriendLinks();
}
