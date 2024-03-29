package com.system.kinmel.services;

import com.system.kinmel.entity.Review;
import com.system.kinmel.pojo.ReviewPojo;

import java.security.Principal;
import java.util.List;

public interface ReviewService {
    void addReview(ReviewPojo reviewPojo);
    List<Review> getAllReviews(Integer productId);
    void deleteReview(Integer reviewId);
}
