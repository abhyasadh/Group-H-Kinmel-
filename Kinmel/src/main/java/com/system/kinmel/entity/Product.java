package com.system.kinmel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")

public class Product {

    @Id
    @SequenceGenerator(name = "kinmel_product_seq_gen", sequenceName = "kinmel_product_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "kinmel_product_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false,name = "product_name")
    private String product_name;

    @Column(nullable = false,name = "product_price")
    private double product_price;

    @Column(nullable = false,name = "product_quantity")
    private double product_quantity;

    @Column(nullable = false,name = "product_description")
    private String product_description;

    @Column(nullable = false,name = "product_size")
    private String product_size;

    @Column(nullable = false,name = "product_color")
    private String product_color;

    @Column(nullable = false,name = "product_category")
    private String product_category;

    @Column(name = "product_image",nullable = false)
    private String product_image;




}
