package DesignPattern.DecoratorDesignPattern.discount.chainresp;

/**
 * This class is used to represents the happy hour discount strategy which is used
 * to apply happy hour discount on the pizza
 */
public class HappyHourDiscount extends DiscountHandler {

    /**
     * @param amount the total amount of the pizza
     * @return  the total amount after applying the happy hour discount
     */
    @Override
    public double applyDiscount(double amount) {
        System.out.println("-> Applying Happy Hour Discount: 10% Off");
        return amount * 0.9; // Apply 10% discount
    }
}
