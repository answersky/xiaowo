package com.xiaowo.service.impl;

import com.xiaowo.dao.ContentVisitorDao;
import com.xiaowo.service.ContentVisitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author answer
 *         2017/12/8
 */
@Service
public class ContentVisitorServiceImpl implements ContentVisitorService {
    @Resource
    private ContentVisitorDao contentVisitorDao;

    @Override
    public void saveVisitorLog(Integer id) {
        contentVisitorDao.saveVisitorLog(id);
    }
}
