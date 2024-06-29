package com.spring3.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lijiyun
 * @date 2023年10月18日 13:42
 */
@TableName(value = "sys_log")
@Data
public class SysLog {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 请求时间
     */
    private LocalDateTime requestTime;
    /**
     * 执行结束时间
     */
    @TableField(exist = false)
    private LocalDateTime responseTime;
    /**
     * 请求url
     */
    private String requestUrl;
    /**
     * http 方式
     */
    private String requestMethod;
    /**
     * http状态码
     */
    private Integer responseStatus;
    /**
     * 业务状态码 0成功 或 1失败
     */
    private Integer code;
    /**
     * 业务返回信息（部分为枚举值）
     */
    private String msg;
    /**
     * 业务异常信息
     */
    private String exceptionMsg;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 请求花费时间（毫秒）
     */
    private Long cost;
    /**
     * 模块名
     */
    @TableField(exist = false)
    private String moduleName;
    /**
     * 方法名
     */
    @TableField(exist = false)
    private String methodName;

    private String className;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    @TableLogic(value = "0", delval = "1")
    private Integer delFlag;
}
