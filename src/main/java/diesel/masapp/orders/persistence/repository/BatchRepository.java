package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.persistence.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch, Long> {

}
