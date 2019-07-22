package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.persistence.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
