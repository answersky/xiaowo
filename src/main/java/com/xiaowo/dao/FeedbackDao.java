package com.xiaowo.dao;

import com.xiaowo.Feedback;

/**
 * @author answer
 *         2017/11/23
 */
public interface FeedbackDao {
    /**
     * 新增意见反馈
     *
     * @param feedback
     */
    void insertFeedback(Feedback feedback);
}
