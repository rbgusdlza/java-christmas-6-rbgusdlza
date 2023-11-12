package christmas.domain;

import christmas.exception.ErrorMessage;
import christmas.validator.WeekendChecker;

public class WeekendDiscountCalculator {
    private final int WEEKEND_DISCOUNT_AMOUNT = 2_023;

    public WeekendDiscountCalculator() {
    }

    public int calculateWeekendDiscount(int visitDay, int mainCount) {
        isValidCount(mainCount);
        if (!WeekendChecker.isWeekend(visitDay)) {
            return 0;
        }
        return WEEKEND_DISCOUNT_AMOUNT * mainCount;
    }

    private void isValidCount(int mainCount) {
        if (mainCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
