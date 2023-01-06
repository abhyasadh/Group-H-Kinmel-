package GroupH.Kinmel.Repository;

import GroupH.Kinmel.Entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepo extends JpaRepository<Checkout, Integer> {
}
