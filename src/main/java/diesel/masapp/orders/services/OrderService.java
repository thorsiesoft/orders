package diesel.masapp.orders.services;

import diesel.masapp.orders.domain.ItemSize;
import diesel.masapp.orders.domain.Product;
import diesel.masapp.orders.domain.SubmittedOrder;
import diesel.masapp.orders.persistence.Customer;
import diesel.masapp.orders.persistence.ItemType;
import diesel.masapp.orders.persistence.Order;
import diesel.masapp.orders.persistence.OrderLine;
import diesel.masapp.orders.persistence.repository.CustomerRepository;
import diesel.masapp.orders.persistence.repository.ItemTypeRepository;
import diesel.masapp.orders.persistence.repository.OrderLineRepository;
import diesel.masapp.orders.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderLineRepository orderLineRepository;
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ItemTypeRepository itemTypeRepository;

    public OrderService(final OrderLineRepository orderLineRepository, final OrderRepository orderRepository,
                        final CustomerRepository customerRepository, final ItemTypeRepository itemTypeRepository) {
        this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemTypeRepository = itemTypeRepository;
    }

    public void createNewOrder(final SubmittedOrder submittedOrder) {
        Optional<Customer> customerOptional = customerRepository.findByName(submittedOrder.getCustomerName());
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            List<OrderLine> savedOrderLines = new ArrayList();

            submittedOrder.getOrders().stream().forEach(submittedOrderLine -> {
                Optional<ItemType> itemTypeOptional = itemTypeRepository.findByProductAndSizeAndAvailableDebonedAndAvailableSkinned(
                        Product.fromString(submittedOrderLine.getProduct()),
                        ItemSize.fromString(submittedOrderLine.getSize()),
                        submittedOrderLine.isDeboned(),
                        submittedOrderLine.isSkinned());

                if (itemTypeOptional.isPresent()) {
                    OrderLine orderLine = new OrderLine(submittedOrderLine.getQuantity(), itemTypeOptional.get(), BigDecimal.ZERO);
                    OrderLine saveOrderLine = orderLineRepository.save(orderLine);
                    savedOrderLines.add(saveOrderLine);
                }
            });

            Order order = new Order(customer, LocalDateTime.now(), null, BigDecimal.ZERO, false, false,
                    savedOrderLines);
            orderRepository.save(order);
        }

    }
}
