package com.system.kinmel.services.impl;

import com.system.kinmel.entity.Checkout;
import com.system.kinmel.pojo.CheckoutPojo;
import com.system.kinmel.repo.CheckoutRepo;
import com.system.kinmel.services.CheckoutService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepo checkoutRepo;

    @Override
    public String save(CheckoutPojo checkoutPojo) {
        Checkout checkout = new Checkout();
        if(checkout.getId()!=null){
            checkout.setId(checkoutPojo.getId());
        }
        checkout.setEmail(checkoutPojo.getEmail());
        checkout.setAddress(checkoutPojo.getAddress());
        checkout.setApartment(checkoutPojo.getApartment());
        checkout.setFirstname(checkoutPojo.getFirstName());
        checkout.setLastname(checkoutPojo.getLastName());
        checkout.setCompanyName(checkoutPojo.getCompany_name());
        checkout.setPhone(checkoutPojo.getPhone());
        checkout.setState(checkoutPojo.getState());
        checkout.setPostal(checkoutPojo.getPostal());
        checkout.setTown(checkoutPojo.getTown());
        return "created";
    }

}
