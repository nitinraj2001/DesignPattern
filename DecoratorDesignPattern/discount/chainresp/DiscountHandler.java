package DesignPattern.DecoratorDesignPattern.discount.chainresp;

/**
 * This class is used to represents the discount handler which is used to apply discount on the pizza
 */
public abstract class DiscountHandler {

    // it is used to represents the next handler in the chain of responsibility pattern
    protected DiscountHandler nextHandler;

    /**
     * This method is used to set the next handler in the chain
     * @param handler the next handler in the chain
     */
    public void setNextHandler(DiscountHandler handler){
        this.nextHandler = handler;
    }

    /**
     * This method is used to calculate the total amount after applying the discount
     * @param amount the total amount of the pizza
     * @return  the total amount after applying the discount
     */
    public double calculateTotalAmount(double amount){
        double totalAmount = applyDiscount(amount);
        if(nextHandler != null){
            return nextHandler.calculateTotalAmount(totalAmount);
        }
        return totalAmount;
    }

    /**
     * This method is used to apply the discount on the pizza
     * @param amount the total amount of the pizza
     * @return  the total amount after applying the discount
     */
    protected abstract double applyDiscount(double amount);


}
