package cn.javasm.dao;

import cn.javasm.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    /**
     * 查询全部
     * @return
     */
    @Select("select * from book")
    List<Book> findAll();
    @Insert("insert into book(name,author_name,type) values(#{name},#{author_name},#{type})")
    void add(Book book);


}
