package com.xiaowo.service;

/**
 * @author answer
 *         2017/11/23
 */
public interface FeedBackService {
    /**
     * 保存意见反馈
     *
     * @param content
     * @param tel
     */
    void saveFeedback(String content, String tel);
}
