package com.system.kinmel.services;

import com.system.kinmel.entity.User;
import com.system.kinmel.pojo.UserPojo;

public interface UserService {
    void saveUser(UserPojo userPojo);
    User findByEmail(String email);
}
