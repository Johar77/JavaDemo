package com.johar.feigncommon;

import lombok.Getter;

/**
 * @ClassName: BussinessException
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 13:00
 * @Version: 1.0
 */
public class BussinessException extends RuntimeException {
    private static final long serialVersionUID = 2359767895161832954L;

    @Getter
    private final ResultCode resultCode;

    public BussinessException(String message) {
        super(message);
        this.resultCode = ResultCode.ERROR_UNKNOWN;
    }

    public BussinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public BussinessException(ResultCode resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
    }

    public BussinessException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    public BussinessException(String msg, Throwable cause) {
        super(msg, cause);
        this.resultCode = ResultCode.ERROR_UNKNOWN;
    }

    /**
     * for better performance
     *
     * @return Throwable
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }
}
