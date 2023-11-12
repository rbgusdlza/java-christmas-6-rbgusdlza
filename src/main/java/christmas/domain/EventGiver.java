package christmas.domain;

public class EventGiver {
    private static final int STANDARD_PURCHASE_AMOUNT_FOR_EVENT = 120_000;

    private EventGiver() {
    }

    public static int awardBonusMerchandise(int totalPurchaseAmount) {
        if (totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT_FOR_EVENT) {
            return 0;
        }
        return Menu.CHAMPAGNE.getPrice();
    }

    public static Badge awardBadge(int totalPurchaseAmount, int totalDiscountAmount) {
        return new Badge(totalDiscountAmount);
    }
}
