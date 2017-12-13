package com.xiaowo.dao;

import com.xiaowo.Problem;
import com.xiaowo.ProblemCategory;

import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public interface ProblemDao {
    /**
     * 帮助中心
     *
     * @return
     */
    List<Problem> findProblems();

    /**
     * 获取推荐的文章
     *
     * @return
     */
    List<Problem> findRecommendProblem();

    /**
     * 查询所有的问题分类
     *
     * @return
     */
    List<ProblemCategory> findAllProblemCategory();

    /**
     * 根据分类id查询问题列表
     *
     * @param categoryId
     * @return
     */
    List<Problem> findProblemsByCategoryId(Integer categoryId);
}
