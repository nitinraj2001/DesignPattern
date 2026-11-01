package DesignPattern.FactoryDesignPattern.orchestrator;

import DesignPattern.FactoryDesignPattern.factory.PaymentSystemFactory;
import DesignPattern.FactoryDesignPattern.product.FraudDetector;
import DesignPattern.FactoryDesignPattern.product.PaymentProcessor;

// This class is used to represent the checkout orchestrator which is
// used to orchestrate the checkout process
public class CheckoutOrchestrator {

    private final PaymentProcessor paymentProcessor;

    private final FraudDetector fraudDetector;

    // This constructor is used to initialize the checkout orchestrator with the given payment system factory
    public CheckoutOrchestrator(PaymentSystemFactory factory){
        this.paymentProcessor = factory.createPaymentProcessor();
        this.fraudDetector = factory.createFraudDetector();
    }

    /**
     *  This method is used to complete the payment with the given amount
     *  It first scans the transaction for fraud detection and then processes the payment if the transaction is valid
     *  Otherwise, it prints a message indicating that the transaction failed due to fraud detection
     *  It also prints messages indicating the start and end of the checkout process
     * @param amount The amount to be charged for the payment
     */
    public void completePayment(double amount){
        System.out.println("------Starting checkout process for amount: " + amount + " --------");
        if(fraudDetector.scanTransaction(amount)){
            paymentProcessor.processCharge(amount);
        } else {
            System.out.println("Transaction failed due to fraud detection");
        }
        System.out.println("------Checkout process completed for amount: " + amount + " --------");
    }
}
