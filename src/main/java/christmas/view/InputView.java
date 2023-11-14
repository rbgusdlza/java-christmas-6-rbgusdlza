package christmas.view;

import static christmas.constant.MessageCatalog.REQUEST_ORDER;
import static christmas.constant.MessageCatalog.REQUEST_VISIT_DAY;
import static christmas.constant.MessageCatalog.EVENT_MONTH;
import static christmas.validator.InputValidator.checkTypicalMenuOnly;
import static christmas.validator.InputValidator.isExceedingOrderQuantity;
import static christmas.validator.InputValidator.isInputFormatValid;
import static christmas.validator.InputValidator.isMenuDuplicate;
import static christmas.validator.InputValidator.isOrderDetailsValid;
import static christmas.validator.InputValidator.isVisitDayValid;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    public int readVisitDay() {
        System.out.printf(REQUEST_VISIT_DAY, EVENT_MONTH);
        divideLine();
        String input = Console.readLine();
        try {
            return parseVisitDay(input);
        } catch (Exception error) {
            handleInputError(error);
            return readVisitDay();
        }
    }

    private int parseVisitDay(String input) {
        isVisitDayValid(input);
        return Integer.parseInt(input);
    }

    private void handleInputError(Exception error) {
        System.out.println(error.getMessage());
    }

    public Map<Menu, Integer> readOrderDetails() {
        System.out.println(REQUEST_ORDER);
        String input = Console.readLine();
        try {
            return processOrderInput(input);
        } catch (Exception error) {
            handleInputError(error);
            return readOrderDetails();
        }
    }

    public Map<Menu, Integer> processOrderInput(String input) {
        Map<Menu, Integer> orderDetails = new HashMap<>();
        isInputFormatValid(input);

        String[] items = input.split(",");
        for (String item : items) {
            String[] subItems = item.split("-");
            processOrderItem(orderDetails, subItems);
        }

        checkTypicalMenuOnly(orderDetails);
        isExceedingOrderQuantity(orderDetails);
        return orderDetails;
    }

    private void processOrderItem(Map<Menu, Integer> orderDetails, String[] subItems) {
        isOrderDetailsValid(subItems);

        String menuName = subItems[0];
        int menuCount = Integer.parseInt(subItems[1]);
        Menu menu = Menu.getMenu(menuName);

        makeOrderDetails(orderDetails, menu, menuCount);
    }

    public void makeOrderDetails(Map<Menu, Integer> orderDetails, Menu menu, int menuCount) {
        isMenuDuplicate(orderDetails, menu);
        orderDetails.put(menu, menuCount);
    }

    public void divideLine() {
        System.out.println();
    }
}
