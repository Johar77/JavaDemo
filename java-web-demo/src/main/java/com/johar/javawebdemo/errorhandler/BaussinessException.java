package com.johar.javawebdemo.errorhandler;

import lombok.Getter;

/**
 * @ClassName: BaussinessException
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 14:11
 * @Version: 1.0
 */
public class BaussinessException extends RuntimeException {
    private static final long serialVersionUID = 2359767895161832954L;

    @Getter
    private final ErrorCode resultCode;

    public BaussinessException(String message) {
        super(message);
        this.resultCode = ErrorCode.ERROR_UNKNOWN;
    }

    public BaussinessException(ErrorCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public BaussinessException(ErrorCode resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
    }

    public BaussinessException(ErrorCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    public BaussinessException(String msg, Throwable cause) {
        super(msg, cause);
        this.resultCode = ErrorCode.ERROR_UNKNOWN;
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
