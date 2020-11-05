package diesel.masapp.orders.domain;

import lombok.Data;

@Data
public class OrderLineReport {

    private ItemClassification classification;
    private Product product;
    private ItemSize size;
    private boolean deboned;
    private boolean skinned;
    private int quantity;

}
