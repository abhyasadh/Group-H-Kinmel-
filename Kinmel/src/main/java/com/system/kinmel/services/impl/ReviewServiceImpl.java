package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Review;
import com.system.kinmel.pojo.ReviewPojo;
import com.system.kinmel.repo.ReviewRepo;
import com.system.kinmel.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    @Override
    public void addReview(ReviewPojo reviewPojo) {
        Review review = new Review();
        review.setReview(reviewPojo.getReview());
        review.setRate(reviewPojo.getRate());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        review.setDate(dtf.format(now));

        review.setProduct(reviewPojo.getProduct());
        review.setUser(reviewPojo.getUser());

        reviewRepo.save(review);
    }

    @Override
    public Review getUserReview(Integer userId, Integer productId) {
        return null;
    }

    @Override
    public List<Review> getAllReviews(Integer productId) {
        return null;
    }

    @Override
    public void deleteReview(Integer reviewId) {

    }

    @Override
    public void updateReview(Integer reviewId) {

    }
}
