package ch.sh.springmaster.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        //given
        Customer Jamila = new Customer(1L, "Jamila", "hello", "jamila@gmail.com");
        Customer Chyngyz = new Customer(2L, "Chyngyz", "hello", "chyngyz@gmail.com");

        customerRepository.saveAll(Arrays.asList(Jamila, Chyngyz));

        //when
        List<Customer> customers = underTest.getCustomers();

        //then
        assertEquals(2, customers.size());

    }

    @Test
    void getCustomer() {
        //given
        Customer Chyngyz = new Customer(2L, "Chyngyz", "hello", "chyngyz@gmail.com");

        customerRepository.save(Chyngyz);

        //when
        Customer actual = underTest.getCustomer(2L);

        //then
        assertEquals(2L, actual.getId());
        assertEquals("Chyngyz", actual.getName());
        assertEquals("hello", actual.getPassword());
        assertEquals("chyngyz@gmail.com", actual.getEmail());
    }

}