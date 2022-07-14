package com.example.demo;

import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    RedissonClient redissonClient;

    @Test
    void contextLoads() {
        RLock lock = redissonClient.getLock("test");
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

}
