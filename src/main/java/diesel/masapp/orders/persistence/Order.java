package diesel.masapp.orders.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "CUSTOMER_ORDER")
public class Order {

    public static final String SEQUENCE_NAME = "order_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    @ManyToOne
    private Customer customer;
    private Date orderPlaced;
    private Date orderConfirmed;
    private BigDecimal totalAmount;
    private boolean delivered;
    private boolean paid;

    @OneToMany
    private List<OrderLine> lines;
}
