package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.db.entity.BookPO;
import com.example.db.mpper.BookMapper;
import com.example.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookPO> implements BookService {
}
