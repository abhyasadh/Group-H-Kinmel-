package GroupH.Kinmel.Repository;

import GroupH.Kinmel.Entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepo extends JpaRepository<Shipping, Integer> {
}

