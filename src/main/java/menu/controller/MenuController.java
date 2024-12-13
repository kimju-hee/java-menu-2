package menu.controller;

import java.util.List;
import java.util.Map;
import menu.dto.MenuBoard;

public class MenuController {
    private final MenuBoard menuBoard;

    public MenuController(MenuBoard menuBoard) {
        this.menuBoard = menuBoard;
    }

    public void start() {
        disPlayAllMenu();
    }

    public void disPlayAllMenu() {
        Map<String, List<String>> categories = menuBoard.getMenuBoard();
        for (Map.Entry<String, List<String>> entry : categories.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
