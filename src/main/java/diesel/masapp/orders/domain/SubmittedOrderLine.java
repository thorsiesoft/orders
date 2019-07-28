package diesel.masapp.orders.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmittedOrderLine {

    private String product;
    private String size;
    private boolean deboned;
    private boolean skinned;
    private int quantity;

    public SubmittedOrderLine() {
    }

    public SubmittedOrderLine(final String product, final String size, final boolean deboned,
                              final boolean skinned, final int quantity) {
        this.product = product;
        this.size = size;
        this.deboned = deboned;
        this.skinned = skinned;
        this.quantity = quantity;
    }
}
