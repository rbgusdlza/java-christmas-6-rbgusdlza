package christmas.domain;

public class EventGiver {
    private static final int STANDARD_PURCHASE_AMOUNT = 10_000;
    private static final int STANDARD_PURCHASE_AMOUNT_FOR_EVENT = 120_000;

    private final int totalPurchaseAmount;

    public EventGiver(int totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public Menu awardBonusMerchandise(int totalPurchaseAmount) {
        if (totalPurchaseAmount >= STANDARD_PURCHASE_AMOUNT_FOR_EVENT) {
            return Menu.CHAMPAGNE;
        }
        return null;
    }

    public Badge awardBadge(int totalDiscountAmount) {
        if (totalPurchaseAmount >= STANDARD_PURCHASE_AMOUNT) {
            return new Badge(totalDiscountAmount);
        }
        return null;
    }
}
