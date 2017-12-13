package com.xiaowo.service;

import java.util.Map;


public interface IRedisService {


    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime 单位秒
     */
    void set(String key, Object value, long liveTime);

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    void set(String key, Object value);

    void set(String key, String value);

    boolean setNx(String key, String value);

    boolean hSetNx(String key, String filedName, String filedValue);

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    <T> T get(String key, Class<T> clazz);

    byte[] get(final String key);

    int lLen(final String key);

    /**
     * 添加Hash value
     *
     * @param key
     * @param field
     * @param value
     */
    void hset(String key, String field, Object value);

    /**
     * 添加Hash value
     *
     * @param key
     * @param field
     * @param value
     */
    void hset(String key, String field, Object value, long liveTime);


    void hDel(String key, String field);


    /**
     * 获取Hash里面的值
     *
     * @param key
     * @param field
     * @param <T>
     * @return
     */
    <T> T hget(String key, String field, Class<T> clazz);

    void lpush(String key, Object value);

    /**
     * list 过期时间
     *
     * @param key
     * @param value
     * @param liveTime void 返回值
     * @author fukun
     * @date: 2017年3月6日 上午11:34:00
     * @Title: lpush
     */
    void lpush(String key, Object value, long liveTime);

    <T> T rPop(String key, Class<T> clazz);


    /**
     * 获取Hash里面所有的值
     *
     * @param key
     * @param <T>
     * @return
     */
    <T> Map<String, T> hgetAll(String key, Class<T> clazz);

    byte[] hget(final String key, final String field);

    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    boolean exists(String key);

    /**
     * 根据Key值删除 key对应的Value值
     *
     * @param key
     */
    void delByKey(String key);

    /**
     * 检查是否连接成功
     *
     * @return
     */
    String ping();
}
