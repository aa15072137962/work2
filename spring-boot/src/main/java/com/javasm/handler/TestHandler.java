package com.javasm.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class TestHandler {
   @GetMapping("/main")
    public String Test(Model model, HttpSession session){
        model.addAttribute("s","今天天气很好");
        session.setAttribute("b","我是宇智波鼬");
        System.out.println("11111");
     return "main";
    }
}
