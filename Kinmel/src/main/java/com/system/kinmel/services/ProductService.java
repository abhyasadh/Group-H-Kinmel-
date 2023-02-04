package com.system.kinmel.services;

import com.system.kinmel.entity.Product;
import com.system.kinmel.pojo.ProductPojo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    String saveProduct(ProductPojo productPojo) throws IOException;
    List<Product> fetchAll();
    Product getSingle(Integer id);
    List<Product> fetchByCategory(Integer id);
}
