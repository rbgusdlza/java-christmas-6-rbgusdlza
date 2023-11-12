package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Casher {
    private Map<Menu, Integer> orderDetails = new HashMap<>();
    private final int totalPurchaseAmount;
    private int totalDiscountAmount;

    Casher(Map<Menu, Integer> orderDetails) {
        this.orderDetails = orderDetails;
        totalPurchaseAmount = calculatePurchaseAmount(orderDetails);
    }

    private int calculatePurchaseAmount(Map<Menu, Integer> orderDetails) {
        int totalPurchaseAmount = 0;
        for (Map.Entry<Menu, Integer> orderEntry : orderDetails.entrySet()) {
            Menu menu = orderEntry.getKey();
            Integer menuCount = orderEntry.getValue();
            int menuPrice = menu.getPrice();
            totalPurchaseAmount += menuPrice * menuCount;
        }
        return totalPurchaseAmount;
    }

    public int getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    private void addDiscountAmount(int discountAmount) {
        totalDiscountAmount += discountAmount;
    }
}
