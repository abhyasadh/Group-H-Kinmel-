package GroupH.Kinmel.Services.Interface;

import GroupH.Kinmel.Entity.Checkout;
import GroupH.Kinmel.Pojo.CheckoutPojo;

import java.util.List;

public interface CheckoutService {

    String save(CheckoutPojo checkoutPojo);

    List<Checkout> fetchAll();

    Checkout fetchById(Integer id);

//    void deleteById(Integer id);
}
