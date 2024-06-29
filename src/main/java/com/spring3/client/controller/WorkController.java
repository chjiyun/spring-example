package com.spring3.client.controller;

import com.spring3.client.service.WorkService;
import com.spring3.common.api.Result;
import com.spring3.common.constant.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijiyun
 * @date 2024/06/09 17:54
 */
@Tag(name = "测试接口集合")
@RestController
@RequestMapping(Constant.CONTEXT_PATH + "/work")
public class WorkController {
    @Resource
    WorkService workService;

    @GetMapping("/test")
    @Operation(summary ="测试")
    public Result<Boolean> getText() {

        return Result.success(true);
    }

    @PostMapping("/lock")
    @Operation(summary ="测试分布式锁")
    public Result<Boolean> testLock() {
        workService.redissonLock();
        return Result.success(true);
    }
}
