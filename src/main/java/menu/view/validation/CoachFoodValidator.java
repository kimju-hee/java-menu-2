package menu.view.validation;

import java.util.List;
import menu.dto.MenuBoard;

public class CoachFoodValidator {
    private final MenuBoard menuBoard;

    private static final int MAX_FOOD_NUMBER = 2;

    public CoachFoodValidator(MenuBoard menuBoard) {
        this.menuBoard = menuBoard;
    }

    public void validator(String input) {
        String[] string = input.split(",");
        isValidName(string);
        isValidNumber(string);
        isValidMenu(string);
    }

    public void isValidName(String[] input) {
        for (String i : input) {
            if (!i.matches("^[ㄱ-ㅎ가-힣]+$")) {
                throwError();
            }
        }
    }

    public void isValidNumber(String[] input) {
        if (input.length > MAX_FOOD_NUMBER) {
            throwError2();
        }
    }

    public void isValidMenu(String[] input) {
        List<String> allMenu = menuBoard.getAllFoodName();
        for (String i : input) {
            if (!allMenu.contains(i)) {
                throwError3();
            }
        }
    }

    private void throwError() {
        throw new IllegalArgumentException(ErrorMessage.INVALID_FOOD.getMessage());
    }

    private void throwError2() {
        throw new IllegalArgumentException(ErrorMessage.INVALID_FOOD_RANGE.getMessage());
    }

    private void throwError3() {
        throw new IllegalArgumentException(ErrorMessage.INVALID_FOOD_MENU.getMessage());
    }
}
