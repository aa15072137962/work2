package cn.javasm.controller;

import cn.javasm.entity.Orders;
import cn.javasm.service.OrdersService;

import com.github.pagehelper.PageInfo;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersServlet {
    @Resource
    private OrdersService ordersService;

    /**
     * 分页
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    //第二种权限控制
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    @RequestMapping("/findById")
    public ModelAndView  findById(@RequestParam(value = "id", required = true) Integer ordersId) throws Exception {
        ModelAndView mv =new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
