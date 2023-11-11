package christmas.domain;

public class EventGiver {
    private static final int STANDARD_PURCHASE_AMOUNT = 120_000;

    public EventGiver() {
    }

    public boolean hasChampagne(int totalPurchaseAmount) {
        if (totalPurchaseAmount >= STANDARD_PURCHASE_AMOUNT) {
            return true;
        }
        return false;
    }

    public Badge awardBadge(int totalDiscountAmount) {
        return new Badge(totalDiscountAmount);
    }
}
