package diesel.masapp.orders.web.rest;

import diesel.masapp.orders.persistence.Customer;
import diesel.masapp.orders.persistence.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/customers", produces = {APPLICATION_JSON_VALUE})
@Api(tags = "Customers who place orders", description = "Create, Update and Delete Customers")
public class CustomerResource {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerResource(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/")
    @ApiOperation("A service to get all the customers")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @PostMapping(path = "/")
    @ApiOperation("A service to add a customer")
    public void addCustomer(final Customer customer) {
        customerRepository.save(customer);
    }
}
