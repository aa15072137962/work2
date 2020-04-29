package cn.javasm.service.impl;

import cn.javasm.dao.BookDao;
import cn.javasm.entity.Book;
import cn.javasm.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    public List<Book> findAll() {
        return null;
    }

    public void saveBook(Book book) {

    }
}
