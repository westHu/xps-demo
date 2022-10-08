package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

	/**
	 * 100 ~ x;  系统级别异常
	 */
	SYSTEM_EXCEPTION(1, "错误(1), 系统异常!"),
	RESOURCE_NOT_FOUND(101, "错误(101), 未找到相关资源"),

	/**
	 * 200 ~ x；某业务模块异常
	 */
	Invalid_Permission_EXCEPTION(200, "错误(200), 该用户没有必需的权限，无法完成请求"),


	/**
	 * ~ 999
	 */
	EARTH_EXPLOSION(999, "地球爆炸");

	private final Integer code;
	private final String message;
}