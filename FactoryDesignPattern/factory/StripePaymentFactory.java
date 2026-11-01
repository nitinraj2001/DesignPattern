package DesignPattern.FactoryDesignPattern.factory;

import DesignPattern.FactoryDesignPattern.product.FraudDetector;
import DesignPattern.FactoryDesignPattern.product.PaymentProcessor;
import DesignPattern.FactoryDesignPattern.product.StripeFraudDetector;
import DesignPattern.FactoryDesignPattern.product.StripePaymentProcessor;

// This class is used to represent the Stripe payment factory which is used to create
// the payment processor and fraud detector
public class StripePaymentFactory implements PaymentSystemFactory {

    /**
     * This method is used to create the payment processor
     * @return PaymentProcessor - The payment processor which is used to process the payment
     */
    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new StripePaymentProcessor();
    }

    /**
     * This method is used to create the fraud detector
     * @return FraudDetector - The fraud detector which is used to detect fraudulent activities
     */
    @Override
    public FraudDetector createFraudDetector() {
        return new StripeFraudDetector();
    }
}
