package com.johar.javawebdemo.errorhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalExceptionTranslator
 * @Description: 异常装换
 * @Author: Johar
 * @Date: 2020/3/1 16:10
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
                .resultCode(ErrorCode.ERROR_PARAM_NOT_VALID.getErrorCode())
                .message(ErrorCode.ERROR_PARAM_NOT_VALID.getMessage())
                .build();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResponse handleError(MissingServletRequestParameterException e){
        log.warn("Param Miss", e);
        return BaseResponse
                .builder()
                .resultCode(ErrorCode.ERROR_PARAM_MISS.getErrorCode())
                .message(ErrorCode.ERROR_PARAM_MISS.getMessage())
                .build();
    }

    @ExceptionHandler(SubBussinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse handleError(SubBussinessException e){
        log.warn("Param Miss", e);
        return BaseResponse
                .builder()
                .resultCode(e.getResultCode().getErrorCode())
                .message(e.getLocalizedMessage())
                .build();
    }

    @ExceptionHandler(BaussinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleError(BaussinessException e){
        log.warn("Param Miss", e);
        return BaseResponse
                .builder()
                .resultCode(e.getResultCode().getErrorCode())
                .message(e.getLocalizedMessage())
                .build();
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handlerError(Throwable e){
        log.error("Unknown Error", e);
        return BaseResponse
                .builder()
                .resultCode(ErrorCode.ERROR_UNKNOWN.getErrorCode())
                .message(ErrorCode.ERROR_UNKNOWN.getMessage())
                .build();
    }
}
