package christmas.view;

import static christmas.constant.MessageCatalog.REQUEST_ORDER;
import static christmas.constant.MessageCatalog.REQUEST_VISIT_DAY;
import static christmas.constant.MessageCatalog.LINE_DIVIDER;
import static christmas.constant.MessageCatalog.EVENT_MONTH;
import static christmas.validator.InputValidator.checkTypicalMenuOnly;
import static christmas.validator.InputValidator.isMenuDuplicate;
import static christmas.validator.InputValidator.isOrderDetailsValid;
import static christmas.validator.InputValidator.isVisitDayValid;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.domain.OrderManager;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    private int visitDay;
    private Map<Menu, Integer> orderDetails;

    public int readVisitDay() {
        try {
            System.out.printf(REQUEST_VISIT_DAY + LINE_DIVIDER, EVENT_MONTH);
            String input = Console.readLine();
            isVisitDayValid(input);
            return Integer.parseInt(input);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return readVisitDay();
        }
    }

    public OrderManager readOrderDetails() {
        try {
            System.out.println(REQUEST_ORDER);
            String input = Console.readLine();
            return new OrderManager(processOrderInput(input));
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return readOrderDetails();
        }
    }

    public Map<Menu, Integer> processOrderInput(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String[] subItems = item.split("-");
            isOrderDetailsValid(subItems);
            String menuName = subItems[0];
            int menuCount = Integer.parseInt(subItems[1]);
            Menu menu = Menu.getMenu(menuName);
            makeOrderDetails(menu, menuCount);
        }
        checkTypicalMenuOnly(orderDetails);
        return orderDetails;
    }

    public void makeOrderDetails(Menu menu, int menuCount) {
        isMenuDuplicate(orderDetails, menu);
        orderDetails.put(menu, menuCount);
    }
}
