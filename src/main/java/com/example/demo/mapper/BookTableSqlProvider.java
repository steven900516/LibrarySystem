package com.example.demo.mapper;

import com.example.demo.entity.BookTable;
import org.apache.ibatis.jdbc.SQL;

public class BookTableSqlProvider {
    public String insertSelective(BookTable record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("book_table");
        
        if (record.getBookid() != null) {
            sql.VALUES("bookid", "#{bookid,jdbcType=INTEGER}");
        }
        
        if (record.getBookname() != null) {
            sql.VALUES("bookname", "#{bookname,jdbcType=VARCHAR}");
        }
        
        if (record.getWriter() != null) {
            sql.VALUES("writer", "#{writer,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            sql.VALUES("company", "#{company,jdbcType=VARCHAR}");
        }
        
        if (record.getRestofbook() != null) {
            sql.VALUES("restofbook", "#{restofbook,jdbcType=INTEGER}");
        }
        
        if (record.getTimes() != null) {
            sql.VALUES("times", "#{times,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BookTable record) {
        SQL sql = new SQL();
        sql.UPDATE("book_table");
        
        if (record.getBookname() != null) {
            sql.SET("bookname = #{bookname,jdbcType=VARCHAR}");
        }
        
        if (record.getWriter() != null) {
            sql.SET("writer = #{writer,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            sql.SET("company = #{company,jdbcType=VARCHAR}");
        }
        
        if (record.getRestofbook() != null) {
            sql.SET("restofbook = #{restofbook,jdbcType=INTEGER}");
        }
        
        if (record.getTimes() != null) {
            sql.SET("times = #{times,jdbcType=INTEGER}");
        }
        
        sql.WHERE("bookid = #{bookid,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}