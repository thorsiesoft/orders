package diesel.masapp.orders.persistence;

import diesel.masapp.orders.domain.ItemClassification;
import diesel.masapp.orders.domain.ItemSize;
import diesel.masapp.orders.domain.Product;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
public class ItemType {

    public static final String SEQUENCE_NAME = "item_type_seq";

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

    private boolean availableDeboned;
    private boolean availableSkinned;
}
