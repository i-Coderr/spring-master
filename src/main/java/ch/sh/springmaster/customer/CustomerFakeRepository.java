package ch.sh.springmaster.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Chyngyz Sharshekeev", password),
                new Customer(2L, "Jamila Ahmed", password)
        );
    }
}
