package com.spring3.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {

    SUCCESS(0, "操作成功"),

    FAILURE(1, "业务异常"),

    BAD_REQUEST(400, "请求异常"),

    UNAUTHORIZED(401, "未登陆"),

    NOT_FOUND(404, "请求未找到"),

    METHOD_NOT_ALLOWED(405, "请求方法不正确"),

    AUTH_LOGIN_BAD_CREDENTIALS(1, "登录名或密码错误"),

    AUTH_LOGIN_USER_DISABLED(1, "用户已被锁定，暂时无法登录"),

    AUTH_LOGIN_USER_COMPANY_DISABLED(1, "用户已被禁用，请联系管理员"),

    AUTH_LOGIN_USER_PROJECT_UNAVAILABLE(1, "未授权项目，请联系管理员"),

    INTERNAL_SERVER_ERROR(500, "系统异常"),

    FREQUENT_REQUEST(1, "请求过于频繁，请稍后再试");

    /**
     * 状态码
     */
    final int code;
    /**
     * 消息内容
     */
    final String msg;

}
