package cashier;

import java.util.Arrays;
import java.util.List;

public class Cashier {
    private static final List<String> acceptedCurrencies = Arrays.asList("EUR", "GBP");

    public static double validateTransaction(String currency, double amount) {
        if (currencyIsAccepted(currency) && amountIsValid(amount))
            return amount;
        return -1;
    }

    private static boolean amountIsValid(double amount) {
        if (amount < 0)
            throw new InValidTransactionAmount("Transaction amount must be greater than 0");
        return true;
    }

    private static boolean currencyIsAccepted(String currency) {
        if (!acceptedCurrencies.contains(currency))
            throw new IllegalArgumentException("Currency " + currency + " is not an accepted currency");
        return true;
    }
}
