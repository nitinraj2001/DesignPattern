package DesignPattern.FactoryDesignPattern.product;

// Product Family Component 2: The security engine that scans for scammers
public interface FraudDetector {

    // This method is used to scan the transaction with the given amount
    public boolean scanTransaction(double amount);
}
