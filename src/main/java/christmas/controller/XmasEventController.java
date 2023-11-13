package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.OrderManager;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;
import java.util.Map.Entry;

public class XmasEventController {
    private final InputView inputView;
    private final OutputView outputView;

    public XmasEventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        getUserData();
    }

    public void getUserData() {
        outputView.printGreeting();
        inputView.readVisitDay();
        inputView.readOrderDetails();
    }

    
}
