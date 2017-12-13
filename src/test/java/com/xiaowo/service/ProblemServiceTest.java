package com.xiaowo.service;

import com.xiaowo.BaseTest;
import com.xiaowo.Problem;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author answer
 *         2017/12/6
 */
public class ProblemServiceTest extends BaseTest {
    @Resource
    private ProblemService problemService;

    @Test
    public void problems() throws Exception {
        Map<String, List<Problem>> map = problemService.problems();
        System.out.println(map);
    }

}