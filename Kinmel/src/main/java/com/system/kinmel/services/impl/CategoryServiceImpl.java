package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Category;
import com.system.kinmel.repo.CategoryRepo;
import com.system.kinmel.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> fetchAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepo.findById(id);
    }
}
