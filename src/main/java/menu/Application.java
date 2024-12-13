package menu;

import menu.controller.MenuController;
import menu.dto.MenuBoard;
import menu.reader.ResourceReader;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.handler.InputHandler;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();

        ResourceReader resourceReader = new ResourceReader();
        String path = "src/main/java/menu/reader/Foods.md";

        MenuBoard menuBoard = resourceReader.readResource(path);

        InputView inputView = new InputView(menuBoard);
        InputHandler inputHandler = new InputHandler(inputView);
        MenuController menuController = new MenuController(menuBoard, outputView, inputView, inputHandler);

        menuController.start();
    }
}
