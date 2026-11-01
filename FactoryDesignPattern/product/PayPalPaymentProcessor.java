package DesignPattern.FactoryDesignPattern.product;

// This class is used to represent the PayPal payment processor which is used to process the payment
public class PayPalPaymentProcessor implements PaymentProcessor {

    // This method is used to process the payment with the given amount
    @Override
    public void processCharge(double amount) {
        System.out.println("Processing payment of amount: " + amount +
                " using PayPal Payment Processor");
    }

}
