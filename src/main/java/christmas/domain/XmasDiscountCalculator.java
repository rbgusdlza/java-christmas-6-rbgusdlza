package christmas.domain;

import christmas.exception.ErrorMessage;

public class XmasDiscountCalculator {
    private final static int STANDARD_DISCOUNT_AMOUNT = 1_000;
    private final static int XMAS_DAY = 25;

    private XmasDiscountCalculator() {
    }

    public static int calculateXmasDiscount(int visitDay) {
        isValidDay(visitDay);
        if (visitDay > XMAS_DAY) {
            return 0;
        }
        int xmasDday = XMAS_DAY - visitDay;
        return STANDARD_DISCOUNT_AMOUNT + xmasDday * 100;
    }

    private static void isValidDay(int visitDay) {
        int FIRST_DAY_OF_DECEMBER = 1;
        int LAST_DAY_OF_DECEMBER = 31;
        if (visitDay < FIRST_DAY_OF_DECEMBER || visitDay > LAST_DAY_OF_DECEMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
