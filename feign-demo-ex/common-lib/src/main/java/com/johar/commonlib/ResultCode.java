package com.johar.commonlib;

import lombok.Getter;

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
    UNKNOW_ERROR(9999, "unknow error")
    ;
    private int resultCode;
    private String resultMsg;
    ResultCode(int resultCode, String message){
        this.resultCode = resultCode;
        this.resultMsg = message;
    }
}
