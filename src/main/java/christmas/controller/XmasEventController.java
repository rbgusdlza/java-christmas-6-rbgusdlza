package christmas.controller;

import christmas.domain.DiscountCasher;
import christmas.domain.OrderManager;
import christmas.view.InputView;
import christmas.view.OutputView;

public class XmasEventController {
    private final InputView inputView;
    private final OutputView outputView;
    private DiscountCasher discountCasher;
    private OrderManager orderManager;

    public XmasEventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        getDateAndOrder();
        printOrderDetails();
        printEventResult();
    }

    public void getDateAndOrder() {
        outputView.printGreeting();
        int visitDay = inputView.readVisitDay();
        orderManager = new OrderManager(inputView.readOrderDetails());
        discountCasher = new DiscountCasher(visitDay, orderManager.calculatePurchaseAmount());
        outputView.printPreview(visitDay);
    }

    public void printOrderDetails() {
        outputView.printMenuNotice();
        outputView.printOrderDetails(orderManager.getOrderDetails());
        outputView.divideLine();
    }

    public void printEventResult() {
        printTotalPurchaseAmount();
        printEachDiscountAmount();
        printTotalDiscountAmount();
        printEstimatePurchaseAmount();
        printEventBadge();
    }

    public void printTotalPurchaseAmount() {
        outputView.printTotalPurchaseNotice();
        outputView.printMoney(discountCasher.getTotalPurchaseAmount());
        outputView.divideLine();

        outputView.printFreeMenuNotice();
        outputView.printOrderDetails(discountCasher.getEventMerchandise());
        outputView.divideLine();
    }

    public void printEachDiscountAmount() {
        outputView.printBenefitNotice();
        outputView.printXmasDiscount(discountCasher.calculateXmasDiscount());
        outputView.printWeekDiscount(discountCasher.getVisitDay(), discountCasher.calculateWeekDiscount(orderManager));
        outputView.printSpecialDiscount(discountCasher.calculateSpecialDiscount());
        outputView.printEventDiscount(discountCasher.calculateEventDiscount());
        outputView.printDiscountEmpty();
        outputView.divideLine();
    }

    public void printTotalDiscountAmount() {
        outputView.printTotalDiscountNotice();
        outputView.printDiscount(discountCasher.getTotalDiscountAmount(orderManager));
        outputView.divideLine();
    }

    public void printEstimatePurchaseAmount() {
        outputView.printPaymentNotice();
        outputView.printMoney(discountCasher.calculateEstimatePurchaseAmount(orderManager));
        outputView.divideLine();
    }

    public void printEventBadge() {
        outputView.printBadgeNotice();
        outputView.printEventBadge(discountCasher.getEventBadge(orderManager));
    }
}
