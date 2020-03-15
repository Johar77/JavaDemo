package com.johar.commonlib.exception;

import com.johar.commonlib.ResultCode;

/**
 * @ClassName: BussinessException
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/16 00:02
 * @Version: 1.0
 */
public class BussinessException extends ServiceException {
    public BussinessException(ResultCode resultCode) {
        super(resultCode);
    }

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public BussinessException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
