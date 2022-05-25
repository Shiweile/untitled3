package com.shiweile.controller;

import com.shiweile.exception.BusinessException;
import com.shiweile.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        return new Result(ex.getCode(),null, ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doSystemException(BusinessException ex){
        return new Result(ex.getCode(),null, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doSystemException(Exception ex){
        return new Result(Code.SYSTEM_UNKNOW_ERR,null, "系统繁忙");
    }
}
