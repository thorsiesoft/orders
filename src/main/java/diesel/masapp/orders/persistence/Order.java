package diesel.masapp.orders.persistence;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CUSTOMER_ORDER")
public class Order {

    public static final String SEQUENCE_NAME = "order_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    @ManyToOne
    private Customer customer;
    private LocalDateTime orderPlaced;
    private LocalDateTime orderConfirmed;
    private BigDecimal totalAmount;
    private boolean delivered;
    private boolean paid;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<OrderLine> lines;

    public Order(final Customer customer, final LocalDateTime orderPlaced, final LocalDateTime orderConfirmed, final BigDecimal totalAmount,
                 final boolean delivered, final boolean paid, final List<OrderLine> lines) {
        this.customer = customer;
        this.orderPlaced = orderPlaced;
        this.orderConfirmed = orderConfirmed;
        this.totalAmount = totalAmount;
        this.delivered = delivered;
        this.paid = paid;
        this.lines = lines;
    }
}
