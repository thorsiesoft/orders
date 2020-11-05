package diesel.masapp.orders.web.rest;

import diesel.masapp.orders.domain.SubmittedOrder;
import diesel.masapp.orders.persistence.Order;
import diesel.masapp.orders.persistence.repository.OrderRepository;
import diesel.masapp.orders.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping(value = "/order", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
@Api(tags = "orders", description = "Create, Update and Delete Orders")
public class OrderResource {

    private OrderService orderService;
    private OrderRepository orderRepository;

    @Autowired
    public OrderResource(final OrderService orderService, final OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @PostMapping(path = "/")
    @ApiOperation("A service to create a new order")
    public void createOrder(@RequestBody final SubmittedOrder order) {
        orderService.createNewOrder(order);
    }

    @GetMapping(path = "/")
    @ApiOperation("A service to get all orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    /**
     * swagger doesn't pick up the content type. Need to curl for now..
     * curl -X DELETE "http://localhost:8080/order/Dhiresh" -H "content-type: text/plain;charset=UTF-8"
     */
    @DeleteMapping(path = "/{customerName}", consumes = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "A service to delete all orders for a customer name", consumes = TEXT_PLAIN_VALUE)
    public void deleteOrderByCustomerName(@PathVariable final String customerName) {
        orderService.deleteOrderByCustomerName(customerName);
    }
}
