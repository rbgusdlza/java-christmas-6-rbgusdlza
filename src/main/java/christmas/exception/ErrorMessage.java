package christmas.exception;

public enum ErrorMessage {
    INVALID_INPUT("[ERROR] 잘못된 입력입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
