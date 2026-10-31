package DesignPattern.DecoratorDesignPattern;

import DesignPattern.DecoratorDesignPattern.discount.chainresp.CouponDiscount;
import DesignPattern.DecoratorDesignPattern.discount.chainresp.CreditCardDiscount;
import DesignPattern.DecoratorDesignPattern.discount.chainresp.DiscountHandler;
import DesignPattern.DecoratorDesignPattern.discount.chainresp.HappyHourDiscount;
import DesignPattern.DecoratorDesignPattern.discount.strategy.DiscountStrategy;
import DesignPattern.DecoratorDesignPattern.discount.strategy.FlatDiscount;
import DesignPattern.DecoratorDesignPattern.discount.strategy.PercentageDiscount;
import DesignPattern.DecoratorDesignPattern.pizza.BasePizza;
import DesignPattern.DecoratorDesignPattern.pizza.FarmHousePizza;
import DesignPattern.DecoratorDesignPattern.pizza.PlainPizza;
import DesignPattern.DecoratorDesignPattern.toppings.MozzarellaCheese;
import DesignPattern.DecoratorDesignPattern.toppings.MushroomTopping;

/**
 * This is the main class which is used to run the pizza order application
 */
public class PizzaOrderApp {

    public static void main(String[] args){

        // Create the base pizza instance
        BasePizza pizza1 = new PlainPizza();
        System.out.println("[Order1] " + pizza1.getDescription() + " Cost: " + pizza1.getCost());
        // Now we will order farmhouse pizza with mozzarella cheese topping
        BasePizza pizza2 = new MozzarellaCheese(new FarmHousePizza());
        System.out.println("[Order2] " + pizza2.getDescription() + " Cost: " + pizza2.getCost());
        // Now we will place third order farmhouse pizza with mushroom and mozzarellaCheese topping
        BasePizza pizza3 = new MushroomTopping(pizza2);
        System.out.println("[Order3] " + pizza3.getDescription() + " Cost: " + pizza3.getCost());

        /**
          To handle dynamically changing discounts and promotional offers, you can introduce the Strategy
          design pattern alongside your existing Decorator pattern. While the Decorator pattern excels
          at building the pizza object layer-by-layer (structural configuration), the Strategy pattern
          excels at changing how the final price is calculated based on runtime business rules (behavioral logic).

          🤝 How They Work Together

           1. Decorator constructs the pizza and calculates the Base Retail Price (e.g., Pizza + Cheese + Olives = ₹220).
           2. Strategy takes that final calculated price and applies a specific Discount Algorithm (e.g., Flat 10% off,
              Festive ₹50 off, or Buy 1 Get 1 rules).
         **/

        System.out.println("--------------------------------------------------------");

        System.out.println("[Order3] " + pizza3.getDescription() + " Cost before discount: " + pizza3.getCost());

        DiscountStrategy discountStrategy = new PercentageDiscount();

        System.out.println("-----Going to apply percentage discount of 10% on the total cost of the pizza-----");

        System.out.println("[Order3] " + pizza3.getDescription() + " Cost after discount: "
                + discountStrategy.applyDiscount(pizza3.getCost()));

        discountStrategy = new FlatDiscount();

        System.out.println("-----Going to apply flat discount of ₹50 on the total cost of the pizza-----");

        System.out.println("[Order3] " + pizza3.getDescription() + " Cost after discount: "
                + discountStrategy.applyDiscount(pizza3.getCost()));

        /**
         * The Chain of Responsibility pattern is a behavioral design pattern that lets you pass requests
         * along a chain of handlers. Upon receiving a request, each handler decides either to process the
         * request or to pass it to the next handler in the chain.
         * Think of it like a sequential filtering system or an approval pipeline where a transaction goes
         * through multiple steps (e.g., checking user login \(\rightarrow \) verifying account balance
         * \(\rightarrow \) applying coupons \(\rightarrow \) applying banking discounts).
         */

        /**

            How it integrates with our Pizza System

         1. Decorator Pattern: Assembles the physical components of the pizza (Base crust + Cheese + Toppings)
            to get the true retail price.
         2. Chain of Responsibility: Takes that initial total cost and passes it down a chain of discount
            handlers. Each handler checks if it qualifies for an offer, subtracts its share, and passes the remaining amount to the next handler.
         */

        System.out.println("--------------------------------------------------------");

        DiscountHandler happyHourDiscountHandler = new HappyHourDiscount();
        DiscountHandler creditCardDiscountHandler = new CreditCardDiscount(true);
        DiscountHandler couponDiscountHandler = new CouponDiscount("PIZZA97");

        // Need to set nextHandlers for chain of responsibility
        happyHourDiscountHandler.setNextHandler(creditCardDiscountHandler);
        creditCardDiscountHandler.setNextHandler(couponDiscountHandler);

        System.out.println("-----Going to apply chain of responsibility discount on the total cost of the pizza-----");

        // Step 4: Fire the transaction into the head of the chain

        double finalCheckoutPrice = happyHourDiscountHandler.calculateTotalAmount(pizza3.getCost());

        System.out.println("================================================");
        System.out.println("Final Billable Price at Checkout: ₹" + finalCheckoutPrice);


    }
}

