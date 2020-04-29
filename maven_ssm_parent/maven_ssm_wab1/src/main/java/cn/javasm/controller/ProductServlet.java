package cn.javasm.controller;

import cn.javasm.entity.Product;
import cn.javasm.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import java.util.List;
@Controller
@RequestMapping("/product")
public class ProductServlet {
    @Resource
    private ProductService productService;
    //查询全部产品
    @RequestMapping("/findAll")
    //权限控制，表示只有"ADMIN"能访问
    //jsr250-api
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list1");
        return mv;
    }
     @RequestMapping("/add")
     public String add(Product product) throws Exception{
        productService.add(product);
        return "redirect:/product/findAll";
     }
}
