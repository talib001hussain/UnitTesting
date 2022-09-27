package cashier;

class InValidTransactionAmount extends RuntimeException {
    public InValidTransactionAmount(String message) {
        super(message);
    }
}
