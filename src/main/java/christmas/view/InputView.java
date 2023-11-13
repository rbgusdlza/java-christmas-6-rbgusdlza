package christmas.view;

import static christmas.constant.MessageCatalog.REQUEST_VISIT_DAY;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.OrderManager;

public class InputView {
    private final int EVENT_MONTH = 12;
    private final String LINE_DIVIDER = "\n";
    private int visitDay;
    private OrderManager orderManager;

    public int readVisitDay() {
        System.out.printf(REQUEST_VISIT_DAY + LINE_DIVIDER, EVENT_MONTH);
        String input = Console.readLine();

    }
}
