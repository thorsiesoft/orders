package diesel.masapp.orders.web.rest;

import diesel.masapp.orders.persistence.Customer;
import diesel.masapp.orders.persistence.repository.CustomerRepository;
import diesel.masapp.orders.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping(value = "/customers", produces = {APPLICATION_JSON_VALUE})
@Api(tags = "Customers who place orders", description = "Create, Update and Delete Customers")
public class CustomerResource {

    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @Autowired
    public CustomerResource(final CustomerRepository customerRepository, final CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping(path = "/")
    @ApiOperation("A service to get all the customers")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @PostMapping(path = "/")
    @ApiOperation("A service to add a customer")
    public Customer addCustomer(final Customer customer) {
        //return customerRepository.save(customer);
        return customerService.addNewCustomer(customer);
    }

    /**
     * swagger doesn't pick up the content type. Need to curl for now..
     * curl -X DELETE "http://localhost:8080/customers/Abigail" -H "content-type: text/plain;charset=UTF-8"
     */
    @DeleteMapping(path = "/{customerName}", consumes = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "A service to delete a for the provided customer name", consumes = TEXT_PLAIN_VALUE)
    public void deleteCustomerByCustomerName(@PathVariable final String customerName) {
        Optional<Customer> customerOptional = customerRepository.findByName(customerName);
        if (customerOptional.isPresent()) {
            customerRepository.delete(customerOptional.get());
        }
    }
}
