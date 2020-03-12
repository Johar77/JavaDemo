package com.johar.feignapi.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BaseResponse
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/11 23:14
 * @Version: 1.0
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    @Builder.Default
    private int resultCode = 0;
    @Builder.Default
    private String message = "success";
    private T data;
}
