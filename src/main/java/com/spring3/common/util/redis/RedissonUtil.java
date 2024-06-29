package com.spring3.common.util.redis;

import com.spring3.common.util.spring.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁工具类
 * @author lijiyun
 * @date 2024/06/10 19:59
 */
@Slf4j
public class RedissonUtil {

    private static final RedissonClient redissonClient = ApplicationContextUtil.getBean(RedissonClient.class);


    public static boolean tryLock(String key) {
        RLock lock = redissonClient.getLock(key);
        return lock.tryLock();
    }

    public static boolean tryLock(String key, long waitTime) {
        RLock lock = redissonClient.getLock(key);
        boolean flag = false;
        // 获取锁的最大等待时间（期间重试）
        try {
            flag = lock.tryLock(waitTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("获取锁失败 {}", e.getMessage());
        }
        return flag;
    }

    public static boolean tryLock(String key, long waitTime, long expireTime) {
        RLock lock = redissonClient.getLock(key);
        boolean flag = false;
        // 指定锁超时时间，不会使用自动续期机制
        try {
            flag = lock.tryLock(waitTime, expireTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("获取锁失败 {}", e.getMessage());
        }
        return flag;
    }

    public static void unLock(String key) {
        redissonClient.getLock(key).unlock();
    }
}
