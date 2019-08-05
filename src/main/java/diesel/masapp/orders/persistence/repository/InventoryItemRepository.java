package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.persistence.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "item-type", path = "item-type-details")
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

}
