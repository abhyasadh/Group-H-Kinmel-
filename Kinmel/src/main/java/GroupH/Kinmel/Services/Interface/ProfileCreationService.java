package GroupH.Kinmel.Services.Interface;

import GroupH.Kinmel.Entity.ProfileCreation;
import GroupH.Kinmel.Pojo.ProfileCreationPojo;

import java.util.List;

public interface ProfileCreationService {
    String save(ProfileCreationPojo profileCreationPojo);

    List<ProfileCreation> fetchAll();

    ProfileCreation fetchById(Integer id);
}
