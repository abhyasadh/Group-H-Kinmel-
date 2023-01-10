package com.system.kinmel.controller;

import com.system.kinmel.pojo.ShippingPojo;
import com.system.kinmel.services.ShippingService;
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

public class ShippingController {
    private final ShippingService shippingService;

    @GetMapping("/shipping")
    public String createShip(Model model){
        model.addAttribute("shipping", new ShippingPojo());
        return "Checkout";
    }


    @PostMapping("/saveShip")
    public String saveShip(@Valid ShippingPojo shippingPojo){
        shippingService.save(shippingPojo);
        return "redirect:/"; //router ko path
    }

}
