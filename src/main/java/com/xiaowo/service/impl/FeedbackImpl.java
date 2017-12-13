package com.xiaowo.service.impl;

import com.xiaowo.Feedback;
import com.xiaowo.dao.FeedbackDao;
import com.xiaowo.service.FeedBackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author answer
 *         2017/11/23
 */
@Service
public class FeedbackImpl implements FeedBackService {
    @Resource
    private FeedbackDao feedbackDao;

    @Override
    public void saveFeedback(String content, String tel) {
        Feedback feedback = new Feedback();
        feedback.setTel(tel);
        feedback.setContent(content);
        feedbackDao.insertFeedback(feedback);
    }
}
