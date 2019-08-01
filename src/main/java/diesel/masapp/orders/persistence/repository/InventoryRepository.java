package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.persistence.Inventory;
import diesel.masapp.orders.persistence.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
