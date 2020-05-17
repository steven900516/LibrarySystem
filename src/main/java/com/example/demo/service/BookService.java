package com.example.demo.service;

import com.example.demo.entity.BookTable;

import java.util.List;

public interface BookService {
    List<BookTable> getBookById(Long bookid);

    List<BookTable> getBooksByBookName(String bookname);
}
