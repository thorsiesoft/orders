package diesel.masapp.orders.web.rest;

import diesel.masapp.orders.persistence.Order;
import diesel.masapp.orders.persistence.OrderLine;
import diesel.masapp.orders.persistence.repository.OrderLineRepository;
import diesel.masapp.orders.persistence.repository.OrderRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/order", produces = {APPLICATION_JSON_VALUE})
@Api(tags = "orders", description = "Create, Update and Delete Orders")
public class OrderResource {

    private OrderLineRepository orderLineRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderResource(final OrderLineRepository orderLineRepository, final OrderRepository orderRepository) {
        this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping(path = "/line")
    @ApiOperation("A service to create a new order line")
    public void createOrderLine(final OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }

    @PostMapping(path = "/")
    @ApiOperation("A service to create a new order")
    public void createOrder(final Order order) {
        orderRepository.save(order);
    }

}
