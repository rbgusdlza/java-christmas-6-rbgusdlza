package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import java.util.Map;
import java.util.Objects;

public class MenuValidator {
    private static int MENU_INFO_SIZE = 2;
    private static int STANDARD_MENU_COUNT = 20;
    private static String MENU_TYPE = "beverage";

    private MenuValidator() {
    }

    public static void isOrderDetailsValid(String[] subItems) {
        isMenuInfoLengthValid(subItems);
        String menuName = subItems[0];
        String menuCount = subItems[1];
        isMenuNameValid(menuName);
        isMenuCountValid(menuCount);
    }

    public static void isMenuInfoLengthValid(String[] subItems) {
        if (subItems.length != MENU_INFO_SIZE) {
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
        isNumericCount(menuCount);
    }

    public static void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_INPUT_ERROR.getMessage());
        }
    }

    public static void isNumericCount(String input) {
        if (!(input.charAt(0) >= '1' && input.charAt(0) <= '9')) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
        for (int i = 1; i < input.length(); i++) {
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
            }
        }
    }

    public static void isMenuDuplicate(Map<Menu, Integer> orderDetails, Menu menu) {
        if (orderDetails.containsKey(menu)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }

    public static void checkTypicalMenuOnly(Map<Menu, Integer> orderDetails) {
        boolean hasOtherMenu = orderDetails.keySet().stream()
                .anyMatch(menu -> !Objects.equals(menu.getType(), MENU_TYPE));
        if (!hasOtherMenu) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }

    public static void isExceedingOrderQuantity(Map<Menu, Integer> orderDetails) {
        int totalCount = orderDetails.values().stream().mapToInt(Integer::intValue).sum();
        if (totalCount > STANDARD_MENU_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER_DETAILS_INPUT.getMessage());
        }
    }
}
