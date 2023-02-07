package com.system.kinmel.repo;

import com.system.kinmel.entity.Product;
import com.system.kinmel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM products WHERE product_category = ?1", nativeQuery = true)
    List<Product> findByProduct_category(Integer category);

    @Query(value = "SELECT * FROM products ORDER BY date DESC LIMIT 4", nativeQuery = true)
    List<Product> findNew();

    @Query(value = "UPDATE products set product_quantity = ?1 where id = ?2", nativeQuery = true)
    String updateQuantity(double newQuantity, Integer id);

}
