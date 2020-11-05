package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.persistence.Customer;
import diesel.masapp.orders.persistence.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);
}
