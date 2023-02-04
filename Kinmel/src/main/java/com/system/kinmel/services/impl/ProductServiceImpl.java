package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Product;
import com.system.kinmel.pojo.ProductPojo;
import com.system.kinmel.repo.ProductRepo;
import com.system.kinmel.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "\\images\\product\\";


    @Override
    public String saveProduct(ProductPojo productPojo) throws IOException {
        Product product = new Product();

        product.setProduct_name(productPojo.getProduct_name());
        product.setProduct_category(productPojo.getProduct_category());
        product.setProduct_color(productPojo.getProduct_color());

        if(!Objects.equals(productPojo.getProduct_image().getOriginalFilename(), "")){
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY+"profile-picture\\", productPojo.getProduct_image().getOriginalFilename());
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
        return listMapping(productRepo.findAll());
    }

    @Override
    public Product getSingle(Integer id) {
        Product product = productRepo.findById(id).orElseThrow();
        product = Product.builder()
                .id(product.getId())
                .product_size(product.getProduct_size())
                .product_quantity(product.getProduct_quantity())
                .product_category(product.getProduct_category())
                .product_image(getImageBase64(product.getProduct_image()))
                .product_color(product.getProduct_color())
                .product_name(product.getProduct_name())
                .product_description(product.getProduct_description())
                .product_price(product.getProduct_price())
                .build();
        return product;
    }

    @Override
    public List<Product> fetchByCategory(Integer id) {
        return listMapping(productRepo.findByProduct_category(id));
    }

    public List<Product> listMapping(List<Product> list){
        Stream<Product> allProductsWithImage=list.stream().map(product ->
                Product.builder()
                        .id(product.getId())
                        .product_size(product.getProduct_size())
                        .product_quantity(product.getProduct_quantity())
                        .product_category(product.getProduct_category())
                        .product_image(getImageBase64(product.getProduct_image()))
                        .product_color(product.getProduct_color())
                        .product_name(product.getProduct_name())
                        .product_description(product.getProduct_description())
                        .product_price(product.getProduct_price())
                        .build()
        );
        list = allProductsWithImage.toList();
        return new ArrayList<>(list);
    }

    public static String getImageBase64(String fileName) {
        if (fileName!=null) {
            String filePath = System.getProperty("user.dir")+"/images/product/";
            File file = new File(filePath + fileName);
            byte[] bytes;
            try {
                bytes = Files.readAllBytes(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return Base64.getEncoder().encodeToString(bytes);
        }
        return null;
    }

}
