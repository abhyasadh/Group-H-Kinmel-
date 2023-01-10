package GroupH.Kinmel.Pojo;

import GroupH.Kinmel.Entity.Checkout;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CheckoutPojo {

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

    public CheckoutPojo(Checkout checkout) {
        this.id= checkout.getId();
        this.address= checkout.getAddress();
        this.apartment= checkout.getApartment();
        this.company_name= checkout.getCompanyName();
        this.email= checkout.getEmail();
        this.firstName= checkout.getFirstname();
        this.lastName= checkout.getLastname();
        this.phone= checkout.getPhone();
        this.postal= checkout.getPostal();
        this.state= checkout.getState();
        this.town= checkout.getTown();

    }

}
