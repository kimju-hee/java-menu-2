package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
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
    public List<String> categoryList = new ArrayList<>();
    public LinkedHashMap<String, List<String>> coachResult = new LinkedHashMap<>();

    public MenuController(MenuBoard menuBoard, OutputView outputView, InputView inputView, InputHandler inputHandler) {
        this.menuBoard = menuBoard;
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputHandler = inputHandler;
    }

    public void start() {
        inputCoachInfo();
        List<String> coaches = getCoachName();
        for (String co : coaches) {
            setInitCoachResult(co);
        }

        for (int i = 0; i < 5; i++) {
            String category = chooseCategory();
        }

        outputView.printResultFirst(categoryList);
        for (Map.Entry<String, List<String>> entry : coachResult.entrySet()) {
            String coach = entry.getKey();
            List<String> foods = entry.getValue();
            outputView.printResult(coach, foods);
        }
        outputView.printResultFinal();
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
            coaches.add(name);
        }
        return coaches;
    }

    public List<String> getCoachResultByCoachName(String coachName) {
        List<String> coachFinalFood = coachResult.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getKey(), coachName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(Collections.emptyList());
        return coachFinalFood;
    }

    public void setInitCoachResult(String coachName) {
        List<String> tempList = new ArrayList<>() {
        };
        for (Map.Entry<String, List<String>> entry : coachInfo.entrySet()) {
            String coach = entry.getKey();
            if (!coachResult.containsKey(coach)) {
                coachResult.put(coach, tempList);
            }
        }
    }

    public List<String> getCantFoodByCoachName(String coachName) {
        List<String> foundValue = coachInfo.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getKey(), coachName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(Collections.emptyList());

        return foundValue;
    }

    public void setCoachResult(String coachName, List<String> finalFood) {
        coachResult.put(coachName, finalFood);
    }

    public String chooseCategory() {
        boolean check = false;
        String ca = "";
        while (!check) {
            int num = Randoms.pickNumberInRange(1, 5);
            String category = categoryFormatter(num);
            ca = category;
            check = this.checkFrequency(category, check);
            List<String> coaches = getCoachName();
            for (String co: coaches) {
                chooseFood(ca, co);
            }
        }
        categoryList.add(ca);
        return ca;
    }

    public boolean checkFrequency(String category, boolean check) {
        int count = Collections.frequency(categoryList, category);
        if (count < 2) {
            check = true;
        }
        return check;
    }

    public String categoryFormatter(int category) {
        String temp = "";
        if (category == 1) {
            temp = "일식";
        }
        if (category == 2) {
            temp = "한식";
        }
        if (category == 3) {
            temp = "중식";
        }
        if (category == 4) {
            temp = "아시안";
        }
        if (category == 5) {
            temp = "양식";
        }
        return temp;
    }

    public void chooseFood(String category, String coachName) {
        boolean checkFood = false;
        List<String> finalFood = new ArrayList<>(getCoachResultByCoachName(coachName)); // 기존 리스트 복사
        while (!checkFood) {
            List<String> foods = menuBoard.getMenuNamesByCategories(category);
            String menu = Randoms.shuffle(foods).get(0);
            if (!finalFood.contains(menu) && !getCantFoodByCoachName(coachName).contains(menu)) {
                finalFood.add(menu);
                checkFood = true;
            }
            setCoachResult(coachName, finalFood);
        }
    }

}