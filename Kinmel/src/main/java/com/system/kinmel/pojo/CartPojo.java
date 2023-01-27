package com.system.kinmel.pojo;

import com.system.kinmel.entity.Product;
import com.system.kinmel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartPojo {
    private Integer id;
    private Product product;
    private User user;
    private Integer quantity;
}
