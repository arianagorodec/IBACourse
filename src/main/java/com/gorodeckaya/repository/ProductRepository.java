package com.gorodeckaya.repository;

import com.gorodeckaya.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select a from Product a where a.price = :price")
    Product findByPrice(@Param("price") double price);
    @Query("select a from Product a where a.name = :name")
    Product findByName(@Param("name") String name);
    @Query("select a from Product a where a.manufacturer = :manufacturer")
    Product findByManufacturer(@Param("manufacturer") String manufacturer);
}
