package com.system.kinmel.controller;

import com.system.kinmel.entity.Product;
import com.system.kinmel.entity.User;
import com.system.kinmel.entity.Wishlist;
import com.system.kinmel.pojo.CartPojo;
import com.system.kinmel.pojo.WishlistPojo;
import com.system.kinmel.services.UserService;
import com.system.kinmel.services.WishlistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class WishlistController {
    private final WishlistService wishlistService;

    private final UserService userService;

    @GetMapping("/wishlist")
    public String displayWishlist(Principal principal, Model model){
        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Wishlist> list = wishlistService.fetchAll(id);
        model.addAttribute("wishlistItems", list);

        return "/wishlist";
    }

    @PostMapping("/addToWishlist")
    public String saveToWishlist(@Valid WishlistPojo wishlistPojo){
        wishlistService.saveToWishlist(wishlistPojo);
        return "redirect:/login";
    }

    @DeleteMapping("/deleteWishlist/{id}")
    public String deleteWishlistItem(@PathVariable("id") Integer id, Principal principal){
        User user = userService.findByEmail(principal.getName());
        wishlistService.deleteFromWishlist(user.getId(), id);
        return "redirect:/wishlist";
    }
}
