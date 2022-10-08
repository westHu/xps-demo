package com.example.command.impl;

import com.example.command.BookCmdService;
import com.example.repository.BookRepository;
import com.example.service.BookService;

import javax.annotation.Resource;

public class BookCmdServiceImpl implements BookCmdService {

    @Resource
    BookService bookService;

    @Resource
    BookRepository bookRepository;


    @Override
    public void deleteBook() {
    }
}
