package com.system.kinmel.controller;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Product;
import com.system.kinmel.entity.User;
import com.system.kinmel.entity.Wishlist;
import com.system.kinmel.pojo.CartPojo;
import com.system.kinmel.pojo.UserPojo;
import com.system.kinmel.services.CartService;
import com.system.kinmel.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    private final UserService userService;

    @GetMapping("/cart")
    public String displayCart(Principal principal, Model model){
        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Cart> list = cartService.fetchAll(id);
        model.addAttribute("cartItems", list);

        return "/cart";
    }

    @PostMapping("/addToCart")
    public String saveToCart(@Valid CartPojo cartPojo){
        cartService.saveToCart(cartPojo);
        return "redirect:/cart";
    }

    @PostMapping("/updateQuantity")
    public String updateQuantity(@Valid CartPojo cartPojo, Principal principal){
        Integer userId = userService.findByEmail(principal.getName()).getId();
        List<Cart> cart = cartService.fetchAll(userId);

        for (Cart i:cart){
            cartService.updateQuantity(cartPojo.getQuantity(), userId, cartPojo.getId());
        }

        return "redirect:/cart";
    }

    @DeleteMapping("/deleteCart/{id}")
    public String deleteWishlistItem(@PathVariable("id") Integer id, Principal principal){
        User user = userService.findByEmail(principal.getName());
        cartService.deleteFromCart(user.getId(), id);
        return "redirect:/cart";
    }
}
