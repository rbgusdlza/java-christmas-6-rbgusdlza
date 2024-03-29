package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeTest {
    @DisplayName("첫번째 기준 금액보다 작은 경우 어떤 배지를 받을지 테스트한다.")
    @Test
    public void badgeCreationNoMerchandise() {
        Badge badge = new Badge(0);
        assertEquals("없음", badge.toString());
    }

    @DisplayName("두번째 기준 금액보다 작은 경우 어떤 배지를 받을지 테스트한다.")
    @Test
    public void badgeCreationSecondThresholdMerchandise() {
        Badge badge = new Badge(8_000);
        assertEquals("별", badge.toString());
    }

    @DisplayName("세번째 기준 금액보다 작은 경우 어떤 배지를 받을지 테스트한다.")
    @Test
    public void badgeCreationThirdThresholdMerchandise() {
        Badge badge = new Badge(15_000);
        assertEquals("트리", badge.toString());
    }

    @DisplayName("세번째 기준 금액보다 높은 경우 어떤 배지를 받을지 테스트한다.")
    @Test
    public void badgeCreationFourthThresholdMerchandise() {
        Badge badge = new Badge(25_000);
        assertEquals("산타", badge.toString());
    }
}
