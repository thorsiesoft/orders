package diesel.masapp.orders.web.rest;

import diesel.masapp.orders.domain.SubmittedOrder;
import diesel.masapp.orders.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/order", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
@Api(tags = "orders", description = "Create, Update and Delete Orders")
public class OrderResource {

    private OrderService orderService;

    @Autowired
    public OrderResource(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/")
    @ApiOperation("A service to create a new order")
    public void createOrder(@RequestBody final SubmittedOrder order) {
        orderService.createNewOrder(order);
    }

}
