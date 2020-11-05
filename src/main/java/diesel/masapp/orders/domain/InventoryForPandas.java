package diesel.masapp.orders.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InventoryForPandas {

    private LocalDate batchDate;
    private InventoryStore store;
    private ItemClassification classification;
    private Product product;
    private ItemSize size;
    private int quantity;
}
