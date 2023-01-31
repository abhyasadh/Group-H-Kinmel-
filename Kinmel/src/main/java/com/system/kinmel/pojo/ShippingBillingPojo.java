package com.system.kinmel.pojo;


import com.system.kinmel.entity.Billing;
import com.system.kinmel.entity.Shipping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ShippingBillingPojo {

    private Integer id;
    private String address;
    private String apartment;
    private String company_name;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String postal;
    private String state;
    private String town;
    private String country;
    private String notes;

    public ShippingBillingPojo(Shipping shipping) {
        this.id= shipping.getId();
        this.address= shipping.getAddress();
        this.apartment= shipping.getApartment();
        this.company_name= shipping.getCompanyName();
        this.email= shipping.getEmail();
        this.firstName= shipping.getFirstname();
        this.lastName= shipping.getLastname();
        this.phone= shipping.getPhone();
        this.postal= shipping.getPostal();
        this.state= shipping.getState();
        this.town= shipping.getTown();
        this.country=shipping.getCountry();
        this.notes=shipping.getNotes();
    }

    public ShippingBillingPojo(Billing billing) {
        this.id= billing.getId();
        this.address= billing.getAddress();
        this.apartment= billing.getApartment();
        this.company_name= billing.getCompanyName();
        this.email= billing.getEmail();
        this.firstName= billing.getFirstname();
        this.lastName= billing.getLastname();
        this.phone= billing.getPhone();
        this.postal= billing.getPostal();
        this.state= billing.getState();
        this.town= billing.getTown();
        this.country=billing.getCountry();
        this.notes=billing.getNotes();
    }

}
