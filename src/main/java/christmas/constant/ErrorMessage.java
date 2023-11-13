package christmas.constant;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 입력입니다."),
    NO_INPUT_ERROR("정보를 입력해주세요."),
    INVALID_VISIT_DAY_INPUT("유효하지 않은 날짜입니다. 다시 입력해 주세요.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
