package com.example.demo;

import com.example.demo.entity.BookTable;
import com.example.demo.mapper.ext.BookTableMapperExt;
import com.example.demo.mapper.ext.BorrowMapperExt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private BookTableMapperExt  one;

    @Test
    void haha() {
        List<BookTable> two= one.getAllBooks();
        for (BookTable book : two) {
            System.out.println(book);
        }
    }

}
