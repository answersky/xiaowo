package com.xiaowo.dao;

import com.xiaowo.BaseTest;
import com.xiaowo.Problem;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public class ProblemDaoTest extends BaseTest {
    @Resource
    private ProblemDao problemDao;

    @Test
    public void findProblems() throws Exception {
        List<Problem> problems = problemDao.findProblems();
        System.out.println(problems);
    }

    @Test
    public void findRecommendProblem() throws Exception {
        List<Problem> problems = problemDao.findRecommendProblem();
        System.out.println(problems);
    }

}