package com.spring3.common.api;

import com.spring3.common.entity.SysLog;
import org.springframework.scheduling.annotation.Async;

/**
 * @author lijiyun
 * @date 2023年10月18日 13:37
 */
public interface ISysLog {

    @Async
    public void saveSysLog(SysLog sysLog);

}
