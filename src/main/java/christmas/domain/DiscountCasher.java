package christmas.domain;

import java.util.Map;

public class DiscountCasher {
    private static final int STANDARD_PURCHASE_AMOUNT = 10_000;
    private final int totalPurchaseAmount;
    private final int visitDay;
    private final XmasDiscountCalculator xmasDiscountCalculator;
    private final SpecialDiscountCalculator specialDiscountCalculator;
    private final WeekDiscountCalculator weekDiscountCalculator;
    private final EventGiver eventGiver;

    public DiscountCasher(int visitDay, int totalPurchaseAmount) {
        this.visitDay = visitDay;
        this.totalPurchaseAmount = totalPurchaseAmount;
        xmasDiscountCalculator = new XmasDiscountCalculator();
        specialDiscountCalculator = new SpecialDiscountCalculator();
        weekDiscountCalculator = new WeekDiscountCalculator();
        eventGiver = new EventGiver();
    }

    public boolean isDiscountImpossible() {
        if (totalPurchaseAmount >= STANDARD_PURCHASE_AMOUNT) {
            return false;
        }
        return true;
    }

    public int calculateXmasDiscount() {
        if (isDiscountImpossible()) {
            return 0;
        }
        return xmasDiscountCalculator.calculateDiscount(visitDay);
    }

    public int calculateWeekDiscount(OrderManager orderManager) {
        if (isDiscountImpossible()) {
            return 0;
        }
        return weekDiscountCalculator.calculateDiscount(visitDay, orderManager);
    }

    public int calculateSpecialDiscount() {
        if (isDiscountImpossible()) {
            return 0;
        }
        return specialDiscountCalculator.calculateDiscount(visitDay);
    }

    public int calculateEventDiscount() {
        return eventGiver.awardBonusMerchandise(totalPurchaseAmount);
    }

    public Map<Menu, Integer> getEventMerchandise() {
        return eventGiver.getBonusMerchandise(totalPurchaseAmount);
    }

    public Badge getEventBadge(OrderManager orderManager) {
        return eventGiver.awardBadge(getTotalDiscountAmount(orderManager));
    }

    public int getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public int getTotalDiscountAmount(OrderManager orderManager) {
        int totalDiscountAmount = 0;
        totalDiscountAmount += calculateXmasDiscount();
        totalDiscountAmount += calculateSpecialDiscount();
        totalDiscountAmount += calculateWeekDiscount(orderManager);
        totalDiscountAmount += calculateEventDiscount();
        return totalDiscountAmount;
    }

    public int calculateEstimatePurchaseAmount(OrderManager orderManager) {
        return totalPurchaseAmount - getTotalDiscountAmount(orderManager) + calculateEventDiscount();
    }

    public int getVisitDay() {
        return visitDay;
    }
}
