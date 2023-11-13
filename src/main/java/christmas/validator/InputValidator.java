package christmas.validator;

import christmas.constant.ErrorMessage;

public class InputValidator {
    private InputValidator() {
    }

    public static void isVisitDayValid(String input) {
        isInputEmpty(input);
        isNumeric(input);
        int visitDay = Integer.parseInt(input);
        isPossibleDay(visitDay);
    }

    public static void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_INPUT_ERROR.getMessage());
        }
    }

    public static void isNumeric(String input) {
        if (!(input.charAt(0) >= '1' && input.charAt(0) <= '9')) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DAY_INPUT.getMessage());
        }
        for (int i = 1; i < input.length(); i++) {
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DAY_INPUT.getMessage());
            }
        }
    }

    public static void isPossibleDay(int visitDay) {
        int FIRST_DAY_OF_DECEMBER = 1;
        int LAST_DAY_OF_DECEMBER = 31;
        if (visitDay < FIRST_DAY_OF_DECEMBER || visitDay > LAST_DAY_OF_DECEMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DAY_INPUT.getMessage());
        }
    }
}
