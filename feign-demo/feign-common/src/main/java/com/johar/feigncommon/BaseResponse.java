package com.johar.feigncommon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BaseResponse
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 13:05
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {
    @Builder.Default
    private String message = ResultCode.OK.getMessage();

    @Builder.Default
    private int resultCode = ResultCode.OK.getErrorCode();

    public boolean isSuccess(){
        return resultCode == ResultCode.OK.getErrorCode();
    }

    private T data;
}
