package menu.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuBoard {
    public final LinkedHashMap<String, List<String>> menuBoard;
    public List<String> allFoodName = new ArrayList<>();

    public MenuBoard(LinkedHashMap<String, List<String>> menuBoard) {
        this.menuBoard = menuBoard;
    }

    public LinkedHashMap<String, List<String>> getMenuBoard() {
        return menuBoard;
    }

    public List<String> getMenuNamesByCategories(String category) {
        return menuBoard.getOrDefault(category, List.of());
    }

    public List<String> getAllFoodName() {
        for (Map.Entry<String, List<String>> entry : menuBoard.entrySet()) {
            List<String> name = entry.getValue();
            for (String n : name) {
                allFoodName.add(n);
            }
        }
        return allFoodName;
    }
}
