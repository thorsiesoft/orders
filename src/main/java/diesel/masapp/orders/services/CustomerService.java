package diesel.masapp.orders.services;

import diesel.masapp.orders.persistence.Customer;
import diesel.masapp.orders.persistence.CustomerNumber;
import diesel.masapp.orders.persistence.repository.CustomerNumberRepository;
import diesel.masapp.orders.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerNumberRepository customerNumberRepository;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository, final CustomerNumberRepository customerNumberRepository) {
        this.customerRepository = customerRepository;
        this.customerNumberRepository = customerNumberRepository;
    }

    public Customer addNewCustomer(final Customer customer) {
        String groupCode = customer.getCustomerGroup().getCode();
        Optional<Long> currentMax = customerNumberRepository.findMaxNumberForGroupCode(groupCode);
        long newId;
        if (currentMax.isPresent()) {
            newId = currentMax.get().longValue() + 1;
        } else {
            newId = 1;
        }
        CustomerNumber customerNumber = new CustomerNumber();
        customerNumber.setCustomerGroupCode(groupCode);
        customerNumber.setNumber(newId);
        customerNumberRepository.save(customerNumber);

        customer.setCustomerNumber(String.format("%s%s", groupCode, String.valueOf(newId)));
        return customerRepository.save(customer);
    }
}
