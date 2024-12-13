package menu.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.dto.MenuBoard;

public class ResourceReader {
    public LinkedHashMap<String, List<String>> menu = new LinkedHashMap<>();

    public MenuBoard readResource(String path) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String resourceName = null;
            while ((resourceName = bufferedReader.readLine()) != null) {
                List<String> items = new ArrayList<>();
                String[] item = resourceName.split(",");
                String categoryName = item[0].trim();
                for (int i = 1; i < item.length; i++) {
                    items.add(item[i].trim());
                }
                menu.put(categoryName, items);
            }
        } catch (IOException e) {
            return null;
        } return new MenuBoard(menu);
    }
}