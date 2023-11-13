package christmas.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderManager {
    private Map<Menu, Integer> orderDetails;

    public OrderManager(Map<Menu, Integer> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int calculatePurchaseAmount(Map<Menu, Integer> orderDetails) {
        int totalPurchaseAmount = 0;
        for (Map.Entry<Menu, Integer> orderEntry : orderDetails.entrySet()) {
            Menu menu = orderEntry.getKey();
            Integer menuCount = orderEntry.getValue();
            int menuPrice = menu.getPrice();
            totalPurchaseAmount += menuPrice * menuCount;
        }
        return totalPurchaseAmount;
    }

    public int countFoodTypes(Map<Menu, Integer> orderDetails, String typeName) {
        int typeCount = 0;
        for (Map.Entry<Menu, Integer> orderEntry : orderDetails.entrySet()) {
            Menu menu = orderEntry.getKey();
            Integer menuCount = orderEntry.getValue();
            if (Objects.equals(menu.getType(), typeName)) {
                typeCount += menuCount;
            }
        }
        return typeCount;
    }
}
