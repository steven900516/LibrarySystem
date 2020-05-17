package com.example.demo.mapper;

import com.example.demo.entity.Borrow;
import org.apache.ibatis.jdbc.SQL;

public class BorrowSqlProvider {
    public String insertSelective(Borrow record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("borrow_table");
        
        if (record.getBookid() != null) {
            sql.VALUES("bookid", "#{bookid,jdbcType=INTEGER}");
        }
        
        if (record.getBorrowdate() != null) {
            sql.VALUES("borrowdate", "#{borrowdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }
}