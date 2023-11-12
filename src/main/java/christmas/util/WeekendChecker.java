package christmas.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendChecker {
    private static final int EVENT_YEAR = 2023;
    private static final int EVENT_MONTH = 12;

    private WeekendChecker() {
    }

    public static boolean isWeekend(int visitDay) {
        LocalDate visitDate = LocalDate.of(EVENT_YEAR, EVENT_MONTH, visitDay);
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
