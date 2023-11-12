package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class DiscountCasher {
    private Map<Menu, Integer> orderDetails = new HashMap<>();
    private int totalPurchaseAmount;

    DiscountCasher(Map<Menu, Integer> orderDetails) {
        this.orderDetails = orderDetails;
    }

    private int calculatePurchaseAmount() {
        for (Map.Entry<Menu, Integer> entry : orderDetails.entrySet()) {
            Menu menu = entry.getKey();
            Integer menuCount = entry.getValue();
            totalPurchaseAmount += menu
        }
    }
}
