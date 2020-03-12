package com.johar.javawebdemo.errorhandler;

/**
 * @ClassName: ExceptionInfo
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/1 16:13
 * @Version: 1.0
 */
public enum ErrorCode {
    OK(0, "success"),
    ERROR_PARAM_NOT_VALID(1, "Method Argument Not Valid"),
    ERROR_PARAM_MISS(2, "Method Argument Miss"),
    ERROR_UNKNOWN(9999, "Unknown Error");

    private int errorCode;
    private String message;

    ErrorCode(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
