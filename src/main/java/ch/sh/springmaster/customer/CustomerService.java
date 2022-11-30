package ch.sh.springmaster.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    Customer getCustomer(){
        return new Customer(1L, "Chyngyz Sharshekeev");
    }

}
