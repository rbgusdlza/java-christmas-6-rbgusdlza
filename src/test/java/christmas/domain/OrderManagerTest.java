package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderManagerTest {
    private static final int NUMBER_OF_T_BONE_STEAK = 2;
    private static final int NUMBER_OF_CAESAR_SALAD = 1;
    private static final int NUMBER_OF_ICE_CREAM = 3;

    private OrderManager orderManager;

    @BeforeEach
    public void setUp() {
        // given
        Map<Menu, Integer> orderDetails = new HashMap<>();
        orderDetails.put(Menu.T_BONE_STEAK, NUMBER_OF_T_BONE_STEAK);
        orderDetails.put(Menu.CAESAR_SALAD, NUMBER_OF_CAESAR_SALAD);
        orderDetails.put(Menu.ICE_CREAM, NUMBER_OF_ICE_CREAM);

        orderManager = new OrderManager(orderDetails);
    }

    @DisplayName("주문 총액이 정확하게 계산되는지 테스트한다.")
    @Test
    public void calculatePurchaseAmount_ShouldReturnCorrectTotalAmount() {
        // when
        int totalAmount = orderManager.calculatePurchaseAmount();

        // then
        assertEquals(Menu.T_BONE_STEAK.getPrice() * NUMBER_OF_T_BONE_STEAK
                + Menu.CAESAR_SALAD.getPrice() * NUMBER_OF_CAESAR_SALAD
                + Menu.ICE_CREAM.getPrice() * NUMBER_OF_ICE_CREAM, totalAmount);
    }

    @DisplayName("특정 음식 유형의 주문 개수가 정확하게 계산되는지 테스트한다.")
    @Test
    public void countFoodTypes_ShouldReturnCorrectCountForMain() {
        // when
        int mainCount = orderManager.countFoodTypes("main");

        // then
        assertEquals(NUMBER_OF_T_BONE_STEAK, mainCount);
    }

    @Test
    public void countFoodTypes_ShouldReturnCorrectCountForDessert() {
        // when
        int dessertCount = orderManager.countFoodTypes("dessert");

        // then
        assertEquals(NUMBER_OF_ICE_CREAM, dessertCount);
    }

    @Test
    public void countFoodTypes_ShouldReturnCorrectCountForDrink() {
        // when
        int appetizerCount = orderManager.countFoodTypes("appetizer");

        // then
        assertEquals(NUMBER_OF_CAESAR_SALAD, appetizerCount);
    }
}
