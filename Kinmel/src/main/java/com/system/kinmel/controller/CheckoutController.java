package com.system.kinmel.controller;

import com.system.kinmel.entity.Wishlist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CheckoutController {
    @GetMapping("/checkout")
    public String displayWishlist(Principal principal, Model model){
        return "/Checkout";
    }
}
