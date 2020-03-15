package com.johar.javawebdemo.errorhandler;

/**
 * @ClassName: SubBussinessException
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 14:13
 * @Version: 1.0
 */
public class SubBussinessException extends BaussinessException {
    public SubBussinessException(String message) {
        super(message);
    }

    public SubBussinessException(ErrorCode resultCode) {
        super(resultCode);
    }

    public SubBussinessException(ErrorCode resultCode, String msg) {
        super(resultCode, msg);
    }

    public SubBussinessException(ErrorCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public SubBussinessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
