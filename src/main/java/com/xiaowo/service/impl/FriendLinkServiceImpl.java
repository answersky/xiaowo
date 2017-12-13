package com.xiaowo.service.impl;

import com.xiaowo.FriendshipLink;
import com.xiaowo.dao.FriendshipLinkDao;
import com.xiaowo.service.FriendLinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {
    @Resource
    private FriendshipLinkDao friendshipLinkDao;

    @Override
    public List<FriendshipLink> findFriendLinks() {
        return friendshipLinkDao.findFriendshipLinks();
    }
}
