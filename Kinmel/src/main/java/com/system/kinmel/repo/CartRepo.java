package com.system.kinmel.repo;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    @Query(value = "SELECT * FROM cart WHERE user_id = ?1 AND product_id = ?2", nativeQuery = true)
    Optional<Cart> fetchByUser(Integer userId, Integer productId);

    @Query(value = "SELECT * FROM cart WHERE user_id = ?1", nativeQuery = true)
    Optional<List<Cart>> fetchAll(Integer userId);
}
