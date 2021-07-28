package com.bjpowernode.redis.uitl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

public class JedisTest {
    public static void main(String[] args) {
       /* Jedis jedis = new Jedis("192.168.235.128", 6379);
        jedis.flushDB();
        jedis.set("str1","aaddcc");*/

      /* //使用连接池
        JedisPool jedisPool = RedisUtils.open("192.168.235.128", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.lpush("list","java","php","c++","c");
        RedisUtils.close();*/

        JedisPool jedisPool = RedisUtils.open("192.168.235.128", 6379);
        Jedis jedis = jedisPool.getResource();
        Transaction multi = jedis.multi();
        multi.sadd("set1","java","jaja","ccccc");
        multi.set("str3","adksfjs");
        List<Object> exec = multi.exec();
        RedisUtils.close();

    }
}
