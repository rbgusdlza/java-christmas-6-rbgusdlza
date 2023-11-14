package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class EventGiver {
    private static final int STANDARD_PURCHASE_AMOUNT_FOR_EVENT = 120_000;
    private static final int EVENT_MERCHANDISE_COUNT = 1;
    private static final Menu EVENT_MERCHANDISE = Menu.CHAMPAGNE;

    public int awardBonusMerchandise(int totalPurchaseAmount) {
        if (totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT_FOR_EVENT) {
            return 0;
        }
        return EVENT_MERCHANDISE.getPrice() * EVENT_MERCHANDISE_COUNT;
    }

    public Map<Menu, Integer> getBonusMerchandise(int totalPurchaseAmount) {
        if (totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT_FOR_EVENT) {
            return null;
        }
        Map<Menu, Integer> bonusDetails = new HashMap<>();
        bonusDetails.put(EVENT_MERCHANDISE, EVENT_MERCHANDISE_COUNT);
        return bonusDetails;
    }

    public Badge awardBadge(int totalDiscountAmount) {
        return new Badge(totalDiscountAmount);
    }
}
