package com.system.kinmel.controller;

import com.system.kinmel.entity.Product;
import com.system.kinmel.pojo.ProductPojo;
import com.system.kinmel.repo.ProductRepo;
import com.system.kinmel.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class HomeController {

    private final ProductService productService;

    @GetMapping("/dashboard")
    public String getHomePage(Model model) {
        List<Product> products = productService.fetchAll();
        model.addAttribute("products", products);
        return "homepage";
    }

    @GetMapping("/add")
    public String createUser(Model model){
        model.addAttribute("product",new ProductPojo());
        return "add_product";}

//    @PostMapping("/save")
//    public String SaveUser(@Valid ProductPojo productPojo, @RequestParam("productImage") MultipartFile ProductImage){
//        productService.saveUser(productPojo, ProductImage);
//        return "redirect:/";
//    }
}
