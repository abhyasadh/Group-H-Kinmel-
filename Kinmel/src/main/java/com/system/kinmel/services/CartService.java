package com.system.kinmel.services;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Wishlist;
import com.system.kinmel.pojo.CartPojo;

import java.security.Principal;
import java.util.List;

public interface CartService {
    String saveToCart(Integer id, Principal principal);

    String deleteFromCart(Integer id);

    String updateQuantity(Cart cart);

    List<Cart> fetchAll(Integer id);

    Cart fetchOne(Integer id);
}
