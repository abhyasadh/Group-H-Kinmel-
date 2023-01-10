package com.system.kinmel.controller;

import com.system.kinmel.pojo.CheckoutPojo;
import com.system.kinmel.services.CheckoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @GetMapping("/checkout")
    public String createCheckout(Model model){
        model.addAttribute("checkout", new CheckoutPojo());
        return "Checkout";
    }
    @PostMapping("/saveCheckout")
    public String saveCheckout(@Valid CheckoutPojo checkoutPojo){
        checkoutService.save(checkoutPojo);
        return "redirect:/"; //router ko path
    }


}
