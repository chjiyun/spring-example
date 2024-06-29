package com.spring3.common.exception;

import com.spring3.common.api.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

    /**
     * 业务错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    public ServiceException() {
    }

    public ServiceException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
