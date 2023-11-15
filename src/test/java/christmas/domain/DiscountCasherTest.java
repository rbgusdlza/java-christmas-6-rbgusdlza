package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountCasherTest {
    private static final int NUMBER_OF_MAIN = 2;
    private static final int NUMBER_OF_APPETIZER = 1;
    private static final int NUMBER_OF_DESSERT = 3;
    private static final int VISIT_DAY = 25;
    private static final int STANDARD_DISCOUNT_AMOUNT = 1_000;
    private static final int EXTRA_DISCOUNT_AMOUNT = 100;
    private static final int WEEK_DISCOUNT_AMOUNT = 2_023;
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1_000;
    private static final Menu EVENT_MERCHANDISE = Menu.CHAMPAGNE;
    private static final int EVENT_MERCHANDISE_COUNT = 1;
    private static final String THIRD_THRESHOLD_MERCHANDISE = "산타";

    private DiscountCasher discountCasher;
    private OrderManager orderManager;

    @BeforeEach
    public void setUp() {
        // given
        Map<Menu, Integer> orderDetails = new HashMap<>();
        orderDetails.put(Menu.T_BONE_STEAK, NUMBER_OF_MAIN);
        orderDetails.put(Menu.CAESAR_SALAD, NUMBER_OF_APPETIZER);
        orderDetails.put(Menu.ICE_CREAM, NUMBER_OF_DESSERT);

        orderManager = new OrderManager(orderDetails);
        discountCasher = new DiscountCasher(VISIT_DAY, orderManager.calculatePurchaseAmount());
    }

    @DisplayName("크리스마스 할인이 올바르게 계산되는지 테스트한다.")
    @Test
    public void calculateXmasDiscount_ShouldReturnCorrectXmasDiscount() {
        // when
        int xmasDiscount = discountCasher.calculateXmasDiscount();

        // then
        assertEquals(STANDARD_DISCOUNT_AMOUNT + (VISIT_DAY - 1) * EXTRA_DISCOUNT_AMOUNT, xmasDiscount);
    }

    @DisplayName("평일 할인이 올바르게 계산되는지 테스트한다.")
    @Test
    public void calculateWeekDiscount_ShouldReturnCorrectWeekDiscount() {
        // when
        int weekDiscount = discountCasher.calculateWeekDiscount(orderManager);

        // then
        assertEquals(WEEK_DISCOUNT_AMOUNT * NUMBER_OF_DESSERT, weekDiscount);
    }

    @DisplayName("특별 할인이 올바르게 계산되는지 테스트한다.")
    @Test
    public void calculateSpecialDiscount_ShouldReturnCorrectSpecialDiscount() {
        // when
        int specialDiscount = discountCasher.calculateSpecialDiscount();

        // then
        assertEquals(SPECIAL_DISCOUNT_AMOUNT, specialDiscount);
    }

    @DisplayName("이벤트 할인이 올바르게 계산되는지 테스트한다.")
    @Test
    public void calculateEventDiscount_ShouldReturnCorrectEventDiscount() {
        // given
        int eventMerchandisePrice = EVENT_MERCHANDISE.getPrice() * EVENT_MERCHANDISE_COUNT;

        // when
        int eventDiscount = discountCasher.calculateEventDiscount();

        // then
        assertEquals(eventMerchandisePrice, eventDiscount);
    }

    @DisplayName("이벤트 상품이 올바르게 반환되는지 테스트한다.")
    @Test
    public void getEventMerchandise_ShouldReturnCorrectEventMerchandise() {
        // when
        Map<Menu, Integer> eventMerchandise = discountCasher.getEventMerchandise();

        // then
        assertEquals(EVENT_MERCHANDISE_COUNT, eventMerchandise.size());
        assertEquals(EVENT_MERCHANDISE_COUNT, eventMerchandise.get(Menu.CHAMPAGNE));
    }

    @DisplayName("이벤트 배지가 올바르게 반환되는지 테스트한다.")
    @Test
    public void getEventBadge_ShouldReturnCorrectEventBadge() {
        // when
        Badge eventBadge = discountCasher.getEventBadge(orderManager);

        // then
        assertEquals(THIRD_THRESHOLD_MERCHANDISE, eventBadge.toString());
    }

    @DisplayName("총구매 금액이 올바르게 반환되는지 테스트한다.")
    @Test
    public void getTotalPurchaseAmount_ShouldReturnCorrectTotalPurchaseAmount() {
        // given
        int expectedTotalPurchase = Menu.T_BONE_STEAK.getPrice() * NUMBER_OF_MAIN
                + Menu.CAESAR_SALAD.getPrice() * NUMBER_OF_APPETIZER
                + Menu.ICE_CREAM.getPrice() * NUMBER_OF_DESSERT;

        // when
        int totalPurchaseAmount = discountCasher.getTotalPurchaseAmount();

        // then
        assertEquals(expectedTotalPurchase, totalPurchaseAmount);
    }

    @DisplayName("총할인 금액이 올바르게 계산되는지 테스트")
    @Test
    public void getTotalDiscountAmount_ShouldReturnCorrectTotalDiscountAmount() {
        // given
        int expectedTotalDiscount = STANDARD_DISCOUNT_AMOUNT + (VISIT_DAY - 1) * EXTRA_DISCOUNT_AMOUNT
                + WEEK_DISCOUNT_AMOUNT * NUMBER_OF_DESSERT + SPECIAL_DISCOUNT_AMOUNT
                + EVENT_MERCHANDISE.getPrice() * EVENT_MERCHANDISE_COUNT;

        // when
        int totalDiscountAmount = discountCasher.getTotalDiscountAmount(orderManager);

        // then
        assertEquals(expectedTotalDiscount, totalDiscountAmount);
    }

    @DisplayName("총예상 구매 금액이 올바르게 계산되는지 테스트")
    @Test
    public void calculateEstimatePurchaseAmount_ShouldReturnCorrectEstimatePurchaseAmount() {
        // given
        int expectedTotalDiscount = STANDARD_DISCOUNT_AMOUNT + (VISIT_DAY - 1) * EXTRA_DISCOUNT_AMOUNT
                + WEEK_DISCOUNT_AMOUNT * NUMBER_OF_DESSERT + SPECIAL_DISCOUNT_AMOUNT
                + EVENT_MERCHANDISE.getPrice() * EVENT_MERCHANDISE_COUNT;
        int expectedTotalPurchase = Menu.T_BONE_STEAK.getPrice() * NUMBER_OF_MAIN
                + Menu.CAESAR_SALAD.getPrice() * NUMBER_OF_APPETIZER
                + Menu.ICE_CREAM.getPrice() * NUMBER_OF_DESSERT;
        int expectedEventDiscount = EVENT_MERCHANDISE.getPrice() * EVENT_MERCHANDISE_COUNT;

        // when
        int estimatePurchaseAmount = discountCasher.calculateEstimatePurchaseAmount(orderManager);

        // then
        assertEquals(expectedTotalPurchase - expectedTotalDiscount + expectedEventDiscount, estimatePurchaseAmount);
    }
}
