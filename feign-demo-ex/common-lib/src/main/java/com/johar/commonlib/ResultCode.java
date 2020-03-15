package com.johar.commonlib;

import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: ResultCode
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 22:27
 * @Version: 1.0
 */
@Getter
public enum ResultCode {
    OK(0, "success"),
    PARAM_INVALID(1, "param invalid"),
    DB_ERROR(2, "db error"),
    SERVER_ERROR(3, "server error"),
    FAIL(4, "fail"),
    FAILURE(5, "Biz Exception"),
    UN_AUTHORIZED(6, "Request Unauthorized"),
    NOT_FOUND(7, "404 Not Found"),
    MSG_NOT_READABLE(8, "Message Can't be Read"),
    METHOD_NOT_SUPPORTED(9, "Method Not Supported"),
    MEDIA_TYPE_NOT_SUPPORTED(10, "Media Type Not Supported"),
    REQ_REJECT(11, "Request Rejected"),
    INTERNAL_SERVER_ERROR(12, "Internal Server Error"),
    PARAM_MISS(13, "Missing Required Parameter"),
    PARAM_TYPE_ERROR(14, "Parameter Type Mismatch"),
    PARAM_BIND_ERROR(15, "Parameter Binding Error"),
    PARAM_VALID_ERROR(16, "Parameter Validation Error"),
    UNKNOWN_ERROR(-1, "unknow error")
    ;
    private int resultCode;
    private String resultMsg;
    ResultCode(int resultCode, String message){
        this.resultCode = resultCode;
        this.resultMsg = message;
    }
}
