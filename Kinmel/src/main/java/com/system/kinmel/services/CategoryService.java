package com.system.kinmel.services;

import com.system.kinmel.entity.Category;
import com.system.kinmel.pojo.CategoryPojo;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
}
