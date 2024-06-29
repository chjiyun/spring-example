package com.spring3.common.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private Integer code;

    private T data;

    private String msg;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = ResultCode.SUCCESS.getCode();
        result.data = data;
        result.msg = ResultCode.SUCCESS.getMsg();
        return  result;
    }

    public static <T> Result<T> fail(IResultCode resultCode) {
        return fail(resultCode.getCode(), resultCode.getMsg());
    }

    public static <T> Result<T> fail(String msg) {
        return fail(ResultCode.FAILURE.getCode(), msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        Result<T> result = new Result<>();
        result.code = code;
        result.msg = msg;
        return  result;
    }
}
