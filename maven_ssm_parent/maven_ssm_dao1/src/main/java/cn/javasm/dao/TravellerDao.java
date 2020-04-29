package cn.javasm.dao;

import cn.javasm.entity.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    @Select("SELECT*FROM traveller WHERE id in  (SELECT travellerId FROM order_traveller WHERE orderId=#{orderId})")
    List<Traveller> findByOrdersId(Integer orderId);
}
