package com.system.kinmel.services;

import com.system.kinmel.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> fetchAll();
    Optional<Category> findById(Integer id);
}
