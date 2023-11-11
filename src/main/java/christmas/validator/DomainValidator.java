package christmas.validator;

public class DomainValidator {
    private static final int STANDARD_PURCHASE_AMOUNT = 10_000;

    private DomainValidator() {
    }

    public static boolean isTotalPurchaseAmountBelowThreshold(int totalPurchaseAmount) {
        if (totalPurchaseAmount < STANDARD_PURCHASE_AMOUNT) {
            return true;
        }
        return false;
    }

}
