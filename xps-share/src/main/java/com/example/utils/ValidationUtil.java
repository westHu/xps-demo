package com.example.utils;


import com.example.exception.ValidationException;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * 校验工具类
 */
public class ValidationUtil {

    // 用于Java Bean校验的校验器
    private static Validator obtainValidator() {
        // 1、使用【默认配置】得到一个校验工厂  这个配置可以来自于provider、SPI提供
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // 2、得到一个校验器
        return validatorFactory.getValidator();
    }

    // 用于方法校验的校验器
    private static ExecutableValidator obtainExecutableValidator() {
        return obtainValidator().forExecutables();
    }

    /**
     * @param obj
     * @return
     * @param <T>
     */
    public static <T> String getErrorMsg(T obj) {
        Validator validator = ValidationUtil.obtainValidator();
        Set<ConstraintViolation<T>> result = validator.validate(obj);
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue())
                .collect(Collectors.joining());
    }



    public static void isTrue(boolean expect, Integer code, Object... params) {
        if (!expect) {
            throw ValidationException.of(code, params);
        }
    }

    public static void isFalse(boolean expect, Integer code, Object... params) {
        isTrue(!expect, code, params);
    }



}