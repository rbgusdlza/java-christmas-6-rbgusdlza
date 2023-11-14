package christmas.domain;

import static christmas.validator.InputValidator.isDayPossible;

import christmas.validator.WeekendChecker;

public class WeekDiscountCalculator {
    private final int WEEK_DISCOUNT_AMOUNT = 2_023;
    private final String WEEKEND_DISCOUNT_MENU_TYPE = "main";
    private final String WEEKDAY_DISCOUNT_MENU_TYPE = "dessert";

    public int calculateDiscount(int visitDay, OrderManager orderManager) {
        isDayPossible(visitDay);
        if (WeekendChecker.isWeekend(visitDay)) {
            return WEEK_DISCOUNT_AMOUNT * orderManager.countFoodTypes(WEEKEND_DISCOUNT_MENU_TYPE);
        }
        return WEEK_DISCOUNT_AMOUNT * orderManager.countFoodTypes(WEEKDAY_DISCOUNT_MENU_TYPE);
    }
}
