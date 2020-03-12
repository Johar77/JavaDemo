package com.johar.javawebdemo.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: BaseResponse
 * @Description: 公共返回类
 * @Author: Johar
 * @Date: 2020/3/1 16:11
 * @Version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {
    @Builder.Default
    private String message = ErrorCode.OK.getMessage();

    @Builder.Default
    private int resultCode = ErrorCode.OK.getErrorCode();

    public boolean isSuccess(){
        return resultCode == ErrorCode.OK.getErrorCode();
    }

    private T data;
}
