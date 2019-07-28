package diesel.masapp.orders.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
public class OrderLine {

    public static final String SEQUENCE_NAME = "order_line_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    private int quantity;
    @ManyToOne
    private ItemType type;
    private BigDecimal lineTotal;

    public OrderLine(final int quantity, final ItemType type, final BigDecimal lineTotal) {
        this.quantity = quantity;
        this.type = type;
        this.lineTotal = lineTotal;
    }
}
