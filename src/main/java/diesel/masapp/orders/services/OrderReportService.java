package diesel.masapp.orders.services;

import diesel.masapp.orders.domain.CustomerOrderLineForPandas;
import diesel.masapp.orders.domain.CustomerOrderReport;
import diesel.masapp.orders.domain.OrderLineReport;
import diesel.masapp.orders.domain.OrderReport;
import diesel.masapp.orders.persistence.Customer;
import diesel.masapp.orders.persistence.Order;
import diesel.masapp.orders.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderReportService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderReportService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<CustomerOrderReport> getOrderReport() {
        //List<CustomerOrderReport> orderReports = new ArrayList<>();
        //CustomerOrderReport customerOrderReport = new CustomerOrderReport();

        List<Order> orders = orderRepository.findAll();
        Map<Customer, List<Order>> ordersPerCustomer = orders.stream().collect(Collectors.groupingBy(Order::getCustomer));

        List<CustomerOrderReport> customerOrderReports = ordersPerCustomer.entrySet().stream().map(entry -> {
            CustomerOrderReport customerOrderReport = new CustomerOrderReport();
            customerOrderReport.setCustomerName(entry.getKey().getName());
            List<OrderReport> orderReports1 = entry.getValue().stream().map(value -> {
                OrderReport orderReport = new OrderReport();
                orderReport.setOrderId(value.getId());
                List<OrderLineReport> orderLineReports = value.getLines().stream().map(orderLine -> {
                    OrderLineReport orderLineReport = new OrderLineReport();
                    orderLineReport.setQuantity(orderLine.getQuantity());
                    orderLineReport.setClassification(orderLine.getType().getClassification());
                    orderLineReport.setProduct(orderLine.getType().getProduct());
                    orderLineReport.setSize(orderLine.getType().getSize());
                    orderLineReport.setDeboned(orderLine.isDeboned());
                    orderLineReport.setSkinned(orderLine.isSkinned());

                    return orderLineReport;
                }).collect(Collectors.toList());
                orderReport.setOrderLines(orderLineReports);

                return orderReport;
            }).collect(Collectors.toList());
            customerOrderReport.setOrders(orderReports1);
            return customerOrderReport;
        }).collect(Collectors.toList());

        return customerOrderReports;
    }

    public List<CustomerOrderLineForPandas> getOrderReportForPandas() {
        List<Order> orders = orderRepository.findAll();
        Map<Customer, List<Order>> ordersPerCustomer = orders.stream().collect(Collectors.groupingBy(Order::getCustomer));

        List<CustomerOrderLineForPandas> customerOrderReports = ordersPerCustomer.entrySet().stream().map(entry -> {
            List<CustomerOrderLineForPandas> customerOrderLineForPandasList = entry.getValue().stream().map(value -> {
                List<CustomerOrderLineForPandas> orderLineReports = value.getLines().stream().map(orderLine -> {
                    CustomerOrderLineForPandas customerOrderLineForPandas = new CustomerOrderLineForPandas();
                    customerOrderLineForPandas.setCustomerName(entry.getKey().getName());
                    customerOrderLineForPandas.setOrderId(value.getId());
                    customerOrderLineForPandas.setOrderLineId(orderLine.getId());
                    customerOrderLineForPandas.setQuantity(orderLine.getQuantity());
                    customerOrderLineForPandas.setClassification(orderLine.getType().getClassification());
                    customerOrderLineForPandas.setProduct(orderLine.getType().getProduct());
                    customerOrderLineForPandas.setSize(orderLine.getType().getSize());
                    customerOrderLineForPandas.setDeboned(orderLine.isDeboned());
                    customerOrderLineForPandas.setSkinned(orderLine.isSkinned());

                    return customerOrderLineForPandas;
                }).collect(Collectors.toList());
                return orderLineReports;
            }).flatMap(customerOrderLineForPandas -> customerOrderLineForPandas.stream()).collect(Collectors.toList());

            return customerOrderLineForPandasList;
        }).flatMap(customerOrderLineForPandas -> customerOrderLineForPandas.stream()).collect(Collectors.toList());

        return customerOrderReports;
    }
}
