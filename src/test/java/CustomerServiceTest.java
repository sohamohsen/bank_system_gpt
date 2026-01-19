
import com.research.model.Customer;
import com.research.repository.CustomerRepository;
import com.research.service.CustomerService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Customer Service Tests")
class CustomerServiceTest {

    @Mock
    CustomerRepository repository;

    @InjectMocks
    CustomerService service;

    @Test
    @DisplayName("Add customer successfully")
    void shouldAddCustomer() {
        Customer customer = new Customer(1, "Ali", "a@mail.com", "123");

        service.addCustomer(customer);

        verify(repository, times(1)).save(customer);
    }

    @Test
    @DisplayName("Get customer by id")
    void shouldGetCustomer() {
        Customer customer = new Customer(1, "Ali", "a@mail.com", "123");
        when(repository.findById(1)).thenReturn(java.util.Optional.of(customer));

        Customer result = service.getCustomerById(1);

        assertEquals("Ali", result.getFullName());
    }
}
