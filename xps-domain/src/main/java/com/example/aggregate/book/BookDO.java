package com.example.aggregate.book;

import lombok.Data;

import java.util.List;

@Data
public class BookDO {

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

    /**
     * 注释
     */
    private List<StoryDO> storyDOList;

}
