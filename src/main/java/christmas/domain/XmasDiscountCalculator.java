package christmas.domain;

import static christmas.validator.InputValidator.isDayPossible;

public class XmasDiscountCalculator {
    private final int STANDARD_DISCOUNT_AMOUNT = 1_000;
    private final int XMAS_DAY = 25;


    public int calculateDiscount(int visitDay) {
        isDayPossible(visitDay);
        if (visitDay > XMAS_DAY) {
            return 0;
        }
        int xmasDday = XMAS_DAY - visitDay;
        return STANDARD_DISCOUNT_AMOUNT + xmasDday * 100;
    }
}
