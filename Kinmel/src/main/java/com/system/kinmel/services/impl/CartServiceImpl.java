package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Product;
import com.system.kinmel.pojo.CartPojo;
import com.system.kinmel.repo.CartRepo;
import com.system.kinmel.repo.ProductRepo;
import com.system.kinmel.repo.UserRepo;
import com.system.kinmel.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static com.system.kinmel.services.impl.ProductServiceImpl.getImageBase64;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;

    private final UserRepo userRepo;

    private final ProductRepo productRepo;

    @Override
    public String saveToCart(Integer id, Principal principal) {
        Cart cart = new Cart();
        cart.setUser(userRepo.findByEmail(principal.getName()).orElseThrow());
        cart.setProduct(productRepo.findById(id).orElseThrow());
        cart.setQuantity(1);
        cartRepo.save(cart);

        return "Saved";
    }

    @Override
    public String deleteFromCart(Integer id) {
        cartRepo.deleteById(id);
        return "Deleted";
    }

    @Override
    public String updateQuantity(Cart cart) {
        cartRepo.save(cart);
        return "Updated";
    }

    @Override
    public List<Cart> fetchAll(Integer id) {
        List<Cart> allItems = cartRepo.fetchAll(id).orElseThrow();
        for (Cart cart : allItems){
            cart.setProduct(Product.builder()
                    .id(cart.getProduct().getId())
                    .product_size(cart.getProduct().getProduct_size())
                    .product_quantity(cart.getProduct().getProduct_quantity())
                    .product_category(cart.getProduct().getProduct_category())
                    .product_image(getImageBase64(cart.getProduct().getProduct_image()))
                    .product_color(cart.getProduct().getProduct_color())
                    .product_name(cart.getProduct().getProduct_name())
                    .product_description(cart.getProduct().getProduct_description())
                    .product_price(cart.getProduct().getProduct_price())
                    .build());
        }
        return allItems;
    }

    @Override
    public Cart fetchOne(Integer id) {
        return cartRepo.findById(id).orElseThrow();
    }
}
