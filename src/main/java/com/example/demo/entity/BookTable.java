package com.example.demo.entity;

public class BookTable {
    private Long bookid;

    private String bookname;

    private String writer;

    private String description;

    private String company;

    private Integer restofbook;

    private Integer times;

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getRestofbook() {
        return restofbook;
    }

    public void setRestofbook(Integer restofbook) {
        this.restofbook = restofbook;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "BookTable{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", writer='" + writer + '\'' +
                ", description='" + description + '\'' +
                ", company='" + company + '\'' +
                ", restofbook=" + restofbook +
                ", times=" + times +
                '}';
    }
}