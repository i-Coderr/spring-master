package ch.sh.springmaster.customer;

import ch.sh.springmaster.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    List<Customer> getCustomers(){
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> {
            NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
            log.error("Error in getting customer {}", id, notFoundException);
            return notFoundException;
        });
    }

}
