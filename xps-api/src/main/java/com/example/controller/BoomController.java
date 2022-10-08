package com.example.controller;


import com.example.query.BookQueryService;
import com.example.query.dto.BookDTO;
import com.example.utils.JsonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BoomController {


    @Resource
    BookQueryService bookQueryService;

    @GetMapping(value = "/hi")
    public String hello() {
        return "Boom, West!!!";
    }

    @GetMapping(value = "/bookQuery")
    public String bookQuery() {
        List<BookDTO> bookDTOS = bookQueryService.queryBookList(null);
        return JsonUtil.objectToString(bookDTOS);
    }

}
