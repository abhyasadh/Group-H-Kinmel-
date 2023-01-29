package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Category;
import com.system.kinmel.entity.Product;
import com.system.kinmel.pojo.ProductPojo;
import com.system.kinmel.repo.CategoryRepo;
import com.system.kinmel.repo.ProductRepo;
import com.system.kinmel.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/kinmelfile";


    @Override
    public String saveProduct(ProductPojo productPojo,MultipartFile ProductImage) throws Exception {

        Category category = categoryRepo.findById(productPojo.getProduct_category()).orElseThrow(() -> new Exception("Invalid id"));

        Product product = new Product();

        product.setProduct_name(productPojo.getProduct_name());
        product.setCategory(category);
        product.setProduct_color(productPojo.getProduct_color());

        if(productPojo.getProduct_image()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productPojo.getProduct_image().getOriginalFilename());
            fileNames.append(productPojo.getProduct_image().getOriginalFilename());
            Files.write(fileNameAndPath, productPojo.getProduct_image().getBytes());

            product.setProduct_image(productPojo.getProduct_image().getOriginalFilename());
        }


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



}
