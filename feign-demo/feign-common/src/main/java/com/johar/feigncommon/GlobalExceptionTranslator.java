package com.johar.feigncommon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalExceptionTranslator
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 12:58
 * @Version: 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionTranslator {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleError(MethodArgumentNotValidException e){
        log.warn("Method Argument Not Valid", e);
        return BaseResponse
                .builder()
                .resultCode(ResultCode.ERROR_PARAM_NOT_VALID.getErrorCode())
                .message(ResultCode.ERROR_PARAM_NOT_VALID.getMessage())
                .build();
    }

    @ExceptionHandler(SubBussinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse handlerError(SubBussinessException e){
        return BaseResponse.builder().resultCode(e.getResultCode().getErrorCode()).message(e.getMessage()).build();
    }

    @ExceptionHandler(BussinessException.class)
    public BaseResponse handlerError(BussinessException e){
        return BaseResponse.builder().resultCode(e.getResultCode().getErrorCode()).message(e.getMessage()).build();
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handlerError(Throwable e){
        log.error("Unknown Error", e);
        return BaseResponse
                .builder()
                .resultCode(ResultCode.ERROR_UNKNOWN.getErrorCode())
                .message(ResultCode.ERROR_UNKNOWN.getMessage())
                .build();
    }
}
