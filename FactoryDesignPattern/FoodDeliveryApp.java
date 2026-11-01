package DesignPattern.FactoryDesignPattern;

import DesignPattern.FactoryDesignPattern.factory.PayPalPaymentFactory;
import DesignPattern.FactoryDesignPattern.factory.PaymentSystemFactory;
import DesignPattern.FactoryDesignPattern.factory.StripePaymentFactory;
import DesignPattern.FactoryDesignPattern.orchestrator.CheckoutOrchestrator;

import java.util.Scanner;

/**
 *  This class is used to represent the food delivery app which is used to order food
 *  and process the payment using the payment processor and fraud detector created by the factory
 */
public class FoodDeliveryApp {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("-----Food Delivery App is running-----");

        System.out.println("-----Ordering food from the restaurant-----");

        System.out.println("-----Creating the payment processor and fraud detector using the factory-----");

        // Ask user for which payment mode they want to use let's take the input at runtime
        String paymentMode = "PayPal"; // This can be changed to "Stripe" to use Stripe payment processor

        System.out.println("Please select the payment mode you want to use (PayPal/Stripe): ");

        paymentMode = sc.next();

        System.out.println("-----User has selected the payment mode: " + paymentMode + "-----");

        PaymentSystemFactory paymentSystemFactory = null;

        if(paymentMode.equalsIgnoreCase("PayPal")){
            paymentSystemFactory = new PayPalPaymentFactory();
        } else if(paymentMode.equalsIgnoreCase("Stripe")){
            paymentSystemFactory = new StripePaymentFactory();
        } else {
            System.out.println("Invalid payment mode selected. Please select either PayPal or Stripe.");
            return;
        }

        System.out.println("-----Processing the payment using the payment processor and fraud detector-----");

        CheckoutOrchestrator checkoutOrchestrator = new CheckoutOrchestrator(paymentSystemFactory);

        checkoutOrchestrator.completePayment(100.0);

        System.out.println("-----Payment processed successfully-----");


    }
}
