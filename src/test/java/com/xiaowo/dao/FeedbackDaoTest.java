package com.xiaowo.dao;

import com.xiaowo.BaseTest;
import com.xiaowo.Feedback;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author answer
 *         2017/11/23
 */
public class FeedbackDaoTest extends BaseTest {
    @Resource
    private FeedbackDao feedbackDao;

    @Test
    public void insertFeedback() throws Exception {
        Feedback feedback = new Feedback();
        feedback.setContent("小窝金服公司的详细地址在哪里");
        feedback.setTel("13545678925");
        feedbackDao.insertFeedback(feedback);
    }

}