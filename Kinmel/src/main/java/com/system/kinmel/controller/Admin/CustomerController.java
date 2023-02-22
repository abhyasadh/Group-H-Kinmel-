package com.system.kinmel.controller.Admin;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.User;
import com.system.kinmel.services.CartService;
import com.system.kinmel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.*;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class CustomerController {
    private final CartService cartService;
    private final UserService userService;
    @GetMapping("/customers")
    public String getCustomerDetails(Model model){

        List<Object[]> customers = cartService.fetchCustomer();
        Map<String, Long> details = new HashMap<>();
        for (Object[] customer : customers) {
            Integer user = (Integer) customer[0];
            String email = userService.findUserById(user).getEmail();
            Long count = (Long) customer[1];
            details.put(email, count);
        }


        model.addAttribute("AllCustomers",details);
        return "Admin/customer_details";

    }
}
