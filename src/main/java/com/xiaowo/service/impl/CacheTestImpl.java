package com.xiaowo.service.impl;

import com.xiaowo.service.CacheTestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author answer
 *         2017/11/23
 */
@Service
public class CacheTestImpl implements CacheTestService {


    @Override
    @Cacheable(value = "baseCache", key = "'cache'+#id")
    public String getCache(Integer id) {
        return id + String.valueOf(System.currentTimeMillis());
    }
}
