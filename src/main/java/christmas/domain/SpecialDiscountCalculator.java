package christmas.domain;

import static christmas.validator.InputValidator.isDayPossible;

import java.util.ArrayList;
import java.util.List;

public class SpecialDiscountCalculator {
    private final List<Integer> DecemberStarDays = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
    private final int SPECIAL_DISCOUNT_AMOUNT = 1_000;


    public int calculateDiscount(int visitDay) {
        isDayPossible(visitDay);
        if (DecemberStarDays.contains(visitDay)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }
}
