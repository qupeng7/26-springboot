package com.qupeng.springboot.service.impl;

import com.qupeng.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;

@Service
public class RedisServiceImpl implements RedisService {

    /**
     * 注入即可使用
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Jedis jedis;


    @PostConstruct //相当于 <bean id="redisTemplate" class="xxx.RedisTemplate" init-methed="initRedisTemplate">
    public void initRedisTemplate() {
        System.out.println("111.............");
        //设置redis的key的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
    }

    @Override
    public void cache() {
        redisTemplate.opsForValue().set("springboot", "This is spring boot redis");
    }

    public void cacheBySelf() {
        jedis.set("myConfig", "123456");
    }
}
