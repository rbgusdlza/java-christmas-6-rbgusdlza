package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialDiscountCalculatorTest {
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1_000;
    private static final int SPECIAL_DAY = 25;
    private static final int NOT_SPECIAL_DAY = 20;
    private static final int DAY_OUT_OF_RANGE = 40;

    private SpecialDiscountCalculator specialDiscountCalculator;

    @BeforeEach
    public void setup() {
        specialDiscountCalculator = new SpecialDiscountCalculator();
    }

    @DisplayName("12월의 특별 할인 날짜에 대해 할인 금액을 올바르게 계산하는지 테스트한다.")
    @Test
    public void calculateDiscount_OnDecemberStarDays_ShouldReturnSpecialDiscountAmount() {
        // when
        int discount = specialDiscountCalculator.calculateDiscount(SPECIAL_DAY);

        // then
        assertEquals(SPECIAL_DISCOUNT_AMOUNT, discount);
    }

    @DisplayName("12월의 특별 할인 날짜가 아닌 경우 할인이 적용되지 않는지 테스트한다.")
    @Test
    public void calculateDiscount_OnNonDecemberStarDay_ShouldReturnZero() {
        // when
        int discount = specialDiscountCalculator.calculateDiscount(NOT_SPECIAL_DAY);

        // then
        assertEquals(0, discount);
    }

    @DisplayName("입력 가능한 날짜 범위를 벗어나면 예외를 던져야 함")
    @Test
    public void calculateDiscount_OnInvalidDay_ShouldThrowException() {
        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> specialDiscountCalculator.calculateDiscount(DAY_OUT_OF_RANGE));
    }
}
