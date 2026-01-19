
import com.research.model.*;
import com.research.repository.TransactionRepository;
import com.research.service.AccountService;
import com.research.service.TransactionService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Transaction Service Tests")
class TransactionServiceTest {

    @Mock
    TransactionRepository repository;

    @Mock
    AccountService accountService;

    @InjectMocks
    TransactionService service;

    Account account;
    TransactionChannel channel;

    @BeforeEach
    void setup() {
        Customer c = new Customer(1, "Omar", "o@mail.com", "999");
        AccountType type = new AccountType(1, "SAVINGS", "Savings");
        account = new Account(1, "ACC999", c, type, 100);
        channel = new TransactionChannel(1, "ATM", 5, ChannelStatus.OPEN);
    }

    @Test
    @DisplayName("Deposit completes successfully")
    void depositShouldIncreaseBalance() {
        Transaction tx = service.createTransaction(
                account, channel, TransactionType.DEPOSIT, 50
        );

        service.approve(tx);

        assertEquals(150, account.getBalance());
        assertEquals(TransactionStatus.COMPLETED, tx.getStatus());
    }
    @Test
    @DisplayName("Withdraw should fail when balance is insufficient")
    void withdrawShouldFail() {
        Transaction tx = service.createTransaction(
                account, channel, TransactionType.WITHDRAW, 1000
        );

        // ❌ intentional failure
        assertDoesNotThrow(() -> service.approve(tx));
    }
}
