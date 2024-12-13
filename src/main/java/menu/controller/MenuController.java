package menu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import menu.dto.MenuBoard;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.handler.InputHandler;

public class MenuController {
    private final MenuBoard menuBoard;
    private final OutputView outputView;
    private final InputView inputView;
    private final InputHandler inputHandler;

    public LinkedHashMap<String, List<String>> coachInfo = new LinkedHashMap<>();

    public MenuController(MenuBoard menuBoard, OutputView outputView, InputView inputView, InputHandler inputHandler) {
        this.menuBoard = menuBoard;
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputHandler = inputHandler;
    }

    public void start() {
        inputCoachInfo();
        List<String> coaches = getCoachName();
        for (String c: coaches) {
            getCantFoodByCoachName(c);
        }
    }

    public void inputCoachInfo() {
        outputView.printCoachNameInputText();
        String coach = inputHandler.receiveValidCoachNames();

        String[] coaches = coach.split(",");
        for (String co : coaches) {
            outputView.printCoachCantEatInputText(co);
            String food = inputHandler.receiveValidCoachFood();
            String[] foods = food.split(",");

            List<String> foodList = new ArrayList<>();
            for (String fo : foods) {
                foodList.add(fo.trim());
            }
            coachInfo.put(co, foodList);
        }
    }

    public List<String> getCoachName() {
        List<String> coaches = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : coachInfo.entrySet()) {
            String name = entry.getKey();
            System.out.println(name);
            coaches.add(name);
        }
        return coaches;
    }

    public List<String> getCantFoodByCoachName(String coachName) {
        List<String> foundValue = coachInfo.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getKey(), coachName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(Collections.emptyList());

        for (String f : foundValue) {
            System.out.println(f);
        }

        return foundValue;
    }
}
