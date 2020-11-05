package diesel.masapp.orders.persistence;

import diesel.masapp.orders.domain.InventoryStore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Inventory {

    public static final String SEQUENCE_NAME = "inventory_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    @ManyToOne
    private Batch batch;

    @Enumerated(EnumType.STRING)
    private InventoryStore store;

    @ManyToOne
    private InventoryItem item;

    private BigDecimal price;
    private BigDecimal weight;
    private int quantity;

    public Inventory(final Batch batch, final InventoryItem item, final BigDecimal price, final BigDecimal weight, final int quantity) {
        this.batch = batch;
        this.item = item;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public Inventory(final Batch batch, final InventoryItem item, final BigDecimal price, final BigDecimal weight, final int quantity, final InventoryStore store) {
        this.batch = batch;
        this.item = item;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.store = store;
    }
}
