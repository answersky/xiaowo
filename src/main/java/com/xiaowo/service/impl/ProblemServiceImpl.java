package com.xiaowo.service.impl;

import com.xiaowo.Problem;
import com.xiaowo.ProblemCategory;
import com.xiaowo.dao.ProblemDao;
import com.xiaowo.service.ProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author answer
 *         2017/11/27
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    @Resource
    private ProblemDao problemDao;

    @Override
    public List<Problem> findProblems() {
        return problemDao.findProblems();
    }

    @Override
    public Map<String, List<Problem>> problems() {
        Map<String, List<Problem>> map = new LinkedHashMap<>();
        //获取所有的分类
        List<ProblemCategory> list = problemDao.findAllProblemCategory();
        if (list != null && list.size() > 0) {
            for (ProblemCategory problemCategory : list) {
                Integer pId = problemCategory.getId();
                String category = problemCategory.getCategory();
                List<Problem> problems = problemDao.findProblemsByCategoryId(pId);
                map.put(category, problems);
            }
        }
        return map;
    }
}
