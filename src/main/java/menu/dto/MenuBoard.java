package menu.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MenuBoard {
    public final LinkedHashMap<String, List<String>> menuBoard;
    public List<String> allFoodName = new ArrayList<>();
    public List<String> categories = new ArrayList<>();

    public MenuBoard(LinkedHashMap<String, List<String>> menuBoard) {
        this.menuBoard = menuBoard;
    }

    public LinkedHashMap<String, List<String>> getMenuBoard() {
        return menuBoard;
    }

    public List<String> getMenuNamesByCategories(String category) {
        List<String> foundValue = menuBoard.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getKey(), category))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(Collections.emptyList());
        return foundValue;
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

    public List<String> getCategories() {
        for (Map.Entry<String, List<String>> entry : menuBoard.entrySet()) {
            String cateName = entry.getKey();
            categories.add(cateName);
        }
        return categories;
    }
}
