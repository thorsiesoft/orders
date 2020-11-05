package diesel.masapp.orders.domain;

import lombok.Data;

import java.util.List;

@Data
public class OrderReport {

    private long orderId;
    private List<OrderLineReport> orderLines;
}
