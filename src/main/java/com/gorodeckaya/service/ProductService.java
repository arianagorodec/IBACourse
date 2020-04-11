package com.gorodeckaya.service;

import com.gorodeckaya.entity.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product allowance);
    void deleteById(long id);
    Product getByName(String id_employee);
    Product getByPrice(double price);
    Product getByManufacturer(String manufacturer);
    Product editProduct(Product product);
    List<Product> getAll();
}
