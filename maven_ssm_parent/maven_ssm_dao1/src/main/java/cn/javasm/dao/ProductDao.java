package cn.javasm.dao;


import cn.javasm.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    Product findById(Integer id);

    /**
     * 查询全部信息
     *
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();

    /**
     * 添加产品
     *
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum}," +
            "#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void add(Product product);


}
