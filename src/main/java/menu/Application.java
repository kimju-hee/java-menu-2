package menu;

import menu.controller.MenuController;
import menu.dto.MenuBoard;
import menu.reader.ResourceReader;

public class Application {
    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourceReader();
        String path = "src/main/java/menu/reader/Foods.md";

        MenuBoard menuBoard = resourceReader.readResource(path);
        MenuController menuController = new MenuController(menuBoard);
        menuController.start();

    }
}
