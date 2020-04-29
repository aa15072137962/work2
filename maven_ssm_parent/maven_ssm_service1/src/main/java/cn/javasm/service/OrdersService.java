package cn.javasm.service;

import cn.javasm.entity.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Orders> findAll(int page,int size);

    /**
     * 根据id进行多表查询
     */
    Orders findById(Integer ordersId);
}
