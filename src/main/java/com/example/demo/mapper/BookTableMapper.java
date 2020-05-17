package com.example.demo.mapper;

import com.example.demo.entity.BookTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.awt.print.Book;
import java.util.List;
@Mapper
public interface BookTableMapper {
    @Delete({
        "delete from book_table",
        "where bookid = #{bookid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer bookid);

    @Insert({
        "insert into book_table (bookid, bookname, ",
        "writer, description, ",
        "company, restofbook, ",
        "times)",
        "values (#{bookid,jdbcType=INTEGER}, #{bookname,jdbcType=VARCHAR}, ",
        "#{writer,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{company,jdbcType=VARCHAR}, #{restofbook,jdbcType=INTEGER}, ",
        "#{times,jdbcType=INTEGER})"
    })
    int insert(BookTable record);

    @InsertProvider(type=BookTableSqlProvider.class, method="insertSelective")
    int insertSelective(BookTable record);

    @Select({
        "select",
        "bookid, bookname, writer, description, company, restofbook, times",
        "from book_table",
        "where bookid = #{bookid,jdbcType=INTEGER}"
    })
    List<Book>selectAllBooks();

    @Results({
        @Result(column="bookid", property="bookid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bookname", property="bookname", jdbcType=JdbcType.VARCHAR),
        @Result(column="writer", property="writer", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="restofbook", property="restofbook", jdbcType=JdbcType.INTEGER),
        @Result(column="times", property="times", jdbcType=JdbcType.INTEGER)
    })
    BookTable selectByPrimaryKey(Integer bookid);

    @UpdateProvider(type=BookTableSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BookTable record);

    @Update({
        "update book_table",
        "set bookname = #{bookname,jdbcType=VARCHAR},",
          "writer = #{writer,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "company = #{company,jdbcType=VARCHAR},",
          "restofbook = #{restofbook,jdbcType=INTEGER},",
          "times = #{times,jdbcType=INTEGER}",
        "where bookid = #{bookid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BookTable record);
}