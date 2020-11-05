package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.persistence.CustomerNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerNumberRepository extends JpaRepository<CustomerNumber, Long> {

    List<CustomerNumber> findByCustomerGroupCode(String customerGroupCode);

    @Query(value = "SELECT max(number) FROM CustomerNumber where customerGroupCode = ?1")
    Optional<Long> findMaxNumberForGroupCode(String customerGroupCode);

}
