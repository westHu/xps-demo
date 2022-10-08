package com.example.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统统一根异常
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

    private Integer code;
    private String message;

    /**
     * 用给定的异常信息构造新实例。
     * @param message 异常信息。
     */
    public ServiceException(String message) {
        super(message);
        this.code = 500;
        this.message = message;
    }


    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 用表示异常原因的对象构造新实例。
     * @param cause 异常原因。
     */
    public ServiceException(Throwable cause) {
        super(null, cause);
    }

    /**
     * 用异常消息和表示异常原因的对象构造新实例。
     * @param message 异常信息。
     * @param cause 异常原因。
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    /**
     * 用异常消息和表示异常原因及其他信息的对象构造新实例。
     * @param message 异常信息。
     * @param code 错误代码。
     * @param cause 异常原因。
     */
    public ServiceException(Integer code, String message, Throwable cause) {
        this(message, cause);
        this.code = code;
    }

    /**
     * 用异常消息和表示异常原因及其他信息的对象构造新实例。
     * @param exceptionCode 异常信息。
     */
    public ServiceException(ExceptionCode exceptionCode) {
        this(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
    }
}
