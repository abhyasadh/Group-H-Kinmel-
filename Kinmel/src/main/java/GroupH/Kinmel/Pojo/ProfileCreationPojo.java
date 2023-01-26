package GroupH.Kinmel.Pojo;

import GroupH.Kinmel.Entity.ProfileCreation;
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

    public ProfileCreationPojo(ProfileCreation user) {
        this.id= user.getId();
        this.email= user.getEmail();
        this.password= user.getPassword();
    }


}
