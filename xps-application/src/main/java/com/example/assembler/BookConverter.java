package com.example.assembler;


import com.example.aggregate.book.BookDO;
import com.example.query.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * mapstruct 转换
 */
@Mapper
public interface BookConverter {


    BookConverter INSTANCT = Mappers.getMapper(BookConverter.class);

    @Mapping(target = "name", source = "xxName")
    @Mapping(target = "id", ignore = true) // 忽略id，不进行映射
    default BookDTO conver(BookDO bookDO) {
        BookDTO bookDTO = new BookDTO();
        return bookDTO;
    }

}
