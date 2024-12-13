package menu.view.handler;

import java.util.function.Supplier;
import menu.view.ErrorView;
import menu.view.InputView;

public class InputHandler {private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public String receiveValidCoachNames() {
        return receiveValidatedInput(inputView::coachInput);
    }

    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                ErrorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}

