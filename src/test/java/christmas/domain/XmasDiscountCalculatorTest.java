package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class XmasDiscountCalculatorTest {
    private final int STANDARD_DISCOUNT_AMOUNT = 1_000;
    private final int EXTRA_DISCOUNT_AMOUNT = 100;
    private final int VISIT_DAY = 25;
    private final int DAY_OF_OUT_RANGE = 40;

    private XmasDiscountCalculator xmasDiscountCalculator;

    @BeforeEach
    public void setup() {
        // given
        xmasDiscountCalculator = new XmasDiscountCalculator();
    }

    @DisplayName("25일 이전의 방문일 경우, 표준 할인과 추가 할인이 적용되는지 테스트한다.")
    @Test
    public void calculateDiscount_OnDaysBeforeXmas_ShouldReturnCorrectDiscount() {
        // when
        int discountOn10thDay = xmasDiscountCalculator.calculateDiscount(VISIT_DAY);

        // then
        assertEquals(STANDARD_DISCOUNT_AMOUNT + (VISIT_DAY - 1) * EXTRA_DISCOUNT_AMOUNT, discountOn10thDay);
    }

    @DisplayName("25일 이후의 방문일 경우 어떤 할인도 적용되지 않는지 테스트한다.")
    @Test
    public void calculateDiscount_OnDaysAfterXmas_ShouldReturnZero() {
        // when
        int discountOn30thDay = xmasDiscountCalculator.calculateDiscount(30);

        // then
        assertEquals(0, discountOn30thDay);
    }

    @DisplayName("입력 가능한 날짜 범위를 벗어나면 예외를 던져야 한다.")
    @Test
    public void calculateDiscount_OnInvalidDay_ShouldThrowException() {
        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> xmasDiscountCalculator.calculateDiscount(DAY_OF_OUT_RANGE));
    }
}
