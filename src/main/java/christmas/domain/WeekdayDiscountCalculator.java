package christmas.domain;

import christmas.exception.ErrorMessage;
import christmas.validator.WeekendChecker;

public class WeekdayDiscountCalculator {
    private static final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;

    private WeekdayDiscountCalculator() {
    }

    public static int calculateWeekdayDiscount(int visitDay, int desertCount) {
        isValidCount(desertCount);
        if (!WeekendChecker.isWeekend(visitDay)) {
            return 0;
        }
        return WEEKDAY_DISCOUNT_AMOUNT * desertCount;
    }

    private static void isValidCount(int desertCount) {
        if (desertCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
