package com.system.kinmel.controller;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Category;
import com.system.kinmel.entity.Product;
import com.system.kinmel.pojo.ProductPojo;
import com.system.kinmel.services.CartService;
import com.system.kinmel.services.CategoryService;
import com.system.kinmel.services.ProductService;
import com.system.kinmel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;
    private final UserService userService;
    private final CartService cartService;
    private final CategoryService categoryService;

    @GetMapping("/dashboard")
    public String getHomePage(Model model, Principal principal) {
        List<Product> products = productService.fetchAll();
        model.addAttribute("products", products);

        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Cart> list = cartService.fetchAll(id);
        model.addAttribute("cartItems", list);

        return "homepage";
    }

    @GetMapping("/add")
    public String createUser(Model model){
        model.addAttribute("product",new ProductPojo());
        return "add_product";
    }

    @GetMapping("/contact")
    public String contactPage(Principal principal, Model model){

        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Cart> list = cartService.fetchAll(id);
        model.addAttribute("cartItems", list);

        return "/contact";
    }

    @GetMapping("/about")
    public String aboutPage(Principal principal, Model model){

        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Cart> list = cartService.fetchAll(id);
        model.addAttribute("cartItems", list);

        return "/about";
    }

    @GetMapping("/blogs")
    public String blogPage(Principal principal, Model model){

        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Cart> list = cartService.fetchAll(id);
        model.addAttribute("cartItems", list);

        return "/blog";
    }

    @GetMapping("/shop")
    public String productsPage(Principal principal, Model model){

        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Cart> list = cartService.fetchAll(id);
        model.addAttribute("cartItems", list);

        List<Product> products = productService.fetchAll();
        model.addAttribute("products", products);

        List<Category> categories = categoryService.fetchAll();
        model.addAttribute("categories", categories);

        return "/category";
    }

    @GetMapping("/shop/{productId}")
    public String productDetailsPage(@PathVariable Integer productId, Principal principal, Model model){

        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Cart> list = cartService.fetchAll(id);
        model.addAttribute("cartItems", list);

        Product product = productService.getSingle(productId);
        model.addAttribute("product",product);

        return "/product-details";
    }


//    @PostMapping("/save")
//    public String SaveUser(@Valid ProductPojo productPojo, @RequestParam("productImage") MultipartFile ProductImage){
//        productService.saveUser(productPojo, ProductImage);
//        return "redirect:/";
//    }
}
