
import com.research.model.Account;
import com.research.model.AccountStatus;
import com.research.model.AccountType;
import com.research.model.Customer;
import com.research.repository.AccountRepository;
import com.research.service.AccountService;
import com.research.service.ValidationService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Account Service Tests")
class AccountServiceTest {

    @Mock
    AccountRepository repository;

    @Mock
    ValidationService validationService;

    @InjectMocks
    AccountService service;

    Account account;

    @BeforeEach
    void setup() {
        Customer c = new Customer(1, "Sara", "s@mail.com", "555");
        AccountType type = new AccountType(1, "SAVINGS", "Savings");
        account = new Account(1, "ACC123", c, type, 500);
    }

    @Test
    @DisplayName("Block account successfully")
    void shouldBlockAccount() {
        when(repository.findByAccountNumber("ACC123"))
                .thenReturn(java.util.Optional.of(account));

        service.blockAccount("ACC123");

        assertEquals(AccountStatus.BLOCKED, account.getStatus());
    }

    @Test
    @DisplayName("Fail when account is already blocked")
    void shouldFailIfAlreadyBlocked() {
        account.setStatus(AccountStatus.BLOCKED);
        when(repository.findByAccountNumber("ACC123"))
                .thenReturn(java.util.Optional.of(account));

        // ❌ intentionally wrong expectation
        assertDoesNotThrow(() -> service.blockAccount("ACC123"));
    }
}
