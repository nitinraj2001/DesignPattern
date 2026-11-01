package DesignPattern.FactoryDesignPattern.product;

// This class is used to represent the PayPal fraud detector which is used to scan for scammers
public class PayPalFraudDetector implements FraudDetector {

    /**
     * This method is used to scan the transaction with the given amount
     * @param amount it is the amount of the transaction
     * @return true if the transaction is fraudulent, false otherwise
     */
    @Override
    public boolean scanTransaction(double amount) {
        System.out.println("Scanning transaction of amount: " + amount +
                " using PayPal Fraud Detector");
        return true;
    }
}
