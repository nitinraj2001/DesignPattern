package DesignPattern.DecoratorDesignPattern.discount.chainresp;

public class CouponDiscount extends DiscountHandler {

    private final String userEnteredCoupon;

    protected final String validCode = "PIZZA97";

    public CouponDiscount(String userEnteredCoupon){
        this.userEnteredCoupon = userEnteredCoupon;
    }

    /**
     * @param amount the total amount of the pizza
     * @return  the total amount after applying the coupon discount
     */
    @Override
    public double applyDiscount(double amount) {
        if(validCode.equalsIgnoreCase(userEnteredCoupon)){
            System.out.println("-> Coupon Code Validated: " + userEnteredCoupon);
            System.out.println("-> Applying Coupon Discount: Rs. 5 Off");
            return Math.max(0, amount - 5); // Apply Rs. 5 discount
        } else {
            System.out.println("-> Invalid Coupon Code: " + userEnteredCoupon);
            return amount; // No discount applied
        }
    }
}
