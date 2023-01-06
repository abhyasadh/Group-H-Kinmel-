package GroupH.Kinmel.Services.Impl;

import GroupH.Kinmel.Entity.Checkout;
import GroupH.Kinmel.Pojo.CheckoutPojo;
import GroupH.Kinmel.Repository.CheckoutRepo;
import GroupH.Kinmel.Services.Interface.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Checkout> fetchAll() {
        return null;
    }

    @Override
    public Checkout fetchById(Integer id) {
        return checkoutRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }



    //impl
}
