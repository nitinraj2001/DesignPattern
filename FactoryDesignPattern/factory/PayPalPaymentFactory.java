package DesignPattern.FactoryDesignPattern.factory;

import DesignPattern.FactoryDesignPattern.product.FraudDetector;
import DesignPattern.FactoryDesignPattern.product.PayPalFraudDetector;
import DesignPattern.FactoryDesignPattern.product.PayPalPaymentProcessor;
import DesignPattern.FactoryDesignPattern.product.PaymentProcessor;

// This class is used to represent the PayPal payment factory which is used to create
// the PayPal payment processor and fraud detector
public class PayPalPaymentFactory implements PaymentSystemFactory {

    /**
     *  This method is used to create the PayPal payment processor
     *  @return PaymentProcessor
     */
    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new PayPalPaymentProcessor();
    }

    /**
     *  This method is used to create the PayPal fraud detector
     * @return FraudDetector
     */
    @Override
    public FraudDetector createFraudDetector() {
        return new PayPalFraudDetector();
    }
}
