package DomainObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest
{

   Account account;


    @BeforeEach
    void setUp()
    {
    account = new Account("nik","1", 100);

    }

    @Test
    void indsæt()
    {
        assertEquals(200, account.deposit(100));

    }

    @Test
    void indsætNegativ()
    {
        assertEquals(100, account.deposit(-100));
    }
}