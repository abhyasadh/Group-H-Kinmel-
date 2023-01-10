package GroupH.Kinmel.Pojo;


import GroupH.Kinmel.Entity.Shipping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ShippingPojo {

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

    public ShippingPojo(Shipping shipping) {
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

}
