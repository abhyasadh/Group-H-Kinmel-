package com.system.kinmel.services;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Wishlist;
import com.system.kinmel.pojo.CartPojo;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

public interface CartService {
    String saveToCart(Integer id, Principal principal);

    String deleteFromCart(Integer id);

    String updateQuantity(Cart cart);

    List<Cart> fetchAll(Integer id);

    List<Cart> fetchAvailable(Integer id);

    Cart fetchOne(Integer id);

    String checkout(Integer id, CartPojo pojo, List<Cart> itemsToPurchase);

    String updateProduct(double quantity, Integer id);

    List<Cart> fetchAll();

    List<Object[]> fetchCustomer();

    List<Integer> fetch5weeksales();

    List<Object[]> fetchlastweeksale();

    List<Object[]> fetchproductlastweeksales();

    List<Object[]> fetchstatusCount();

    List<String> distinctstatus();

    List<Cart> cartdetails();

    void updatecartstatus(Integer id,String status);
}
