package DesignPattern.DecoratorDesignPattern.discount.strategy;

/**
 *  This class is used to represents the percentage discount strategy which is used
 *  to apply percentage discount on the pizza
 */
public class PercentageDiscount implements DiscountStrategy {
    /**
     * This method is used to apply percentage discount on the pizza
     * @param totalAmount it is the total amount of the pizza
     */
    @Override
    public double applyDiscount(double totalAmount) {
        // Implementation for percentage discount
        return totalAmount - (totalAmount * 0.1); // 10% discount
    }
}
