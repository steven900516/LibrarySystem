package com.example.demo.mapper;

import com.example.demo.entity.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface BorrowMapper {
    @Insert({
        "insert into borrow_table (bookid, borrowdate, ",
        "uid)",
        "values (#{bookid,jdbcType=INTEGER}, #{borrowdate,jdbcType=TIMESTAMP}, ",
        "#{uid,jdbcType=BIGINT})"
    })
    int insert(Borrow record);

    @InsertProvider(type=BorrowSqlProvider.class, method="insertSelective")
    int insertSelective(Borrow record);
}