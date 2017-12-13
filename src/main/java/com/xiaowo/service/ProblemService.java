package com.xiaowo.service;

import com.xiaowo.Problem;

import java.util.List;
import java.util.Map;

/**
 * @author answer
 *         2017/11/27
 */
public interface ProblemService {
    /**
     * 查询常见问题列表
     *
     * @return
     */
    List<Problem> findProblems();

    /**
     * 帮助中心数据
     *
     * @return
     */
    Map<String, List<Problem>> problems();
}
