package christmas.view;

import static christmas.constant.MessageCatalog.BENEFIT_SUMMARY_MESSAGE;
import static christmas.constant.MessageCatalog.ESTIMATED_PAYMENT_AMOUNT_MESSAGE;
import static christmas.constant.MessageCatalog.EVENT_BADGE_MESSAGE;
import static christmas.constant.MessageCatalog.EVENT_BENEFIT_MESSAGE;
import static christmas.constant.MessageCatalog.EVENT_MONTH;
import static christmas.constant.MessageCatalog.FREE_MENU_MESSAGE;
import static christmas.constant.MessageCatalog.GREETING;
import static christmas.constant.MessageCatalog.NO_INPUT;
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

import christmas.domain.Badge;
import christmas.domain.Menu;
import christmas.validator.WeekendChecker;
import java.util.Map;

public class OutputView {
    private boolean checkDiscountAllZero = true;


    public void printGreeting() {
        System.out.printf(GREETING, EVENT_MONTH);
        divideLine();
    }

    public void printPreview(int visitDay) {
        System.out.printf(BENEFIT_ANNOUNCEMENT, EVENT_MONTH, visitDay);
        divideLine();
        divideLine();
    }

    public void printMenuNotice() {
        System.out.println(ORDER_MENU_MESSAGE);
    }

    public void printTotalPurchaseNotice() {
        System.out.println(TOTAL_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printFreeMenuNotice() {
        System.out.println(FREE_MENU_MESSAGE);
    }

    public void printBenefitNotice() {
        System.out.println(BENEFIT_SUMMARY_MESSAGE);
    }

    public void printTotalDiscountNotice() {
        System.out.println(TOTAL_DISCOUNT_AMOUNT_MESSAGE);
    }

    public void printPaymentNotice() {
        System.out.println(ESTIMATED_PAYMENT_AMOUNT_MESSAGE);
    }

    public void printBadgeNotice() {
        System.out.printf(EVENT_BADGE_MESSAGE, EVENT_MONTH);
        divideLine();
    }

    public void divideLine() {
        System.out.println();
    }

    public void printOrderDetails(Map<Menu, Integer> orderDetails) {
        if (orderDetails == null || orderDetails.isEmpty()) {
            System.out.println(NO_INPUT);
            return;
        }

        orderDetails.forEach((menu, count) ->
                System.out.printf("%s %d개%n", menu, count)
        );
    }

    public void printMoney(int money) {
        System.out.println(addThousandsSeparator(money));
    }

    public void printDiscount(int discountAmount) {
        System.out.println(addThousandsSeparatorWithMinus(discountAmount));
    }

    private void printBenefit(String message, int discountAmount) {
        if (discountAmount != 0) {
            checkDiscountAllZero = false;
            System.out.print(message);
            printDiscount(discountAmount);
        }
    }

    public void printDiscountEmpty() {
        if (checkDiscountAllZero) {
            System.out.println(NO_INPUT);
        }
    }


    public void printXmasDiscount(int discountAmount) {
        printBenefit(XMAS_BENEFIT_MESSAGE, discountAmount);
    }

    public void printWeekDiscount(int visitDay, int discountAmount) {
        if (WeekendChecker.isWeekend(visitDay)) {
            printBenefit(WEEKEND_BENEFIT_MESSAGE, discountAmount);
        }
        if (!WeekendChecker.isWeekend(visitDay)) {
            printBenefit(WEEKDAY_BENEFIT_MESSAGE, discountAmount);
        }
    }

    public void printSpecialDiscount(int discountAmount) {
        printBenefit(SPECIAL_BENEFIT_MESSAGE, discountAmount);
    }

    public void printEventDiscount(int discountAmount) {
        printBenefit(EVENT_BENEFIT_MESSAGE, discountAmount);
    }

    public void printEventBadge(Badge badge) {
        if (badge == null) {
            System.out.println(NO_INPUT);
        }
        System.out.println(badge);
    }
}
