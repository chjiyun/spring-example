package com.spring3.client.service;

import com.spring3.common.constant.Constant;
import com.spring3.common.util.redis.RedissonUtil;
import org.springframework.stereotype.Service;

/**
 * @author lijiyun
 * @date 2024/06/18 23:04
 */
@Service
public class WorkService {


    public void redissonLock() {
        String key = Constant.REDIS_KEY_PREFIX + ":test_lock";
        if (!RedissonUtil.tryLock(key)) {
            System.out.print("任务正在运行");
            return;
        }

        // 模拟业务耗时
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            RedissonUtil.unLock(key);
        }
    }

}
