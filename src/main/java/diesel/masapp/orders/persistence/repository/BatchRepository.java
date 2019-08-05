package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.persistence.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface BatchRepository extends JpaRepository<Batch, Long> {

    Optional<Batch> findByBatchDateAndHouseNumber(LocalDate batchDate, int houseNumber);

}
