package com.system.kinmel.controller;

import com.system.kinmel.repo.ReviewRepo;
import com.system.kinmel.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
}
