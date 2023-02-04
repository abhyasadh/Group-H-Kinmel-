package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Product;
import com.system.kinmel.entity.Wishlist;
import com.system.kinmel.pojo.CartPojo;
import com.system.kinmel.pojo.WishlistPojo;
import com.system.kinmel.repo.ProductRepo;
import com.system.kinmel.repo.UserRepo;
import com.system.kinmel.repo.WishlistRepo;
import com.system.kinmel.services.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static com.system.kinmel.services.impl.ProductServiceImpl.getImageBase64;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepo wishlistRepo;

    private final UserRepo userRepo;

    private final ProductRepo productRepo;

    @Override
    public String saveToWishlist(Integer id, Principal principal) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUser(userRepo.findByEmail(principal.getName()).orElseThrow());
        wishlist.setProduct(productRepo.findById(id).orElseThrow());
        wishlistRepo.save(wishlist);
        return "Saved";
    }

    @Override
    public String deleteFromWishlist(Integer id) {
        wishlistRepo.deleteById(id);
        return "Deleted";
    }

    @Override
    public List<Wishlist> fetchAll(Integer id) {
        List<Wishlist> allItems = wishlistRepo.fetchAll(id).orElseThrow();
        for (Wishlist wishlist : allItems){
            wishlist.setProduct(Product.builder()
                    .id(wishlist.getProduct().getId())
                    .product_size(wishlist.getProduct().getProduct_size())
                    .product_quantity(wishlist.getProduct().getProduct_quantity())
                    .product_category(wishlist.getProduct().getProduct_category())
                    .product_image(getImageBase64(wishlist.getProduct().getProduct_image()))
                    .product_color(wishlist.getProduct().getProduct_color())
                    .product_name(wishlist.getProduct().getProduct_name())
                    .product_description(wishlist.getProduct().getProduct_description())
                    .product_price(wishlist.getProduct().getProduct_price())
                    .build());
        }
        return allItems;
    }
}
