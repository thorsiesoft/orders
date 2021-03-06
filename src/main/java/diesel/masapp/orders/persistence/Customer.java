package diesel.masapp.orders.persistence;

import diesel.masapp.orders.domain.CustomerGroup;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
public class Customer {

    public static final String SEQUENCE_NAME = "customer_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CustomerGroup customerGroup;
    @Column(unique = true)
    private String customerNumber;
    private String contactNumber;
    private String email;
}
