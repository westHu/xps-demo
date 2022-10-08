package com.example.event;


import com.example.aggregate.book.BookDO;

/**
 * book新增领域事件
 */
public class BookCreateEvent extends BaseDomainEvent<BookDO> {

    public BookCreateEvent(BookDO bookDO) {
        super(bookDO);

    }
}