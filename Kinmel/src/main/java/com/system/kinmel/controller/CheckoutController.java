package com.system.kinmel.controller;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Wishlist;
import com.system.kinmel.services.CartService;
import com.system.kinmel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CheckoutController {
    private final UserService userService;
    private final CartService cartService;
    @GetMapping("/checkout")
    public String displayWishlist(Principal principal, Model model){
        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Cart> list = cartService.fetchAll(id);
        model.addAttribute("cartItems", list);
        return "/Checkout";
    }
}
