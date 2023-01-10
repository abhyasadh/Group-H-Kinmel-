package com.system.kinmel.repo;


import com.system.kinmel.entity.ProfileCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileCreationRepo extends JpaRepository<ProfileCreation, Integer> {
}
