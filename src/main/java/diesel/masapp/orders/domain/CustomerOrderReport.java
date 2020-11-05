package diesel.masapp.orders.domain;

import lombok.Data;

import java.util.List;

@Data
public class CustomerOrderReport {

    public String customerName;
    public List<OrderReport> orders;
}
