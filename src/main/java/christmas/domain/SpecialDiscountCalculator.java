package christmas.domain;

import christmas.constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class SpecialDiscountCalculator {
    private final List<Integer> DecemberStarDays = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
    private final int SPECIAL_DISCOUNT_AMOUNT = 1_000;

    public SpecialDiscountCalculator() {
    }

    public int calculateSpecialDiscount(int visitDay) {
        isValidDay(visitDay);
        if (DecemberStarDays.contains(visitDay)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private void isValidDay(int visitDay) {
        int FIRST_DAY_OF_DECEMBER = 1;
        int LAST_DAY_OF_DECEMBER = 31;
        if (visitDay < FIRST_DAY_OF_DECEMBER || visitDay > LAST_DAY_OF_DECEMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
