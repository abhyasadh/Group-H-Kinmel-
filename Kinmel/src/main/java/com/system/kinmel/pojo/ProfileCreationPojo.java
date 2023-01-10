package com.system.kinmel.pojo;


import com.system.kinmel.entity.ProfileCreation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCreationPojo {
    private Integer id;
    private String email;
    private String password;

    public ProfileCreationPojo(ProfileCreation profileCreation) {
        this.id= profileCreation.getId();
        this.email= profileCreation.getEmail();
        this.password= profileCreation.getPassword();
    }


}
