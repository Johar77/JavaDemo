package com.johar.commonlib.exception;

import com.johar.commonlib.BaseResult;
import com.johar.commonlib.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 23:40
 * @Version: 1.0
 */
@RestControllerAdvice(basePackages = {"com.johar"})
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResult handleError(MissingServletRequestParameterException e) {
        log.warn("Missing Request Parameter", e);
        String message = String.format("Missing Request Parameter: %s", e.getParameterName());
        return BaseResult.error(ResultCode.PARAM_MISS, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public BaseResult handleError(MethodArgumentTypeMismatchException e) {
        log.warn("Method Argument Type Mismatch", e);
        String message = String.format("Method Argument Type Mismatch: %s", e.getName());
        return BaseResult.error(ResultCode.PARAM_TYPE_ERROR, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult handleError(MethodArgumentNotValidException e) {
        log.warn("Method Argument Not Valid", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        return BaseResult.error(ResultCode.PARAM_VALID_ERROR, message);
    }

    @ExceptionHandler(BindException.class)
    public BaseResult handleError(BindException e) {
        log.warn("Bind Exception", e);
        FieldError error = e.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        return BaseResult.error(ResultCode.PARAM_BIND_ERROR, message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResult handleError(ConstraintViolationException e) {
        log.warn("Constraint Violation", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
        String message = String.format("%s:%s", path, violation.getMessage());
        return BaseResult.error(ResultCode.PARAM_VALID_ERROR, message);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public BaseResult handleError(NoHandlerFoundException e) {
        log.error("404 Not Found", e);
        return BaseResult.error(ResultCode.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResult handleError(HttpMessageNotReadableException e) {
        log.error("Message Not Readable", e);
        return BaseResult.error(ResultCode.MSG_NOT_READABLE, e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResult handleError(HttpRequestMethodNotSupportedException e) {
        log.error("Request Method Not Supported", e);
        return BaseResult.error(ResultCode.METHOD_NOT_SUPPORTED, e.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public BaseResult handleError(HttpMediaTypeNotSupportedException e) {
        log.error("Media Type Not Supported", e);
        return BaseResult.error(ResultCode.MEDIA_TYPE_NOT_SUPPORTED, e.getMessage());
    }


    @ExceptionHandler(BussinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResult handleError(BussinessException e){
        log.error("Bussiness Exception", e);
        return BaseResult.error(e.getResultCode(), e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResult handleError(ServiceException e){
        log.error("Servie Exception", e);
        return BaseResult.error(e.getResultCode(), e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResult handleError(Throwable e){
        log.error("Unknown Error", e);
        return BaseResult.error(ResultCode.UNKNOWN_ERROR);
    }
}
