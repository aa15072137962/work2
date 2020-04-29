package cn.javasm.service;
import cn.javasm.entity.Book;
import java.util.List;

public interface BookService {
    //查询小说信息
    List<Book> findAll();

    // 保存小说信息
    public void saveBook(Book book);


}
