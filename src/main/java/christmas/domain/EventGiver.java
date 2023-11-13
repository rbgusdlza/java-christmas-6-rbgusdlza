package christmas.domain;

public class EventGiver {
    private static final int STANDARD_PURCHASE_AMOUNT_FOR_EVENT = 120_000;

    public int awardBonusMerchandise(int totalPurchaseAmount) {
        if (totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT_FOR_EVENT) {
            return totalPurchaseAmount;
        }
        return totalPurchaseAmount + Menu.CHAMPAGNE.getPrice();
    }

    public Badge awardBadge(int totalPurchaseAmount, int totalDiscountAmount) {
        return new Badge(totalDiscountAmount);
    }
}
