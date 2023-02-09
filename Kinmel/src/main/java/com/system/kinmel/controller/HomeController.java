package com.system.kinmel.controller;

import com.system.kinmel.entity.*;
import com.system.kinmel.pojo.ProductPojo;
import com.system.kinmel.pojo.ReviewPojo;
import com.system.kinmel.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.sql.Date;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;
    private final UserService userService;
    private final CartService cartService;
    private final CategoryService categoryService;
    private final ReviewService reviewService;
    private final SaleService saleService;

    @GetMapping("/dashboard")
    public String getHomePage(Model model, Principal principal) {
        List<Product> products = productService.fetchAll();
        model.addAttribute("products", products);

        Integer id = userService.findByEmail(principal.getName()).getId();
        List<Cart> list = cartService.fetchAll(id);

        double total = 0.0;
        for(Cart totalCalc:list){
            if (totalCalc.getProduct().getProduct_quantity()>0) total += totalCalc.getQuantity()*totalCalc.getProduct().getProduct_price();
        }

        List<Sale> salesList = saleService.getSales();
        model.addAttribute("sales", salesList);

        List<Product> newProducts = productService.fetchNew();
        model.addAttribute("newProducts", newProducts);

        Map<Integer, Double> newDiscount = productService.comparePrice(newProducts);
        model.addAttribute("newDiscount", newDiscount);

        List<Product> trendingProducts = productService.trending();
        model.addAttribute("trending", trendingProducts);

        Map<Integer, Double> trendingProductsDiscount = productService.comparePrice(trendingProducts);
        model.addAttribute("trendingProductsDiscount", trendingProductsDiscount);

        List<Product> mostPopular = productService.mostPopular();
        model.addAttribute("popular", mostPopular);

        Map<Integer, Double> popularDiscount = productService.comparePrice(trendingProducts);
        model.addAttribute("popularDiscount", popularDiscount);

        List<Product> bestSeller = productService.bestSeller();
        model.addAttribute("seller", bestSeller);

        Map<Integer, Double> sellerDiscount = productService.comparePrice(bestSeller);
        model.addAttribute("sellerDiscount", sellerDiscount);

        model.addAttribute("total", total);
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

        double total = 0.0;
        for(Cart totalCalc:list){
            if (totalCalc.getProduct().getProduct_quantity()>0) total += totalCalc.getQuantity()*totalCalc.getProduct().getProduct_price();
        }

        model.addAttribute("total", total);
        model.addAttribute("cartItems", list);

        return "/contact";
    }

    @GetMapping("/about")
    public String aboutPage(Principal principal, Model model){
        Integer id = userService.findByEmail(principal.getName()).getId();

        List<Cart> list = cartService.fetchAll(id);
        double total = 0.0;
        for(Cart totalCalc:list){
            if (totalCalc.getProduct().getProduct_quantity()>0) total += totalCalc.getQuantity()*totalCalc.getProduct().getProduct_price();
        }

        model.addAttribute("total", total);
        model.addAttribute("cartItems", list);

        return "/about";
    }

    @GetMapping("/blogs")
    public String blogPage(Principal principal, Model model){

        Integer id = userService.findByEmail(principal.getName()).getId();

        List<Cart> list = cartService.fetchAll(id);
        double total = 0.0;
        for(Cart totalCalc:list){
            if (totalCalc.getProduct().getProduct_quantity()>0) total += totalCalc.getQuantity()*totalCalc.getProduct().getProduct_price();
        }

        model.addAttribute("total", total);
        model.addAttribute("cartItems", list);

        return "/blog";
    }

    @GetMapping("/shop")
    public String productsPage(Principal principal, Model model){

        Integer id = userService.findByEmail(principal.getName()).getId();

        List<Cart> list = cartService.fetchAll(id);
        double total = 0.0;
        for(Cart totalCalc:list){
            if (totalCalc.getProduct().getProduct_quantity()>0) total += totalCalc.getQuantity()*totalCalc.getProduct().getProduct_price();
        }

        model.addAttribute("total", total);
        model.addAttribute("cartItems", list);

        List<Product> products = productService.fetchAll();
        model.addAttribute("products", products);

        Map<Integer, Double> discount = productService.comparePrice(products);

        List<Category> categories = categoryService.fetchAll();
        model.addAttribute("categories", categories);

        return "/category";
    }

    @GetMapping("/shop/{categoryId}")
    public String eachCategoryPage(@PathVariable Integer categoryId, Principal principal, Model model){

        Integer id = userService.findByEmail(principal.getName()).getId();

        List<Cart> list = cartService.fetchAll(id);
        double total = 0.0;
        for(Cart totalCalc:list){
            if (totalCalc.getProduct().getProduct_quantity()>0) total += totalCalc.getQuantity()*totalCalc.getProduct().getProduct_price();
        }

        model.addAttribute("total", total);
        model.addAttribute("cartItems", list);

        Category category = categoryService.findById(categoryId).orElseThrow();
        model.addAttribute("singleCategory", category);

        List<Product> products = productService.fetchByCategory(categoryId);
        model.addAttribute("products", products);

        Map<Integer, Double> discount = productService.comparePrice(products);

        List<Category> categories = categoryService.fetchAll();
        model.addAttribute("categories", categories);

        return "/each-category";
    }

    @GetMapping("/product/{productId}")
    public String productDetailsPage(@PathVariable Integer productId, Principal principal, Model model){

        Integer id = userService.findByEmail(principal.getName()).getId();

        List<Cart> list = cartService.fetchAll(id);
        double total = 0.0;
        for(Cart totalCalc:list){
            if (totalCalc.getProduct().getProduct_quantity()>0) total += totalCalc.getQuantity()*totalCalc.getProduct().getProduct_price();
        }

        model.addAttribute("id", id);

        model.addAttribute("total", total);
        model.addAttribute("cartItems", list);

        Product product = productService.getSingle(productId);
        model.addAttribute("product",product);

        model.addAttribute("review", new ReviewPojo());

        List<Review> reviews = reviewService.getAllReviews(productId);
        int sum=0;
        int average=0;
        for (Review i : reviews){
            i.setDate(Date.valueOf(String.valueOf(i.getDate()).substring(0,10)));
            sum+=i.getRate();
        }
        if (sum!=0) average=sum/reviews.size();
        model.addAttribute("reviews", reviews);
        model.addAttribute("average", average);

        List<Product> related = productService.fetchByCategory(product.getProduct_category().getId());
        Map<Integer, Double> discount = productService.comparePrice(related);

        List<Product> getFour = new ArrayList<>(4);
        for (int i=0; i<related.size()&&i<4; i++){
            if (!Objects.equals(related.get(i).getId(), product.getId())){
                getFour.add(related.get(i));
            }
        }

        model.addAttribute("related", getFour);

        List<Category> categories = categoryService.fetchAll();
        model.addAttribute("categories", categories);

        return "/product-details";
    }
}
