package christmas.domain;

import christmas.exception.ErrorMessage;
import christmas.validator.WeekendChecker;

public class WeekendDiscountCalculator {
    private final static int WEEKEND_DISCOUNT_AMOUNT = 2_023;

    private WeekendDiscountCalculator() {
    }

    public static int calculateWeekendDiscount(int visitDay, int mainCount) {
        isValidCount(mainCount);
        if (!WeekendChecker.isWeekend(visitDay)) {
            return 0;
        }
        return WEEKEND_DISCOUNT_AMOUNT * mainCount;
    }

    private static void isValidCount(int mainCount) {
        if (mainCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
