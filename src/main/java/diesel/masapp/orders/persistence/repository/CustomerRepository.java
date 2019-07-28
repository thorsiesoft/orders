package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.persistence.Customer;
import diesel.masapp.orders.persistence.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByName(String name);

}
