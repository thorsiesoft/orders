package diesel.masapp.orders.persistence.repository;

import diesel.masapp.orders.domain.ItemClassification;
import diesel.masapp.orders.domain.ItemSize;
import diesel.masapp.orders.domain.Product;
import diesel.masapp.orders.persistence.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "item-type", path = "item-type-details")
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {

    List<ItemType> findByClassification(ItemClassification itemClassification);

    Optional<ItemType> findByProductAndSizeAndAvailableDebonedAndAvailableSkinned(Product product,
                                                                                   ItemSize itemSize,
                                                                                   boolean availableDeboned,
                                                                                   boolean availableSkinned);

    Optional<ItemType> findByProductAndSize(Product product, ItemSize itemSize);
}
