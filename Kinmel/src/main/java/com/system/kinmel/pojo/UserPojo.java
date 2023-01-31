package com.system.kinmel.pojo;

import com.system.kinmel.entity.Billing;
import com.system.kinmel.entity.Shipping;
import com.system.kinmel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;

    private String email;

    private String password;

    private Shipping shipping;

    private Billing billing;

    public UserPojo(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.shipping = user.getShippingId();
        this.billing = user.getBillingId();
    }
}
