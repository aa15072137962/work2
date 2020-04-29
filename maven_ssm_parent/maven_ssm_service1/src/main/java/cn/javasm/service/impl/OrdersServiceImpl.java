package cn.javasm.service.impl;

import cn.javasm.dao.OrdersDao;
import cn.javasm.entity.Orders;
import cn.javasm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(Integer ordersId) {
        return ordersDao.findById(ordersId);
    }

}
