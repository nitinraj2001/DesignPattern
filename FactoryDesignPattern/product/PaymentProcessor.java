package DesignPattern.FactoryDesignPattern.product;

// This interface is used to represent the payment processor which is used to process the payment
public interface PaymentProcessor {

    // This method is used to process the payment with the given amount
    public void processCharge(double amount);
}
