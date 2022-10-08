package com.example.query.impl;

import com.example.db.entity.BookPO;
import com.example.query.BookQueryService;
import com.example.query.dto.BookDTO;
import com.example.query.param.BookQueryParam;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookQueryServiceImpl implements BookQueryService {

    @Resource
    BookService bookService;

    @Resource
    BookRepository bookRepository;


    @Override
    public List<BookDTO> queryBookList(BookQueryParam param) {
        List<BookPO> list = bookService.list();
        return list.stream().map(e -> {
            BookDTO bookDTO = new BookDTO();
            BeanUtils.copyProperties(e, bookDTO);
            return bookDTO;
        }).collect(Collectors.toList());
    }
}
