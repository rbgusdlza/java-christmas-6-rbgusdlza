package christmas.constant;

public enum ErrorMessage {
    NO_INPUT_ERROR("정보를 입력해주세요."),
    INVALID_VISIT_DAY_INPUT("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER_DETAILS_INPUT("유효하지 않은 주문입니다. 다시 입력해 주세요.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
