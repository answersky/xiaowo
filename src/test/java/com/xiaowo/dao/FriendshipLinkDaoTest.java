package com.xiaowo.dao;

import com.xiaowo.BaseTest;
import com.xiaowo.FriendshipLink;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public class FriendshipLinkDaoTest extends BaseTest {
    @Resource
    private FriendshipLinkDao friendshipLinkDao;

    @Test
    public void findFriendshipLinks() throws Exception {
        List<FriendshipLink> friendshipLinks = friendshipLinkDao.findFriendshipLinks();
        System.out.println(friendshipLinks);
    }

    @Test
    public void findFriendshipLinkById() throws Exception {

    }

}