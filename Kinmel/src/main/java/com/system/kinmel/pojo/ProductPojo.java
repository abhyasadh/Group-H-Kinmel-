package com.system.kinmel.pojo;

import com.system.kinmel.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPojo {
    private Integer id;

    private String product_name;

    private double product_price;

    private double product_quantity;

    private String product_description;

    private String product_size;

    private String product_color;

    private String product_category;

    private String
            product_image;

    public ProductPojo(Product product){
        this.id=product.getId();
        this.product_name=product.getProduct_name();
        this.product_price=product.getProduct_price();
        this.product_quantity=product.getProduct_quantity();
        this.product_description=product.getProduct_description();
        this.product_size=product.getProduct_size();
        this.product_color=product.getProduct_color();
        this.product_category=product.getProduct_category();
        this.product_image=product.getProduct_image();

    }
}
