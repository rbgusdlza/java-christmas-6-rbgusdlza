package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EventGiverTest {
    private static final int STANDARD_PURCHASE_AMOUNT = 120_000;
    private static final int EVENT_MERCHANDISE_PRICE = 25_000;
    private static final int EVENT_MERCHANDISE_COUNT = 1;

    private EventGiver eventGiver;

    @BeforeEach
    public void setup() {
        eventGiver = new EventGiver();
    }

    @DisplayName("기준 구매 금액을 초과하는 경우 보너스 상품 가격을 반환하는 메서드를 테스트한다.")
    @Test
    public void awardBonusMerchandise_WithTotalPurchaseAmountAboveThreshold_ShouldReturnMerchandisePrice() {
        // when
        int bonusMerchandise = eventGiver.awardBonusMerchandise(STANDARD_PURCHASE_AMOUNT);

        // then
        assertEquals(EVENT_MERCHANDISE_PRICE * EVENT_MERCHANDISE_COUNT, bonusMerchandise);
    }

    @DisplayName("기준 구매 금액 미만인 경우 0을 반환하는 기능을 테스트한다.")
    @ValueSource(ints = {100_000, 50_000, 3_000})
    @ParameterizedTest
    public void awardBonusMerchandise_WithTotalPurchaseAmountBelowThreshold_ShouldReturnZero(int totalPurchaseAmount) {
        // when
        int bonusMerchandise = eventGiver.awardBonusMerchandise(totalPurchaseAmount);

        // then
        assertEquals(0, bonusMerchandise);
    }

    @DisplayName("총구매 금액이 기준 값을 초과하는 경우 보너스 상품이 반환되는 기능을 테스트한다.")
    @Test
    public void getBonusMerchandise_WithTotalPurchaseAmountAboveThreshold_ShouldReturnMapWithMerchandise() {
        // when
        Map<Menu, Integer> bonusMerchandise = eventGiver.getBonusMerchandise(STANDARD_PURCHASE_AMOUNT);

        // then
        assertNotNull(bonusMerchandise);
        assertTrue(bonusMerchandise.containsKey(Menu.CHAMPAGNE));
        assertEquals(EVENT_MERCHANDISE_COUNT, bonusMerchandise.get(Menu.CHAMPAGNE));
    }

    @DisplayName("총구매 금액이 기준 값보다 작을 경우 보너스 상품이 반환되지 않는 기능을 테스트한다.")
    @Test
    public void getBonusMerchandise_WithTotalPurchaseAmountBelowThreshold_ShouldReturnNull() {
        // when
        Map<Menu, Integer> bonusMerchandise = eventGiver.getBonusMerchandise(100_000);

        // then
        assertNull(bonusMerchandise);
    }

    @DisplayName("총혜택 금액이 기준 금액을 초과하는 경우 해당하는 배지를 반환하는 기능을 테스트한다.")
    @Test
    public void awardBadge_ShouldReturnBadgeWithTotalDiscountAmount() {
        // when
        Badge badge = eventGiver.awardBadge(15_000);

        // then
        assertNotNull(badge);
        assertEquals("트리", badge.toString());
    }
}
