package christmas.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountCasher {
    private Map<Menu, Integer> orderDetails = new HashMap<>();

    public void makeOrderDetails(String inputOrders) {
        String[] inputOrder = inputOrders.split(",");
        for (String item : inputOrder) {
            String[] subItems = item.split("-");
            
        }

    }
}
