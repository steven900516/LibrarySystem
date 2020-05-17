package com.example.demo.mapper.ext;

import com.example.demo.entity.BookTable;
import com.example.demo.mapper.BookTableMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookTableMapperExt extends BookTableMapper {
    @Select("select * from book_table where bookid=#{bookid}")
    List<BookTable> getOneBook(Long bookid);

    @Select("select * from book_table where bookname=#{bookname}")
    List<BookTable> getBooksByBookName(String bookname);

    @Select("select * from book_table order by times desc")
    List<BookTable> getAllBooks();

}
