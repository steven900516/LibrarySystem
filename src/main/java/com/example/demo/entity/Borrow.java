package com.example.demo.entity;

import java.util.Date;

public class Borrow {
    private Integer bookid;

    private Date borrowdate;

    private Long uid;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Date getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}