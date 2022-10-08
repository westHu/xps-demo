package com.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
* 对数据库的mapper加载
*/
@Configuration
@MapperScan(value = "com.example.db.mpper")
public class MybatisPlusConfig {}
