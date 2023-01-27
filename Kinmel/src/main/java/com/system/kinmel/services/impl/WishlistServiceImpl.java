package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Cart;
import com.system.kinmel.entity.Wishlist;
import com.system.kinmel.pojo.CartPojo;
import com.system.kinmel.pojo.WishlistPojo;
import com.system.kinmel.repo.WishlistRepo;
import com.system.kinmel.services.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepo wishlistRepo;

    @Override
    public String saveToWishlist(WishlistPojo wishlistPojo) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUser(wishlistPojo.getUser());
        wishlist.setProduct(wishlistPojo.getProduct());
        wishlistRepo.save(wishlist);
        return "Saved";
    }

    @Override
    public String deleteFromWishlist(Integer userId, Integer productId) {
        wishlistRepo.deleteWishlistById(userId, productId);
        return "Deleted";
    }

    @Override
    public List<Wishlist> fetchAll(Integer id) {
        return wishlistRepo.fetchAll(id).orElseThrow();
    }
}
