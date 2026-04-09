package com.example.session5.service;

import com.example.session5.dao.ProductDao;
import com.example.session5.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productdao;
    public List<Product> getProducts() {
        return productdao.getProducts();
    }
}
