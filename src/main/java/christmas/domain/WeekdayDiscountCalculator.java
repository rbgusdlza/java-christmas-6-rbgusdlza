package christmas.domain;

import christmas.exception.ErrorMessage;
import christmas.validator.DomainValidator;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscountCalculator {
    private final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;

    public WeekdayDiscountCalculator() {
    }

    public int calculateWeekdayDiscount(int totalPurchaseAmount, int desertCount) {
        if (DomainValidator.isTotalPurchaseAmountBelowThreshold(totalPurchaseAmount)) {
            return 0;
        }
        if (desertCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        return WEEKDAY_DISCOUNT_AMOUNT * desertCount;
    }
}
