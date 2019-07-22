package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.domain.ItemClassification;
import diesel.masapp.orders.persistence.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "item-type", path = "item-type-details")
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {

    List<ItemType> findByClassification(ItemClassification itemClassification);
}
