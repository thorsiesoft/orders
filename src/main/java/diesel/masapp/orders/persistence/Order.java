package diesel.masapp.orders.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Order {

    public static final String SEQUENCE_NAME = "order_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    private Customer customer;
    private Date orderPlaced;
    private Date orderConfirmed;
    private BigDecimal totalAmount;
    private boolean delivered;
    private boolean paid;
}
