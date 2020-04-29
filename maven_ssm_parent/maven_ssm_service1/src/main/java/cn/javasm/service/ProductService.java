package cn.javasm.service;

import cn.javasm.entity.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Product> findAll();

    /**
     * 添加产品
     *
     * @param product
     */

    void add(Product product);


}
