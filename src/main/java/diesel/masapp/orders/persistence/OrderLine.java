package diesel.masapp.orders.persistence;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
public class OrderLine {

    public static final String SEQUENCE_NAME = "order_line_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    private int quantity;
    @ManyToOne
    private ItemType type;
    private boolean deboned;
    private boolean skinned;
    private BigDecimal lineTotal;

    public OrderLine(final int quantity, final ItemType type, final BigDecimal lineTotal) {
        this.quantity = quantity;
        this.type = type;
        this.lineTotal = lineTotal;
        this.deboned = false;
        this.skinned = false;
    }

    public OrderLine(final int quantity, final ItemType type, final BigDecimal lineTotal,
                     final boolean deboned, final boolean skinned) {
        this.quantity = quantity;
        this.type = type;
        this.lineTotal = lineTotal;
        this.deboned = deboned;
        this.skinned = skinned;
    }
}
