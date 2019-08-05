package diesel.masapp.orders.persistence;

import diesel.masapp.orders.domain.ItemClassification;
import diesel.masapp.orders.domain.ItemSize;
import diesel.masapp.orders.domain.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
public class InventoryItem {

    public static final String SEQUENCE_NAME = "inventory_item_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    @Enumerated(EnumType.STRING)
    private ItemClassification classification;
    @Enumerated(EnumType.STRING)
    private Product product;
    @Enumerated(EnumType.STRING)
    private ItemSize size;

    private boolean deboned;
    private boolean skinned;

    public InventoryItem(final ItemClassification classification, final Product product) {
        this.classification = classification;
        this.product = product;
    }

    public InventoryItem(ItemClassification classification, Product product, ItemSize size) {
        this.classification = classification;
        this.product = product;
        this.size = size;
    }

    public InventoryItem(ItemClassification classification, Product product, ItemSize size, boolean deboned, boolean skinned) {
        this.classification = classification;
        this.product = product;
        this.size = size;
        this.deboned = deboned;
        this.skinned = skinned;
    }
}
