package diesel.masapp.orders.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SubmittedInventory {

    private LocalDate batchDate;
    private int houseNumber;
    private String itemClassification;
    private String productType;
    private String size;
    private boolean deboned;
    private boolean skinned;
    private double price;

    public SubmittedInventory() {
    }

    public SubmittedInventory(final LocalDate batchDate, final int houseNumber, final String itemClassification,
                              final String productType, final double price) {
        this.batchDate = batchDate;
        this.houseNumber = houseNumber;
        this.itemClassification = itemClassification;
        this.productType = productType;
        this.price = price;
    }

    public SubmittedInventory(final LocalDate batchDate, final int houseNumber, final String itemClassification, final String productType,
                              final String size, final boolean deboned, final boolean skinned, final double price) {
        this.batchDate = batchDate;
        this.houseNumber = houseNumber;
        this.itemClassification = itemClassification;
        this.productType = productType;
        this.size = size;
        this.deboned = deboned;
        this.skinned = skinned;
        this.price = price;
    }
}
