package menu.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuBoard {
    private final LinkedHashMap<String, List<String>> menuBoard;

    public MenuBoard(LinkedHashMap<String, List<String>> menuBoard) {
        this.menuBoard = menuBoard;
    }

    public LinkedHashMap<String, List<String>> getMenuBoard() {
        return menuBoard;
    }

    public List<String> getMenuNamesByCategories(String category) {
        return menuBoard.getOrDefault(category, List.of());
    }
}
