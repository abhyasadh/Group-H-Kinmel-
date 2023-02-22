package com.system.kinmel.controller.Admin;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Category;
import com.system.kinmel.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class OrdersController {

    private final CartService cartService;


    @GetMapping("/view_order")
    public String getOrders(Model model){

        List<Cart> carts = cartService.fetchAll();
        model.addAttribute("AllOrders",carts);
        return "Admin/view_order";

    }
}
