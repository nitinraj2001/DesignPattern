package DesignPattern.FactoryDesignPattern.product;

// This class is used to represent the Stripe payment processor which is used to process the payment
public class StripePaymentProcessor implements PaymentProcessor {

    // This method is used to process the payment with the given amount
    @Override
    public void processCharge(double amount) {
        System.out.println("Processing payment of amount: " + amount + " using Stripe Payment Processor");
    }
}
