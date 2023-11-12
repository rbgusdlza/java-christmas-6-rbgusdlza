package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class DiscountCasher {
    private Map<Menu, Integer> orderDetails = new HashMap<>();
    private final int totalPurchaseAmount;

    DiscountCasher(Map<Menu, Integer> orderDetails) {
        this.orderDetails = orderDetails;
        totalPurchaseAmount = calculatePurchaseAmount(orderDetails);
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

    

}
