package com.system.kinmel.controller.Admin;

import com.system.kinmel.entity.Category;
import com.system.kinmel.pojo.ProductPojo;
import com.system.kinmel.services.CategoryService;
import com.system.kinmel.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/addproduct")
    public String getaddProduct(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "Admin/add_product";

    }

    @GetMapping("/saveProduct")
    public String saveProduct(@Valid ProductPojo productPojo, @RequestParam("productImage")MultipartFile ProductImage) throws Exception {
        productService.saveProduct(productPojo,ProductImage);
        return "redirect:/";
    }
}
