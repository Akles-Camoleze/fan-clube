package application.backend.repository;

public class Transaction {
    private boolean transactionOpened;

    public Transaction() {
        this.transactionOpened = false;
    }

    public boolean isTransactionOpened() {
        return transactionOpened;
    }

    public void setTransactionOpened(boolean transactionOpened) {
        this.transactionOpened = transactionOpened;
    }
}
