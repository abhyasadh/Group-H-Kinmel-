package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.pojo.CartPojo;
import com.system.kinmel.repo.CartRepo;
import com.system.kinmel.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;

    @Override
    public String saveToCart(CartPojo cartPojo) {
        Cart cart = new Cart();
        cart.setUser(cartPojo.getUser());
        cart.setProduct(cartPojo.getProduct());
        cart.setQuantity(cartPojo.getQuantity());
        cartRepo.save(cart);

        return "Saved";
    }

    @Override
    public String deleteFromCart(Integer userId, Integer productId) {
        cartRepo.deleteCartById(userId, productId);

        return "Deleted";
    }

    @Override
    public String updateQuantity(Integer quantity, Integer userId, Integer productId) {
        cartRepo.updateQuantity(quantity, userId, productId);
        return "Updated";
    }

    @Override
    public List<Cart> fetchAll(Integer id) {
        return cartRepo.fetchAll(id).orElseThrow();
    }
}
