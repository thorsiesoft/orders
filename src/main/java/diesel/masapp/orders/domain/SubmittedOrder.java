package diesel.masapp.orders.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SubmittedOrder {

    private String customerName;
    private List<SubmittedOrderLine> orders;

    public SubmittedOrder() {
        orders = new ArrayList<>();
    }

    public SubmittedOrder(final String customerName, final List<SubmittedOrderLine> orders) {
        this.customerName = customerName;
        this.orders = orders;
    }
}
