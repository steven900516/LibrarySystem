package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.BookTable;
import com.example.demo.entity.Borrow;
import com.example.demo.mapper.ext.BookTableMapperExt;
import com.example.demo.mapper.ext.BorrowMapperExt;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/")
public class BorrowController {
    @Autowired
    private BorrowMapperExt borrowService;

    /**
     * Borrow
     * @param request
     * @param bookid
     * @return
     */
    @RequestMapping("/borrow")
    public String borrow(HttpServletRequest request, @RequestParam Long bookid) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("uid")) {
                //此处对key是bookName的业务操作 你就在这里取出你想要的东西
                cookie.getValue();
                borrowService.insertBook(Long.parseLong(cookie.getValue()), bookid, new Date());
            }
        }
        return "true";
    }



    @RequestMapping("/delete")
    public JSONObject delete(HttpServletRequest request, @RequestParam Long bookid){
        JSONObject obj = new JSONObject();
        Cookie[] cookies = request.getCookies();
        List<Borrow> returnBooks;
        borrowService.deleteBook(bookid);
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("uid")) {
                returnBooks = borrowService.selectAllBook(Long.parseLong(cookie.getValue()));
                return borrowJsonAdapter(returnBooks);
            }
        }
        return obj;
    }

    @RequestMapping("/aa")
    public JSONObject aaa(HttpServletRequest request){
        JSONObject obj = new JSONObject();
        List<Borrow> returnBooks;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("uid")) {
                returnBooks = borrowService.selectAllBook(Long.parseLong(cookie.getValue()));
                return borrowJsonAdapter(returnBooks);
            }
        }
        return obj;
    }

    private JSONObject borrowJsonAdapter(List<Borrow> list){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject obj = new JSONObject();
        obj.put("returnBooks",list);
        JSONArray array = obj.getJSONArray("returnBooks");
        for (int i = 0; i < array.size(); i++) {
            JSONObject json = array.getJSONObject(i);
            Date borrowdate = (Date) json.get("borrowdate");
            json.put("borrowdate",sdf.format(borrowdate));
            array.set(i,json);
        }
        return obj;
    }

    @Autowired
    private BookTableMapperExt showBooks;

    @RequestMapping("/show")
    public JSONObject show(){
        JSONObject  allBooks = new JSONObject();
        List<BookTable> tableBooks;
        tableBooks = showBooks.getAllBooks();
        allBooks.put("tableBooks",tableBooks);
        return allBooks;
    }





}