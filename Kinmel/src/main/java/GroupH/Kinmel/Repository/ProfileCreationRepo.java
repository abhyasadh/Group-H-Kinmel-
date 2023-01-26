package GroupH.Kinmel.Repository;

import GroupH.Kinmel.Entity.ProfileCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileCreationRepo extends JpaRepository<ProfileCreation, Integer> {
}
