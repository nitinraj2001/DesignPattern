package DesignPattern.FactoryDesignPattern.factory;

import DesignPattern.FactoryDesignPattern.product.FraudDetector;
import DesignPattern.FactoryDesignPattern.product.PaymentProcessor;

// This interface is used to represent the payment system factory which is used
// to create the payment processor and fraud detector
public interface PaymentSystemFactory {

    // This method is used to create the payment processor
    public PaymentProcessor createPaymentProcessor();

    // This method is used to create the fraud detector
    public FraudDetector createFraudDetector();
}
