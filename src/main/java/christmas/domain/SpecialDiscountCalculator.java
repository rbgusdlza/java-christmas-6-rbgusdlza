package christmas.domain;

import christmas.exception.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class SpecialDiscountCalculator {
    private final List<Integer> DecemberStarDays = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
    private final int SPECIAL_DISCOUNT_AMOUNT = 1_000;

    public SpecialDiscountCalculator() {
    }

    public int calculateSpecialDiscount(int day) {
        if (day <= 0 || day > 31) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        if (DecemberStarDays.contains(day)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }
}
