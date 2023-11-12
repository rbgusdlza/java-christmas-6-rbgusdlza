package christmas.domain;

import christmas.exception.ErrorMessage;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscountCalculator {
    private final int WEEKDAY_DISCOUNT_AMOUNT = 2_023;

    public WeekdayDiscountCalculator() {
    }

    public int calculateWeekdayDiscount(LocalDate visitDate, int desertCount) {
        if (desertCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        if (isWeekend(visitDate)) {
            return 0;
        }
        return WEEKDAY_DISCOUNT_AMOUNT * desertCount;
    }

    private boolean isWeekend(LocalDate visitDate) {
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
