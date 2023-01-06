package GroupH.Kinmel.Services.Impl;


import GroupH.Kinmel.Entity.Shipping;
import GroupH.Kinmel.Pojo.ShippingPojo;
import GroupH.Kinmel.Repository.ShippingRepo;
import GroupH.Kinmel.Services.Interface.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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



    //impl
}