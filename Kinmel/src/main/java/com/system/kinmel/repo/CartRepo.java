package com.system.kinmel.repo;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    @Query(value = "SELECT * FROM cart WHERE user_id = ?1 AND status='Added'", nativeQuery = true)
    Optional<List<Cart>> fetchAll(Integer userId);

    @Query(value = "SELECT product_id FROM cart WHERE status='Purchased' LIMIT 4", nativeQuery = true)
    Optional<List<Integer>> fetchTrending();

    @Query(value = "SELECT product_id, COUNT(product_id) FROM cart GROUP BY product_id ORDER BY COUNT(product_id) DESC LIMIT 4", nativeQuery = true)
    Optional<List<Integer>> most();

    @Query(value = "SELECT product_id, SUM(quantity) AS sum_column1 FROM cart GROUP BY product_id ORDER BY sum_column1 DESC LIMIT 4", nativeQuery = true)
    Optional<List<Integer>> best();


    @Query(value = "SELECT user_id, COUNT(*) as count FROM Cart GROUP BY user_id",nativeQuery = true)
    List<Object[]> fetchAllCustomer();

}
