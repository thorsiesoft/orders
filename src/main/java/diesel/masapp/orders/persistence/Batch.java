package diesel.masapp.orders.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@Entity
@Data
public class Batch {

    public static final String SEQUENCE_NAME = "batch_seq";

    @Id
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
    private long id;

    private int houseNumber;

    @DateTimeFormat(iso = DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate batchDate;
}
