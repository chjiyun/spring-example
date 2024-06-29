package com.spring3.common.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.experimental.UtilityClass;

/**
 * @author chjiyun
 */
@UtilityClass
public class UserContextHolder {

    private static final ThreadLocal<String> THREAD_LOCAL_USER = new TransmittableThreadLocal<>();

    /**
     * 设置登陆用户id
     * @param userId 登陆用户id
     */
    public void setUserId(String userId) {
        THREAD_LOCAL_USER.set(userId);
    }

    /**
     * 获取用户id
     * @return String
     */
    public String getUserId() {
        return THREAD_LOCAL_USER.get();
    }

    /**
     * 清除用户id
     */
    public void clear() {
        THREAD_LOCAL_USER.remove();
    }

}
