package com.example.demo.mapper.ext;


import com.example.demo.entity.BookTable;
import com.example.demo.entity.Borrow;
import com.example.demo.mapper.BorrowMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface BorrowMapperExt extends BorrowMapper {

    @Insert("INSERT INTO borrow_table (bookid, borrowdate,uid)" + " VALUES" + "(#{bookid},#{borrowdate},#{uid});")
    void insertBook(Long uid,Long bookid, Date borrowdate);

    @Select("select * from borrow_table where uid=#{uid}")
    List<Borrow> selectAllBook(Long uid);

    @Delete("DELETE FROM borrow_table WHERE bookid=#{bookid}")
    void deleteBook(Long bookid);
}
