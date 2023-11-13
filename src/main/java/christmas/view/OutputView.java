package christmas.view;

import static christmas.constant.MessageCatalog.GREETING;
import static christmas.constant.MessageCatalog.REQUEST_VISIT_DAY;

public class OutputView {
    private final int EVENT_MONTH = 12;
    private final String LINE_DIVIDER = "\n";

    public OutputView() {
    }

    public void printGreeting() {
        System.out.printf(GREETING + LINE_DIVIDER, EVENT_MONTH);
        System.out.printf(REQUEST_VISIT_DAY + LINE_DIVIDER, EVENT_MONTH);
    }

}
