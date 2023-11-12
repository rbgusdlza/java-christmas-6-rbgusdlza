package christmas.domain;

public class EventGiver {
    private static final int STANDARD_PURCHASE_AMOUNT_FOR_EVENT = 120_000;
    private static final int STANDARD_PURCHASE_AMOUNT = 10_000;

    public EventGiver() {
    }

    public Menu awardBonusMerchandise(int totalPurchaseAmount) {
        if (totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT_FOR_EVENT) {
            return null;
        }
        return Menu.CHAMPAGNE;
    }

    public Badge awardBadge(int totalPurchaseAmount, int totalDiscountAmount) {
        if (totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT) {
            return null;
        }
        return new Badge(totalDiscountAmount);
    }
}
