package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import java.util.Map;
import java.util.Objects;

public class InputValidator {
    private static int FIRST_DAY_OF_DECEMBER = 1;
    private static int LAST_DAY_OF_DECEMBER = 31;
    private static int MENU_INFO_LENGTH = 2;
    private static int STANDARD_MENU_COUNT = 20;
    private static String MENU_TYPE = "beverage";

    private InputValidator() {
    }

    public static void isVisitDayValid(String input) {
        isInputEmpty(input);
        isNumeric(input);
        int visitDay = Integer.parseInt(input);
        isDayPossible(visitDay);
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

    public static void isDayPossible(int visitDay) {
        if (visitDay < FIRST_DAY_OF_DECEMBER || visitDay > LAST_DAY_OF_DECEMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DAY_INPUT.getMessage());
        }
    }

    public static void isOrderDetailsValid(String[] subItems) {
        isMenuInfoLengthValid(subItems);
        String menuName = subItems[0];
        String menuCount = subItems[1];
        isMenuNameValid(menuName);
        isMenuCountValid(menuCount);
    }

    public static void isMenuInfoLengthValid(String[] subItems) {
        if (subItems.length != MENU_INFO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }

    public static void isMenuNameValid(String menuName) {
        isInputEmpty(menuName);
        if (Menu.getMenu(menuName) == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }

    public static void isMenuCountValid(String menuCount) {
        isInputEmpty(menuCount);
        isNumeric(menuCount);
    }

    public static void isMenuDuplicate(Map<Menu, Integer> orderDetails, Menu menu) {
        if (orderDetails.containsKey(menu)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }

    public static void checkTypicalMenuOnly(Map<Menu, Integer> orderDetails) {
        boolean hasOtherMenu = false;
        for (Map.Entry<Menu, Integer> orderEntry : orderDetails.entrySet()) {
            Menu menu = orderEntry.getKey();
            if (!Objects.equals(menu.getType(), MENU_TYPE)) {
                hasOtherMenu = true;
                break;
            }
        }
        if (!hasOtherMenu) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }

    public static void isInputFormatValid(String input) {
        int inputLength = input.length();
        if (input.charAt(0) == ',' || input.charAt(inputLength - 1) == ',') {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }

    public static void isExceedingOrderQuantity(Map<Menu, Integer> orderDetails) {
        int totalCount = 0;
        for (Map.Entry<Menu, Integer> orderEntry : orderDetails.entrySet()) {
            Integer menuCount = orderEntry.getValue();
            totalCount += menuCount;
        }
        if (totalCount > STANDARD_MENU_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }
}
