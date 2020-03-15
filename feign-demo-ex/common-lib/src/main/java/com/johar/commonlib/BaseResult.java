package com.johar.commonlib;

import lombok.*;

/**
 * @ClassName: BaseResult
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 22:23
 * @Version: 1.0
 */
@Getter
@Setter
@Builder
@ToString
public class BaseResult<T> {
    @Builder.Default
    private int code = ResultCode.OK.getResultCode();
    @Builder.Default
    private String message = ResultCode.OK.getResultMsg();
    private T data;
    public BaseResult(){}
    public BaseResult(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static <T> BaseResult<T> success(T data){
        return new BaseResult(ResultCode.OK.getResultCode(), ResultCode.OK.getResultMsg(), data);
    }

    public static <T> BaseResult<T> error(int errorCode, String message){
        return new BaseResult(errorCode, message, null);
    }
}
