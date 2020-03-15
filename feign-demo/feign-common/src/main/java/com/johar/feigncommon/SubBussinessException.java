package com.johar.feigncommon;

/**
 * @ClassName: SubBussinessException
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 13:04
 * @Version: 1.0
 */
public class SubBussinessException extends BussinessException {
    public SubBussinessException(String message) {
        super(message);
    }

    public SubBussinessException(ResultCode resultCode) {
        super(resultCode);
    }

    public SubBussinessException(ResultCode resultCode, String msg) {
        super(resultCode, msg);
    }

    public SubBussinessException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public SubBussinessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
