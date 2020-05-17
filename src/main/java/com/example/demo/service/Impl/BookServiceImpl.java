package com.example.demo.service.Impl;

import com.example.demo.entity.BookTable;
import com.example.demo.mapper.ext.BookTableMapperExt;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookTableMapperExt mapper;

    @Override
    public List<BookTable> getBooksByBookName(String bookname) {
        return mapper.getBooksByBookName(bookname);
    }

    @Override
    public List<BookTable> getBookById(Long bookid) {
        return mapper.getOneBook(bookid);
    }
}
