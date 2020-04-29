package cn.javasm.service.impl;

import cn.javasm.dao.ProductDao;
import cn.javasm.entity.Product;
import cn.javasm.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);

    }
}
