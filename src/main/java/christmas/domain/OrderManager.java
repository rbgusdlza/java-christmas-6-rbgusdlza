package christmas.domain;

import java.util.Map;

public class OrderManager {
    private final Map<Menu, Integer> orderDetails;

    public OrderManager(Map<Menu, Integer> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int calculatePurchaseAmount() {
        return orderDetails.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int countFoodTypes(String typeName) {
        return orderDetails.entrySet().stream()
                .filter(entry -> typeName.equals(entry.getKey().getType()))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public Map<Menu, Integer> getOrderDetails() {
        return orderDetails;
    }
}
