package com.system.kinmel.services.impl;


import com.system.kinmel.entity.Shipping;
import com.system.kinmel.pojo.ShippingPojo;
import com.system.kinmel.repo.ShippingRepo;
import com.system.kinmel.services.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    private final ShippingRepo shippingRepo;

    @Override
    public String save(ShippingPojo shippingPojo) {
        Shipping shipping = new Shipping();
        if(shipping.getId()!=null){
            shipping.setId(shippingPojo.getId());
        }
        shipping.setEmail(shippingPojo.getEmail());
        shipping.setAddress(shippingPojo.getAddress());
        shipping.setApartment(shippingPojo.getApartment());
        shipping.setFirstname(shippingPojo.getFirstName());
        shipping.setLastname(shippingPojo.getLastName());
        shipping.setCompanyName(shippingPojo.getCompany_name());
        shipping.setPhone(shippingPojo.getPhone());
        shipping.setState(shippingPojo.getState());
        shipping.setPostal(shippingPojo.getPostal());
        shipping.setTown(shippingPojo.getTown());
        shipping.setCountry(shippingPojo.getCountry());
        shipping.setNotes(shippingPojo.getNotes());

        return "created";
    }




}