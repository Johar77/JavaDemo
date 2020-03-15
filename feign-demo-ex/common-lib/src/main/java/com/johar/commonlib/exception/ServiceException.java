package com.johar.commonlib.exception;

import com.johar.commonlib.ResultCode;
import lombok.Getter;

/**
 * @ClassName: ServiceException
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 23:56
 * @Version: 1.0
 */
public class ServiceException extends RuntimeException{
    private static final long serialVerionUID = 2359767895161832954L;

    @Getter
    private final ResultCode resultCode;

    public ServiceException(ResultCode resultCode) {
        super(resultCode.getResultMsg());
        this.resultCode = resultCode;
    }

    public ServiceException(String message) {
        super(message);
        this.resultCode = ResultCode.FAIL;
    }

    public ServiceException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public ServiceException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.resultCode = ResultCode.FAIL;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }
}
