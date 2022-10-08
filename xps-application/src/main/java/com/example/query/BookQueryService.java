package com.example.query;

import com.example.query.dto.BookDTO;
import com.example.query.param.BookQueryParam;

import java.util.List;

public interface BookQueryService {

    List<BookDTO> queryBookList(BookQueryParam param);
}
