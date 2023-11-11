package christmas.domain;

import christmas.validator.DomainValidator;

public class EventGiver {
    private static final int STANDARD_PURCHASE_AMOUNT_FOR_EVENT = 120_000;

    private final int totalPurchaseAmount;

    public EventGiver(int totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public Menu awardBonusMerchandise(int totalPurchaseAmount) {
        if (totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT_FOR_EVENT) {
            return null;
        }
        return Menu.CHAMPAGNE;
    }

    public Badge awardBadge(int totalDiscountAmount) {
        if (DomainValidator.isTotalPurchaseAmountBelowThreshold(totalPurchaseAmount)) {
            return null;
        }
        return new Badge(totalDiscountAmount);
    }
}
