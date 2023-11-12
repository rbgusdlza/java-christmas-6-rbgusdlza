package christmas.domain;

import christmas.validator.DomainValidator;
import java.util.ArrayList;
import java.util.List;

public class SpecialDiscountCalculator {
    private final List<Integer> DecemberStarDays = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
    private final int SPECIAL_DISCOUNT_AMOUNT = 1_000;

    public SpecialDiscountCalculator() {
    }

    public int calculateSpecialDiscount(int totalPurchaseAmount, int day) {
        if (DomainValidator.isTotalPurchaseAmountBelowThreshold(totalPurchaseAmount)) {
            return 0;
        }
        if (DecemberStarDays.contains(day)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }
}
