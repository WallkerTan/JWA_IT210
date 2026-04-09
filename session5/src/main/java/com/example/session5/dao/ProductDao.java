package com.example.session5.dao;

import com.example.session5.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductDao {
    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1,"trung",120000,2),
            new Product(2,"thit",100000,2),
            new Product(3,"sua",90000,2),
            new Product(4,"rau",50000,2)
    ));

    public   List<Product> getProducts() {
        return products;
    }

}
