package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class DiscountCasher {
    private Map<Menu, Integer> orderDetails = new HashMap<>();
    private final int totalPurchaseAmount;
    private final int totalDiscountAmount;
    private final int visitDay;

    DiscountCasher(Map<Menu, Integer> orderDetails, int visitDay) {
        this.orderDetails = orderDetails;
        this.visitDay = visitDay;
        totalPurchaseAmount = calculatePurchaseAmount(orderDetails);
        totalDiscountAmount = calculateDiscountAmount();
    }

    private int calculatePurchaseAmount(Map<Menu, Integer> orderDetails) {
        int totalPurchaseAmount = 0;
        for (Map.Entry<Menu, Integer> entry : orderDetails.entrySet()) {
            Menu menu = entry.getKey();
            Integer menuCount = entry.getValue();
            int menuPrice = menu.getPrice();
            totalPurchaseAmount += menuPrice * menuCount;
        }
        return totalPurchaseAmount;
    }

    private int calculateDiscountAmount() {
        if (isAmountExceeded(totalPurchaseAmount)) {
            return 0;
        }

    }

    private boolean isAmountExceeded(int totalPurchaseAmount) {
        int STANDARD_PURCHASE_AMOUNT = 10_000;
        if (totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT) {
            return false;
        }
        return true;
    }

}
