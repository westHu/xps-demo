package com.example.db.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "t_book")
public class BookPO extends BaseEntity {
    /**
     * 注释
     */
    private String name;
    /**
     * 注释
     */
    private String description;
    /**
     * 注释
     */
    private String sourceCode;
    /**
     * 注释
     */
    private String targetCode;

}
