package com.system.kinmel.services;

import com.system.kinmel.entity.Wishlist;
import com.system.kinmel.pojo.WishlistPojo;

import java.security.Principal;
import java.util.List;

public interface WishlistService {
    String saveToWishlist(WishlistPojo wishlistPojo);

    String deleteFromWishlist(Integer userId, Integer productId);

    List<Wishlist> fetchAll(Integer id);
}
