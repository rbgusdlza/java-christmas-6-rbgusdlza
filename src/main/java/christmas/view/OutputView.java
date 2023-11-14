package christmas.view;

import static christmas.constant.MessageCatalog.BENEFIT_SUMMARY_MESSAGE;
import static christmas.constant.MessageCatalog.ESTIMATED_PAYMENT_AMOUNT_MESSAGE;
import static christmas.constant.MessageCatalog.EVENT_BADGE_MESSAGE;
import static christmas.constant.MessageCatalog.EVENT_BENEFIT_MESSAGE;
import static christmas.constant.MessageCatalog.FREE_MENU_MESSAGE;
import static christmas.constant.MessageCatalog.GREETING;
import static christmas.constant.MessageCatalog.ORDER_MENU_MESSAGE;
import static christmas.constant.MessageCatalog.SPECIAL_BENEFIT_MESSAGE;
import static christmas.constant.MessageCatalog.TOTAL_DISCOUNT_AMOUNT_MESSAGE;
import static christmas.constant.MessageCatalog.TOTAL_PURCHASE_AMOUNT_MESSAGE;
import static christmas.constant.MessageCatalog.BENEFIT_ANNOUNCEMENT;
import static christmas.constant.MessageCatalog.WEEKDAY_BENEFIT_MESSAGE;
import static christmas.constant.MessageCatalog.WEEKEND_BENEFIT_MESSAGE;
import static christmas.constant.MessageCatalog.XMAS_BENEFIT_MESSAGE;
import static christmas.util.ThousandSeparator.addThousandsSeparator;
import static christmas.util.ThousandSeparator.addThousandsSeparatorWithMinus;

import christmas.domain.Menu;
import christmas.validator.WeekendChecker;
import java.util.Map;

public class OutputView {
    private final int EVENT_MONTH = 12;
    private final String LINE_DIVIDER = "\n";
    private final String NO_INPUT = "없음";


    public void printGreeting() {
        System.out.printf(GREETING + LINE_DIVIDER, EVENT_MONTH);
    }

    public void printPreview(int visitDay) {
        System.out.printf(BENEFIT_ANNOUNCEMENT + LINE_DIVIDER, EVENT_MONTH, visitDay);
        System.out.println();
    }

    public void printMenu() {
        System.out.println(ORDER_MENU_MESSAGE);
    }

    public void printTotalPurchaseAmount() {
        System.out.println(TOTAL_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printFreeMenu() {
        System.out.println(FREE_MENU_MESSAGE);
    }

    public void printBenefit() {
        System.out.println(BENEFIT_SUMMARY_MESSAGE);
    }

    public void printTotalDiscountAmount() {
        System.out.println(TOTAL_DISCOUNT_AMOUNT_MESSAGE);
    }

    public void printPaymentAmount() {
        System.out.println(ESTIMATED_PAYMENT_AMOUNT_MESSAGE);
    }

    public void printBadge() {
        System.out.printf(EVENT_BADGE_MESSAGE + LINE_DIVIDER, EVENT_MONTH);
    }

    public void divideLine() {
        System.out.println();
    }

    public void printOrderDetails(Map<Menu, Integer> orderDetails) {
        if (orderDetails == null) {
            System.out.println(NO_INPUT);
            return;
        }
        for (Map.Entry<Menu, Integer> orderEntry : orderDetails.entrySet()) {
            Menu menu = orderEntry.getKey();
            Integer menuCount = orderEntry.getValue();
            System.out.println(menu + " " + menuCount + "개");
        }
    }

    public void printMoney(int money) {
        System.out.println(addThousandsSeparator(money));
    }

    public void printDiscount(int discountAmount) {
        System.out.println(addThousandsSeparatorWithMinus(discountAmount));
    }

    
    public void printXmasDiscount(int discountAmount) {
        if (discountAmount == 0) {
            return;
        }
        System.out.print(XMAS_BENEFIT_MESSAGE);
        printDiscount(discountAmount);
    }

    public void printWeekDiscount(int visitDay, int discountAmount) {
        if (discountAmount == 0) {
            return;
        }
        if (WeekendChecker.isWeekend(visitDay)) {
            System.out.print(WEEKEND_BENEFIT_MESSAGE);
            printDiscount(discountAmount);
            return;
        }
        System.out.print(WEEKDAY_BENEFIT_MESSAGE);
        printDiscount(discountAmount);
    }

    public void printSpecialDiscount(int discountAmount) {
        if (discountAmount == 0) {
            return;
        }
        System.out.print(SPECIAL_BENEFIT_MESSAGE);
        printDiscount(discountAmount);
    }

    public void printEventDiscount(int discountAmount) {
        if (discountAmount == 0) {
            return;
        }
        System.out.print(EVENT_BENEFIT_MESSAGE);
        printDiscount(discountAmount);
    }
}
