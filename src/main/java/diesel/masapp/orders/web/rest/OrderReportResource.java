package diesel.masapp.orders.web.rest;

import diesel.masapp.orders.domain.CustomerOrderLineForPandas;
import diesel.masapp.orders.domain.CustomerOrderReport;
import diesel.masapp.orders.services.OrderReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/order/report", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
@Api(tags = "order-reports", description = "View Orders")
public class OrderReportResource {

    private OrderReportService orderReportService;

    @Autowired
    public OrderReportResource(OrderReportService orderReportService) {
        this.orderReportService = orderReportService;
    }

    @GetMapping(path = "/")
    @ApiOperation("A service to get all orders")
    public List<CustomerOrderReport> getOrders() {
        return orderReportService.getOrderReport();
    }

    @GetMapping(path = "/pandas")
    @ApiOperation("A service to get all orders")
    public List<CustomerOrderLineForPandas> getOrdersForPandas() {
        return orderReportService.getOrderReportForPandas();
    }
}
