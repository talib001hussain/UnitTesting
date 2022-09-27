package cashier;

import org.junit.Test;

public class CashierTest {

    @Test(expected = IllegalArgumentException.class) // We can also use RunTimeException.class as it is the parent class
    public void validateTransactionThrowsIllegalArgumentExceptionForInvalidCurrency() {
        Cashier.validateTransaction("USD", 100);
    }

    @Test(expected = InValidTransactionAmount.class) // We can also use RunTimeException.class as it is the parent class
    public void validNegativeAmountThrowsInvalidTransactionAmountException() {
        Cashier.validateTransaction("EUR", -100);
    }
}
