package christmas.domain;

import christmas.exception.ErrorMessage;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendDiscountCalculator {
    private final int WEEKEND_DISCOUNT_AMOUNT = 2_023;

    public WeekendDiscountCalculator() {
    }

    public int calculateWeekendDiscount(LocalDate visitDate, int mainCount) {
        if (mainCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        if (!isWeekend(visitDate)) {
            return 0;
        }
        return WEEKEND_DISCOUNT_AMOUNT * mainCount;
    }

    private boolean isWeekend(LocalDate visitDate) {
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
