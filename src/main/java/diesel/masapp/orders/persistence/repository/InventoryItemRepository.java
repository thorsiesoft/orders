package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.domain.ItemClassification;
import diesel.masapp.orders.domain.ItemSize;
import diesel.masapp.orders.domain.Product;
import diesel.masapp.orders.persistence.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "item-type", path = "item-type-details")
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByClassificationAndProductAndSizeAndDebonedAndSkinned(ItemClassification classification, Product product,
                                                                                      ItemSize itemSize, boolean deboned, boolean skinned);
}
