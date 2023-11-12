package christmas.validator;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DomainValidator {
    private static final int STANDARD_PURCHASE_AMOUNT = 10_000;

    private DomainValidator() {
    }

    public static boolean isTotalPurchaseAmountBelowThreshold(int totalPurchaseAmount) {
        return totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT;
    }

    private static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
