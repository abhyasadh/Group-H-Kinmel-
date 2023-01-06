package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Product;
import com.system.kinmel.pojo.ProductPojo;
import com.system.kinmel.repo.ProductRepo;
import com.system.kinmel.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;


    @Override
    public String saveUser(ProductPojo productPojo,MultipartFile ProductImage) {
        Product product = new Product();

        product.setProduct_name(productPojo.getProduct_name());
        product.setProduct_category(productPojo.getProduct_category());
        product.setProduct_color(productPojo.getProduct_color());
        String ImageUrl = saveImage(ProductImage);
        product.setProduct_image(ImageUrl);
        product.setProduct_description(productPojo.getProduct_description());
        product.setProduct_price(productPojo.getProduct_price());
        product.setProduct_quantity(productPojo.getProduct_quantity());
        product.setProduct_size(productPojo.getProduct_size());

        productRepo.save(product);

        return "DONE";
    }

    @Override
    public List<Product> fetchAll() {
        return productRepo.findAll();
    }

    private String saveImage(MultipartFile imageFile) {
        String fileName = imageFile.getOriginalFilename();

        String filePath = "src/main/resources/static/img/" + fileName;
        File dest = new File(filePath);
        try {
            imageFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/img/" + fileName;
    }

}
