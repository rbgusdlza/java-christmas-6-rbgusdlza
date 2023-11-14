package christmas.controller;

import christmas.domain.DiscountCasher;
import christmas.domain.OrderManager;
import java.util.Map;
import christmas.domain.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

public class XmasEventController {
    private final InputView inputView;
    private final OutputView outputView;
    private DiscountCasher discountCasher;
    private OrderManager orderManager;
    private Map<Menu, Integer> orderDetails;
    private int visitDay;

    public XmasEventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        getDateAndOrder();
        printOrderDetails();
        printTotalPurchaseAmount();
        printTotalDiscountAmount();
    }

    public void getDateAndOrder() {
        outputView.printGreeting();
        visitDay = inputView.readVisitDay();
        orderDetails = inputView.readOrderDetails();
        orderManager = new OrderManager(orderDetails);
        discountCasher = new DiscountCasher(visitDay, orderManager.calculatePurchaseAmount());
        outputView.printPreview(visitDay);
    }

    public void printOrderDetails() {
        outputView.printMenu();
        outputView.printOrderDetails(orderDetails);
        outputView.divideLine();
    }

    public void printTotalPurchaseAmount() {
        outputView.printTotalPurchaseAmount();
        outputView.printMoney(discountCasher.getTotalPurchaseAmount());
        outputView.divideLine();

        outputView.printFreeMenu();
        outputView.printOrderDetails(discountCasher.getEventMerchandise());
        outputView.divideLine();
    }

    public void printTotalDiscountAmount() {
        outputView.printBenefit();
        outputView.printXmasDiscount(discountCasher.calculateXmasDiscount());
        outputView.printWeekDiscount(visitDay, discountCasher.calculateWeekDiscount(orderManager));
        outputView.printSpecialDiscount(discountCasher.calculateSpecialDiscount());
        outputView.printEventDiscount(discountCasher.calculateEventDiscount());
    }

}
