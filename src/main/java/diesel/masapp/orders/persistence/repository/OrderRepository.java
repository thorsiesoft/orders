package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.persistence.Order;
import diesel.masapp.orders.persistence.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
