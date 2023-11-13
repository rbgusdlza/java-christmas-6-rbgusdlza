package christmas.domain;

import christmas.constant.ErrorMessage;
import christmas.validator.WeekendChecker;

public class WeekdayDiscountCalculator {
    private final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;


    public int calculateWeekdayDiscount(int visitDay, int desertCount) {
        isValidCount(desertCount);
        if (!WeekendChecker.isWeekend(visitDay)) {
            return 0;
        }
        return WEEKDAY_DISCOUNT_AMOUNT * desertCount;
    }

    private void isValidCount(int desertCount) {
        if (desertCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
