package diesel.masapp.orders.web.rest;

import diesel.masapp.orders.domain.SubmittedOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/inventory", produces = {APPLICATION_JSON_VALUE})
@Api(tags = "Inventory of items in stock", description = "Create, Update and Delete available items in the inventory")
public class InventoryResource {

    @PostMapping(path = "/")
    @ApiOperation("A service to create a new inventory item")
    public void createInventoryItem(@RequestBody final SubmittedOrder order) {
        //orderService.createNewOrder(order);
    }
}