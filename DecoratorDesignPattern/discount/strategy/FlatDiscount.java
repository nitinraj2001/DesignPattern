package DesignPattern.DecoratorDesignPattern.discount.strategy;

/**
 *  This class is used to represents the flat discount strategy which is used
 *  to apply flat discount on the pizza
 */
public class FlatDiscount implements DiscountStrategy {

    /**
     * This method is used to apply flat discount on the pizza
     * @param totalAmount it is the total amount of the pizza
     * @return the discounted amount
     */
    @Override
    public double applyDiscount(double totalAmount) {
        // we have an offer of flat 50 rupees off to total amount
        return totalAmount - 50;
    }
}
