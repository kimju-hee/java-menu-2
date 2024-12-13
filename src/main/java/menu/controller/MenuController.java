package menu.controller;

import java.util.List;
import java.util.Map;
import menu.dto.MenuBoard;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.handler.InputHandler;

public class MenuController {
    private final MenuBoard menuBoard;
    private final OutputView outputView;
    private final InputView inputView;
    private final InputHandler inputHandler;

    public MenuController(MenuBoard menuBoard, OutputView outputView, InputView inputView, InputHandler inputHandler) {
        this.menuBoard = menuBoard;
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputHandler = inputHandler;
    }

    public void start() {
        inputCoachNames();
    }

    public void inputCoachNames() {
        outputView.printCoachNameInputText();
        inputHandler.receiveValidCoachNames();
    }
}
