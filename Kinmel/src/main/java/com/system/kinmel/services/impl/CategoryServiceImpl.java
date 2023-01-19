package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Category;
import com.system.kinmel.pojo.CategoryPojo;
import com.system.kinmel.repo.CategoryRepo;
import com.system.kinmel.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;


    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();

    }
}
