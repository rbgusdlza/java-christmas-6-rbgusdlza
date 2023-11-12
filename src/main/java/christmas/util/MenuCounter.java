package christmas.util;

import christmas.domain.Menu;
import java.util.Map;
import java.util.Objects;

public class MenuCounter {
    private MenuCounter() {
    }

    public static int countFoodTypes(Map<Menu, Integer> orderDetails, String typeName) {
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
