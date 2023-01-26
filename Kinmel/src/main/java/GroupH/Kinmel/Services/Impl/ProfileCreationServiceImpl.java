package GroupH.Kinmel.Services.Impl;

import GroupH.Kinmel.Entity.ProfileCreation;
import GroupH.Kinmel.Pojo.ProfileCreationPojo;
import GroupH.Kinmel.Repository.ProfileCreationRepo;
import GroupH.Kinmel.Services.Interface.ProfileCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileCreationServiceImpl implements ProfileCreationService {
    private final ProfileCreationRepo profileCreationRepo;


    @Override
    public String save(ProfileCreationPojo profileCreationPojo) {
        ProfileCreation user = new ProfileCreation();
        user.setEmail(profileCreationPojo.getEmail());
        user.setPassword(profileCreationPojo.getPassword());
        profileCreationRepo.save(user);
        return "created";
    }

    @Override
    public List<ProfileCreation> fetchAll() {
        return  profileCreationRepo.findAll();

    }

    @Override
    public ProfileCreation fetchById(Integer id) {
        return profileCreationRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }


}
