package cn.javasm.dao;

import cn.javasm.entity.Member;
import cn.javasm.entity.Orders;
import cn.javasm.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "cn.javasm.dao.ProductDao.findById")),
    })
    List<Orders> findAll();

    /**
     * 多表查询
     *
     * @param orderId
     * @return
     */
    @Select("select * from orders where id=#{orderId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "cn.javasm.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "cn.javasm.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.javasm.dao.TravellerDao.findByOrdersId"))
    })
    Orders findById(Integer orderId);


}
