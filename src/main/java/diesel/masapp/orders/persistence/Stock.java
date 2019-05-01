package diesel.masapp.orders.persistence;

import diesel.masapp.orders.domain.ItemType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Stock {

    public static final String SEQUENCE_NAME = "stock_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    private BigDecimal price;
}
