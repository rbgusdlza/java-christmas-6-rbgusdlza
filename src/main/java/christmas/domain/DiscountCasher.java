package christmas.domain;

public class DiscountCasher {
    private final static int STANDARD_PURCHASE_AMOUNT = 10_000;
    private int totalDiscountAmount;

    DiscountCasher() {
    }

    public boolean isDiscountPossible() {
        if (totalDiscountAmount >= STANDARD_PURCHASE_AMOUNT) {
            return true;
        }
        return false;
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    private void addDiscountAmount(int discountAmount) {
        totalDiscountAmount += discountAmount;
    }
}
