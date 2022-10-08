package com.example.config;

import com.example.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ExceptionControllerAdvice
 * 这个类是专门处理控制器发生的异常的
 * //@RestControllerAdvice表示当前类是处理控制器通知功能的
 */
@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {


    @ExceptionHandler(ServiceException.class)
    public String handlerServiceException(ServiceException e){
        log.error("业务异常",e);
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e){
        log.error("其它异常",e);
        return e.getMessage();
    }


}
