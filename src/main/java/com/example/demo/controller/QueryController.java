package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.BookTable;
import com.example.demo.service.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/")
public class QueryController {
    @Autowired
    private BookServiceImpl bookService;
    @RequestMapping("/query")
    public JSONObject query(@RequestParam String select,@RequestParam String param ){
            JSONObject obj = new JSONObject();
            List<BookTable> books;
        if(select.equals("1")){
            books = bookService.getBookById(Long.parseLong(param));


        }else{
             books = bookService.getBooksByBookName(param);

        }
        obj.put("books",books);

        for (BookTable book : books) {
            System.out.println(book);
        }
        return obj;
    }
}
