package ch.sh.springmaster.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Chyngyz Sharshekeev", "password123", "email@gmail.com"),
                new Customer(2L, "Jamila Ahmed", "123password", "email@gmail.com")
        );
    }
}
