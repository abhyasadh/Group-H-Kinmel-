package com.system.kinmel.services;

import com.system.kinmel.entity.Product;
import com.system.kinmel.pojo.ProductPojo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    String saveUser(ProductPojo productPojo, MultipartFile ProductImage);
    List<Product> fetchAll();
}
