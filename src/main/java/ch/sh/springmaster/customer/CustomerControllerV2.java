package ch.sh.springmaster.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController
public class CustomerControllerV2 {

    private final CustomerService service;

    @Autowired
    public CustomerControllerV2(CustomerService service) {
        this.service = service;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomers(){
        return Collections.singletonList(
                new Customer(0L, "V2", "V2" )
        );
    }

    @PostMapping
    void createNewCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id );
    }

}
