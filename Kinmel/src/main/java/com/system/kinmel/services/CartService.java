package com.system.kinmel.services;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Wishlist;
import com.system.kinmel.pojo.CartPojo;

import java.util.List;

public interface CartService {
    String saveToCart(CartPojo cartPojo);

    String deleteFromCart(Integer userId, Integer productId);

    String updateQuantity(Integer quantity, Integer userId, Integer productId);

    List<Cart> fetchAll(Integer id);
}
