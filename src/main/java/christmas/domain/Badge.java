package christmas.domain;

public class Badge {
    private static final int FIRST_AMOUNT_THRESHOLD = 5_000;
    private static final int SECOND_AMOUNT_THRESHOLD = 10_000;
    private static final int THIRD_AMOUNT_THRESHOLD = 20_000;
    private static final String FIRST_THRESHOLD_MERCHANDISE = "별";
    private static final String SECOND_THRESHOLD_MERCHANDISE = "트리";
    private static final String THIRD_THRESHOLD_MERCHANDISE = "산타";
    private static final String NO_MERCHANDISE = "없음";

    private final int discount_amount;
    private final String event_merchandise;

    public Badge(int discount_amount) {
        this.discount_amount = discount_amount;
        event_merchandise = setEventMerchandise();
    }

    private String setEventMerchandise() {
        if (discount_amount >= THIRD_AMOUNT_THRESHOLD) {
            return THIRD_THRESHOLD_MERCHANDISE;
        }
        if (discount_amount >= SECOND_AMOUNT_THRESHOLD) {
            return SECOND_THRESHOLD_MERCHANDISE;
        }
        if (discount_amount >= FIRST_AMOUNT_THRESHOLD) {
            return FIRST_THRESHOLD_MERCHANDISE;
        }
        return NO_MERCHANDISE;
    }

    @Override
    public String toString() {
        return event_merchandise;
    }
}
