package com.system.kinmel.services.impl;
import com.system.kinmel.entity.ProfileCreation;
import com.system.kinmel.pojo.ProfileCreationPojo;
import com.system.kinmel.repo.ProfileCreationRepo;
import com.system.kinmel.services.ProfileCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileCreationServiceImpl implements ProfileCreationService {
    private final ProfileCreationRepo profileCreationRepo;


    @Override
    public String save(ProfileCreationPojo profileCreationPojo) {
        ProfileCreation profileCreation = new ProfileCreation();
        profileCreation.setEmail(profileCreationPojo.getEmail());
//        profileCreation.setPassword(profileCreationPojo.getPassword());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(profileCreationPojo.getPassword());
        profileCreation.setPassword(encodedPassword);
        profileCreationRepo.save(profileCreation);

        return "created";
    }


}
