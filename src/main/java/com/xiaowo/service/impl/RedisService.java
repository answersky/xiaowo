package com.xiaowo.service.impl;

import com.xiaowo.service.IRedisService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Service
public class RedisService implements IRedisService {


    @Resource
    private RedisTemplate<?, ?> redisTemplate;

    @Resource
    private StringRedisSerializer redisSerializer;

    @Resource
    private GenericJackson2JsonRedisSerializer jsonRedisSerializer;

    @Override
    public void set(String key, Object value, final long liveTime) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteValue = jsonRedisSerializer.serialize(value);
        final byte[] b = new byte[byteValue.length - 2];
        System.arraycopy(byteValue, 1, b, 0, b.length);
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                if (liveTime > 0) {
                    connection.setEx(byteKey, liveTime, b);
                }
                return null;
            }
        });
    }

    @Override
    public void set(String key, Object value) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteValue = jsonRedisSerializer.serialize(value);
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(byteKey, byteValue);
                return null;
            }
        });
    }

    @Override
    public void set(String key, String value) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteValue = redisSerializer.serialize(value);
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(byteKey, byteValue);
                return null;
            }
        });
    }

    @Override
    public boolean hSetNx(String key, String fieldName, String fieldValue) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteFieldName = redisSerializer.serialize(fieldName);
        final byte[] byteFieldValue = redisSerializer.serialize(fieldValue);
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hSetNX(byteKey, byteFieldName, byteFieldValue);
            }
        });
    }

    @Override
    public boolean setNx(String key, String value) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteValue = redisSerializer.serialize(value);
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(byteKey, byteValue);
            }
        });
    }

    @Override
    public <T> T get(final String key, final Class<T> clazz) {
        return (T) redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] serialize = redisSerializer.serialize(key);
                if (connection.exists(serialize)) {
                    byte[] value = connection.get(serialize);
                    if (value != null) {
                        return jsonRedisSerializer.deserialize(value, clazz);
                    }
                }
                return null;
            }
        });
    }

    @Override
    public byte[] get(final String key) {
        return redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) {
                byte[] serialize = redisSerializer.serialize(key);
                if (connection.exists(serialize)) {
                    byte[] value = connection.get(serialize);
                    if (value != null) {
                        return value;
                    }
                }
                return null;
            }
        });
    }

    @Override
    public int lLen(final String key) {
        return redisTemplate.execute(new RedisCallback<Integer>() {
            @Override
            public Integer doInRedis(RedisConnection connection) {
                byte[] serialize = redisSerializer.serialize(key);
                if (connection.exists(serialize)) {
                    Long value = connection.lLen(serialize);
                    if (value != null) {
                        return value.intValue();
                    }
                }
                return 0;
            }
        });
    }

    @Override
    public void hset(String key, String field, Object value) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteField = redisSerializer.serialize(field);
        final byte[] byteValue = jsonRedisSerializer.serialize(value);
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                connection.hSet(byteKey, byteField, byteValue);
                return null;
            }
        });
    }

    @Override
    public void hset(String key, String field, Object value, final long liveTime) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteField = redisSerializer.serialize(field);
        final byte[] byteValue = jsonRedisSerializer.serialize(value);
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                connection.hSet(byteKey, byteField, byteValue);
                if (liveTime > 0) {
                    connection.expire(byteKey, liveTime);
                }
                return null;
            }
        });
    }

    @Override
    public void hDel(String key, String field) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteField = redisSerializer.serialize(field);
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                connection.hDel(byteKey, byteField);
                return null;
            }
        });
    }

    @Override
    public void lpush(String key, Object value) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteValue = jsonRedisSerializer.serialize(value);
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                connection.lPush(byteKey, byteValue);
                return null;
            }
        });
    }

    @Override
    public void lpush(String key, Object value, final long liveTime) {
        final byte[] byteKey = redisSerializer.serialize(key);
        final byte[] byteValue = jsonRedisSerializer.serialize(value);
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                connection.lPush(byteKey, byteValue);
                if (liveTime > 0) {
                    connection.expire(byteKey, liveTime);
                }
                return null;
            }
        });
    }

    @Override
    public <T> T rPop(String key, final Class<T> clazz) {
        final byte[] byteKey = redisSerializer.serialize(key);
        return (T) redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                if (connection.exists(byteKey)) {
                    byte[] value = connection.rPop(byteKey);
                    if (value != null) {
                        return jsonRedisSerializer.deserialize(value, clazz);
                    }
                }
                return null;
            }
        });
    }

    @Override
    public <T> T hget(final String key, final String field, final Class<T> clazz) {
        return (T) redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keySerialize = redisSerializer.serialize(key);
                byte[] fieldSerialize = redisSerializer.serialize(field);
                if (connection.exists(keySerialize)) {
                    byte[] value = connection.hGet(keySerialize, fieldSerialize);
                    if (value != null) {
                        return jsonRedisSerializer.deserialize(value, clazz);
                    }
                }
                return null;
            }
        });
    }

    @Override
    public <T> Map<String, T> hgetAll(final String key, final Class<T> clazz) {
        return (Map<String, T>) redisTemplate.execute(new RedisCallback<Map<String, T>>() {
            @Override
            public Map<String, T> doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keySerialize = redisSerializer.serialize(key);
                if (connection.exists(keySerialize)) {
                    Map<byte[], byte[]> valueMap = connection.hGetAll(keySerialize);
                    Map<String, T> resultMap = new HashMap<String, T>();
                    if (valueMap != null) {
                        for (byte[] valueKey : valueMap.keySet()) {
                            resultMap.put(redisSerializer.deserialize(valueKey), jsonRedisSerializer.deserialize(valueMap.get(valueKey), clazz));
                        }
                        return resultMap;
                    }
                }
                return null;
            }
        });
    }

    @Override
    public boolean exists(final String key) {
        return (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(redisSerializer.serialize(key));
            }
        });
    }

    @Override
    public void delByKey(final String key) {
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection connection) throws DataAccessException {
                connection.del(redisSerializer.serialize(key));
                return null;
            }
        });
    }

    @Override
    public String ping() {
        return (String) redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.ping();
            }
        });
    }

    @Override
    public byte[] hget(final String key, final String field) {
        return redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keySerialize = redisSerializer.serialize(key);
                byte[] fieldSerialize = redisSerializer.serialize(field);
                if (connection.exists(keySerialize)) {
                    return connection.hGet(keySerialize, fieldSerialize);
                }
                return null;
            }
        });
    }

}
