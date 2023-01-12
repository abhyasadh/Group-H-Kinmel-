package com.system.kinmel.services;

import com.system.kinmel.entity.Checkout;
import com.system.kinmel.pojo.CheckoutPojo;
import jakarta.validation.Valid;



public interface CheckoutService {

    String save(CheckoutPojo checkoutPojo);

}
