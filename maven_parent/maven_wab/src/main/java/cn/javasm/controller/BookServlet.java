package cn.javasm.controller;

import cn.javasm.entity.Book;
import cn.javasm.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookServlet {
    @Resource
    private BookService bookService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户...");
        // 调用service的方法
        List<Book> list = bookService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
}
