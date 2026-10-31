package DesignPattern.DecoratorDesignPattern.discount.chainresp;

/**
 * This class is used to represents the card payment discount strategy which is used
 * to apply card payment discount on the pizza
 */
public class CreditCardDiscount extends DiscountHandler {
    private final boolean isPremiumCard;

    public CreditCardDiscount(boolean isPremiumCard) {
        this.isPremiumCard = isPremiumCard;
    }

    @Override
    protected double applyDiscount(double amount) {
        if (isPremiumCard) {
            System.out.println("-> Applying Bank Offer: Extra ₹30 Off for Premium Cardholders");
            return Math.max(0, amount - 30);
        }
        return amount;
    }
}

