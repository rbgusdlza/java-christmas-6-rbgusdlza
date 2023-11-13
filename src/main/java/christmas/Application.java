package christmas;

import christmas.controller.XmasEventController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        XmasEventController xmasEventController = new XmasEventController(inputView, outputView);
        xmasEventController.start();
    }
}
