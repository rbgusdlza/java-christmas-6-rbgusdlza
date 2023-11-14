package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import java.util.Map;
import java.util.Objects;

public class InputValidator {
    private static int FIRST_DAY_OF_DECEMBER = 1;
    private static int LAST_DAY_OF_DECEMBER = 31;

    private InputValidator() {
    }

    public static void isVisitDayValid(String input) {
        isInputEmpty(input);
        isNumericDay(input);
        int visitDay = Integer.parseInt(input);
        isDayPossible(visitDay);
    }

    public static void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_INPUT_ERROR.getMessage());
        }
    }

    public static void isNumericDay(String input) {
        if (!(input.charAt(0) >= '1' && input.charAt(0) <= '9')) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DAY_INPUT.getMessage());
        }
        for (int i = 1; i < input.length(); i++) {
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DAY_INPUT.getMessage());
            }
        }
    }

    public static void isDayPossible(int visitDay) {
        if (visitDay < FIRST_DAY_OF_DECEMBER || visitDay > LAST_DAY_OF_DECEMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DAY_INPUT.getMessage());
        }
    }

    public static void isInputFormatValid(String input) {
        int inputLength = input.length();
        if (inputLength > 0 && (input.charAt(0) == ',' || input.charAt(inputLength - 1) == ',')) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }
}
