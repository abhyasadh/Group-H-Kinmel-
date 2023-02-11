package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Product;
import com.system.kinmel.entity.Review;
import com.system.kinmel.pojo.ReviewPojo;
import com.system.kinmel.repo.ProductRepo;
import com.system.kinmel.repo.ReviewRepo;
import com.system.kinmel.repo.UserRepo;
import com.system.kinmel.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    @Override
    public void addReview(ReviewPojo reviewPojo) {

        Review review = new Review();
        review.setReview(reviewPojo.getReview());
        review.setRate(reviewPojo.getRate());
        review.setProduct(productRepo.findById(reviewPojo.getProduct()).orElseThrow());
        review.setUser(userRepo.findById(reviewPojo.getUser()).orElseThrow());
        review.setDate(Date.valueOf(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now())));

        reviewRepo.save(review);
    }

    @Override
    public List<Review> getAllReviews(Integer productId) {
        return reviewRepo.findAllByProduct(productId).orElseThrow();
    }

    @Override
    public void deleteReview(Integer reviewId) {
        reviewRepo.deleteById(reviewId);
    }
}
