package diesel.masapp.orders.domain;

import lombok.Data;

@Data
public class CustomerOrderLineForPandas {

    public String customerName;
    private long orderId;
    private long orderLineId;
    private ItemClassification classification;
    private Product product;
    private ItemSize size;
    private boolean deboned;
    private boolean skinned;
    private int quantity;
}
