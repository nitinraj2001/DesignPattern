package DesignPattern.DecoratorDesignPattern.discount.strategy;

/**
 * This interface is used to represents the discount strategy which is used
 * to apply discount on the pizza
 */
public interface DiscountStrategy {
    public double applyDiscount(double totalAmount);
}
