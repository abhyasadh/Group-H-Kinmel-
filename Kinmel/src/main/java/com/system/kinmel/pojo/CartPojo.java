package com.system.kinmel.pojo;

import com.system.kinmel.entity.Product;
import com.system.kinmel.entity.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartPojo {
    private Integer id;
    private Product product;
    private User user;
    private Integer quantity;
    private String billingAddress;
    private String billingApartment;
    private String billingCompany_name;
    private String billingEmail;
    private String billingFirstName;
    private String billingLastName;
    private String billingPhone;
    private String billingPostal;
    private String billingState;
    private String billingTown;
    private Boolean differentShipping;
    private String notes;
    private String shippingAddress;
    private String shippingApartment;
    private String shippingCompany_name;
    private String shippingEmail;
    private String shippingFirstName;
    private String shippingLastName;
    private String shippingPhone;
    private String shippingPostal;
    private String shippingState;
    private String shippingTown;
}
