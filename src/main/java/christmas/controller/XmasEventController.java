package christmas.controller;

import christmas.domain.DiscountCasher;
import christmas.domain.EventGiver;
import christmas.domain.OrderManager;
import java.util.Map;
import christmas.domain.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

public class XmasEventController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DiscountCasher discountCasher = new DiscountCasher();
    private OrderManager orderManager;
    private int visitDay;
    private Map<Menu, Integer> orderDetails;

    public XmasEventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        getDateAndOrder();
        printOrderDetails();
        printTotalPurchaseAmount();
    }

    public void getDateAndOrder() {
        outputView.printGreeting();
        visitDay = inputView.readVisitDay();
        orderDetails = inputView.readOrderDetails();
        orderManager = new OrderManager(orderDetails);
        outputView.printPreview(visitDay);
    }

    public void printOrderDetails() {
        outputView.printMenu();
        outputView.printOrderDetails(orderDetails);
        System.out.println();
    }

    public void printTotalPurchaseAmount() {
        outputView.printTotalPurchaseAmount();
        EventGiver eventGiver = new EventGiver();
        int totalPurchaseAmount = eventGiver.awardBonusMerchandise(orderManager.calculatePurchaseAmount());
        outputView.printMoney(totalPurchaseAmount);
    }
}
