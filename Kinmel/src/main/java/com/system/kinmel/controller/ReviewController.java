package com.system.kinmel.controller;

import com.system.kinmel.pojo.ReviewPojo;
import com.system.kinmel.pojo.UserPojo;
import com.system.kinmel.repo.ReviewRepo;
import com.system.kinmel.services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/save/{id}")
    public String saveReview(@PathVariable Integer id, @Valid ReviewPojo reviewPojo){
        reviewService.addReview(reviewPojo);
        return "redirect:/product/"+id;
    }

    @GetMapping("/delete/{productId}/{id}")
    public String deleteReview(@PathVariable Integer productId, @PathVariable Integer id){
        reviewService.deleteReview(id);
        return "redirect:/product/"+productId;
    }
}
