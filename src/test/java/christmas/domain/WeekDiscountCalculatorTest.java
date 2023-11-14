package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekDiscountCalculatorTest {
    private static final int WEEK_DISCOUNT_AMOUNT = 2_023;
    private static final int NUMBER_OF_FOOD = 3;
    private static final int WEEKEND = 9;
    private static final int WEEKDAY = 5;
    private static final int DAY_OUT_OF_RANGE = 40;

    private WeekDiscountCalculator weekDiscountCalculator;
    private OrderManager orderManager;

    @BeforeEach
    public void setup() {
        // given
        Map<Menu, Integer> orderDetails = new HashMap<>();
        orderDetails.put(Menu.BARBECUE_RIBS, NUMBER_OF_FOOD);
        orderDetails.put(Menu.CAESAR_SALAD, NUMBER_OF_FOOD);
        orderDetails.put(Menu.CHOCOLATE_CAKE, NUMBER_OF_FOOD);

        weekDiscountCalculator = new WeekDiscountCalculator();
        orderManager = new OrderManager(orderDetails);
    }

    @DisplayName("주말에 'main' 메뉴에 대한 할인을 계산하는 기능을 테스트한다.")
    @Test
    public void calculateDiscount_OnWeekend_ShouldReturnCorrectDiscountForMain() {
        // when
        int discount = weekDiscountCalculator.calculateDiscount(WEEKEND, orderManager);

        // then
        assertEquals(WEEK_DISCOUNT_AMOUNT * NUMBER_OF_FOOD, discount);
    }

    @DisplayName("평일에 'desert' 메뉴에 대한 할인을 계산하는 기능을 테스트한다.")
    @Test
    public void calculateDiscount_OnWeekday_ShouldReturnCorrectDiscountForDesert() {
        // when
        int discount = weekDiscountCalculator.calculateDiscount(WEEKDAY, orderManager);

        // then
        assertEquals(WEEK_DISCOUNT_AMOUNT * NUMBER_OF_FOOD, discount);
    }

    @DisplayName("입력 가능한 날짜 범위를 벗어나면 예외를 던져야 한다.")
    @Test
    public void calculateDiscount_OnInvalidDay_ShouldThrowException() {
        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> weekDiscountCalculator.calculateDiscount(DAY_OUT_OF_RANGE, orderManager));
    }
}
